package roomescape

import kotlinx.coroutines.test.runTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import java.security.MessageDigest

private fun encrypt(target: String): String {
    val bytes = MessageDigest.getInstance("SHA-256").digest(target.toByteArray())
    return bytes.joinToString("") { "%02x".format(it) }
}

class FinalStep {

    @Test
    fun `단서 조합`() = runTest {
        val step1 = "" // TODO: step1 풀이과정 작성
        val step2 = "" // TODO: step2 풀이과정 작성
        val step3 = "" // TODO: step3 풀이과정 작성
        val step4 = "" // TODO: step4 풀이과정 작성

        val actual = encrypt(step1 + step2 + step3 + step4)
        val answer = "fd12428384995a0cab2c06bd2fb10ce78b3364fa87fb90065b69f5ddd7e6ba91"

        assertThat(actual).isEqualTo(answer)
    }
}
