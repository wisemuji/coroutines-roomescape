package roomescape.bonus

import kotlinx.coroutines.cancelAndJoin
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch
import kotlinx.coroutines.test.runTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class BonusStep2 {

    private var firstTryFlag = true

    private fun search(keyword: String): Flow<String> {
        if (firstTryFlag) {
            firstTryFlag = false
            throw RuntimeException("Network Error")
        }
        return flow { emit(keyword) }
    }

    @Test
    fun `하나의 스트림을 cancel 하지 말고 지속가능하게 만들 수 있는가`() = runTest {
        // given
        val searchResults = mutableListOf<String>()

        // when
        val retry = MutableStateFlow(true)
        val keywordFlow: MutableStateFlow<String> = MutableStateFlow("")

        val collectorJob = launch {
            // TODO: retry, keywordFlow, searchResults를 이용하여 검색 결과를 수집하는 로직을 작성해보세요.
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
