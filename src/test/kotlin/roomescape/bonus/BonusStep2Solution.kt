package roomescape.bonus

import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.cancelAndJoin
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.retryWhen
import kotlinx.coroutines.launch
import kotlinx.coroutines.test.runTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class BonusStep2Solution {

    private var firstTryFlag = true

    private fun search(keyword: String): Flow<String> {
        if (firstTryFlag) {
            firstTryFlag = false
            throw RuntimeException("Network Error")
        }
        return flow { emit(keyword) }
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun `하나의 스트림을 cancel 하지 말고 지속가능하게 만들 수 있는가`() = runTest {
        // given
        val searchResults = mutableListOf<String>()

        // when
        val retry = MutableStateFlow(true)
        val keywordFlow: MutableStateFlow<String> = MutableStateFlow("")

        val collectorJob = launch {
            retry
                .filter { it }
                .onEach { retry.value = false }
                .flatMapLatest {
                    flowOf(true)
                        .flatMapLatest { keywordFlow }
                        .flatMapLatest { keyword -> search(keyword) }
                        .retryWhen { _, _ -> retry.first { it } }
                        .catch { error -> println("Error: ${error.message}") }
                }
                .onEach {
                    searchResults.add(it)
                }
                .collect()
        }
        val emitterJob = launch {
            keywordFlow.value = "first"
            delay(100)
            assertThat(searchResults).isEmpty() // 에러로 인해 결과가 없어야 함

            // 재시도 시나리오
            retry.value = true
            keywordFlow.value = "second"
            delay(100)
            assertThat(searchResults).containsExactly("second") // 두 번째 검색 결과가 존재해야 함
        }

        emitterJob.join()
        collectorJob.cancelAndJoin()
    }
}
