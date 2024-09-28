package roomescape

import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.test.runTest
import org.junit.jupiter.api.Test
import roomescape.assertion.assertHashcode

class Step1Solution {

    @Test
    fun `종류별 Scope`() = runTest {
        // given
        val actual: StringBuilder = StringBuilder()

        // when
        val deferred = async {
            delay(500)
            actual.append(1)
        }
        launch {
            delay(200)
            actual.append(2)
        }
        coroutineScope {
            launch {
                delay(300)
                actual.append(3)
            }
            actual.append(4)
        }
        deferred.await()
        actual.append(5)

        // then
        val expected = "42315"

        // assert문 수정하지 마세요!
        assertHashcode(actual, expected)
    }
}

