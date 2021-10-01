@file:Suppress("HardCodedStringLiteral")

val kotlinxSerializationVersion = "1.3.0"

plugins {
    kotlin("js") version "1.5.31"
    kotlin("plugin.serialization") version "1.5.31"
}

group = "com.camline.space.test"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation ("org.jetbrains.kotlinx:kotlinx-serialization-json:$kotlinxSerializationVersion")
    implementation ("org.jetbrains.kotlinx:kotlinx-datetime:0.3.0")

    testImplementation(kotlin("test"))
}

kotlin {
    js(LEGACY) {
        binaries.executable()
        browser {
            commonWebpackConfig {
                cssSupport.enabled = true
            }
        }
    }
}