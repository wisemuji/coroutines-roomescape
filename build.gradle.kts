plugins {
    kotlin("jvm") version "2.0.20"
}

group = "com.wisemuji"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.jetbrains.kotlinx", "kotlinx-coroutines-core", "1.8.1")
    testImplementation("org.jetbrains.kotlinx", "kotlinx-coroutines-test", "1.8.1")
    testImplementation(kotlin("test"))
    testImplementation("org.assertj", "assertj-core", "3.25.3")
}

tasks.test {
    useJUnitPlatform()
}
kotlin {
    jvmToolchain(21)
}
