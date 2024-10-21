plugins {
    alias(libs.plugins.jvm)
    `java-library`

    id("org.jreleaser") version "1.14.0"
}

group = "dev.enderman"
version = "0.0.1"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation("org.jetbrains.kotlin:kotlin-test-junit5")
    testImplementation(libs.junit.jupiter.engine)
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")

    api(libs.commons.math3)
    implementation(libs.guava)
}

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(21)
    }
}

tasks.named<Jar>("jar") {
    archiveFileName.set("${rootProject.name}-${project.version}.jar")
}

tasks.named<Test>("test") {
    useJUnitPlatform()
}

jreleaser {
    project {
        authors = listOf("Esoteric Enderman")
        license = "MIT"
        links {
            homepage = "https://github.com/EsotericThought/library"
        }
        inceptionYear = "2024"
    }

    release {
        github {
            repoOwner = "EsotericThought"
            overwrite = true
        }
    }
}
