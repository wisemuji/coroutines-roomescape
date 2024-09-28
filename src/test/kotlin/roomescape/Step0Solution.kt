package roomescape

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.cancelAndJoin
import kotlinx.coroutines.delay
import kotlinx.coroutines.ensureActive
import kotlinx.coroutines.launch
import kotlinx.coroutines.test.runTest
import org.assertj.core.api.Assertions.assertThat
import kotlin.test.Test

class Step0Solution {

    @Test
    fun `연습 문제`() = runTest {
        val job = launch(Dispatchers.IO) {
            repeat(1_000_000) {
                Thread.sleep(1_000)
                println("Not cancelled yet :(")

                ensureActive()
            }
        }
        delay(100)
        job.cancelAndJoin()
        assertThat(job.isCancelled).isTrue()
    }
}
