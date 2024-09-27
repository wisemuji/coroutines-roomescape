package roomescape

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.cancelAndJoin
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.test.runTest
import org.assertj.core.api.Assertions.assertThat
import kotlin.test.Test

class Step0 {

    @Test
    fun `연습 문제`() = runTest {
        val job = launch(Dispatchers.IO) {
            repeat(1_000_000) {
                Thread.sleep(1_000)
                println("Not cancelled yet :(")

                // TODO: 이곳에 한 줄만 추가하여 코루틴이 정상적으로 취소되도록 만들어보세요.
            }
        }
        delay(100)
        job.cancelAndJoin()
        assertThat(job.isCancelled).isTrue()
    }
}
