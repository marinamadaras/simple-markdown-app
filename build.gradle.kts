plugins {
    kotlin("jvm")
}
dependencies {
    implementation(kotlin("stdlib-jdk8"))
    testImplementation("org.junit.jupiter:junit-jupiter:5.8.2")
    testImplementation("org.mockito:mockito-core:3.12.4")
    testImplementation("org.assertj:assertj-core:3.23.1")
}
repositories {
    mavenCentral()
}
kotlin {
    jvmToolchain(8)
}

tasks{
    test {
        useJUnitPlatform()
    }
}