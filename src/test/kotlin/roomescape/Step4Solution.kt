package roomescape

import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.cancelAndJoin
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import kotlinx.coroutines.test.runTest
import org.junit.jupiter.api.Test
import roomescape.assertion.assertHashcode

class Step4Solution {

    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun `StateFlow와 SharedFlow`() = runTest {
        // given
        val actual: StringBuilder = StringBuilder()

        val a = MutableStateFlow(1)
        val b = MutableStateFlow(true)
        val c = MutableSharedFlow<Boolean>()

        // when
        val collectorJob = launch {
            a
                .flatMapLatest { b.filter { it } }
                .flatMapLatest { c.filter { it } }
                .onEach { actual.append(it) }
                .collect()
        }
        val emitterJob = launch {
            delay(100)
            c.emit(true)
            b.value = false
            a.value = 10
            c.emit(false)
            b.value = true
            a.value = 5
        }
        emitterJob.join()
        collectorJob.cancelAndJoin()

        // then
        val expected = "true"

        // assert문 수정하지 마세요!
        assertHashcode(actual, expected)
    }
}
