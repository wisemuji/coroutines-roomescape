package roomescape.assertion

import org.assertj.core.api.Assertions.assertThat

fun assertHashcode(actualEmitStates: StringBuilder, expectedEmitStates: String) {
    assertThat(actualEmitStates.toString().hashCode()).isEqualTo(expectedEmitStates.hashCode())
}
