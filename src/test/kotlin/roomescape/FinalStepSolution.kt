package roomescape

import kotlinx.coroutines.test.runTest
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import java.security.MessageDigest

private fun encrypt(target: String): String {
    val bytes = MessageDigest.getInstance("SHA-256").digest(target.toByteArray())
    return bytes.joinToString("") { "%02x".format(it) }
}

class FinalStepSolution {

    @Test
    fun `단서 조합`() = runTest {
        val step1 = "42315"
        val step2 = "1223344"
        val step3 = "E21"
        val step4 = "true"

        val actual = encrypt(step1 + step2 + step3 + step4)
        val answer = "fd12428384995a0cab2c06bd2fb10ce78b3364fa87fb90065b69f5ddd7e6ba91"

        Assertions.assertThat(actual).isEqualTo(answer)
    }
}
