plugins {
    alias(libs.plugins.jvm)
    `java-library`
    `maven-publish`
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

publishing {
    publications {
        create<MavenPublication>("mavenJava") {
            from(components["java"])
            groupId = group.toString()
            artifactId = rootProject.name
            version = project.version.toString()

            pom {
                name.set(rootProject.name)
                description.set("An extensive (mostly) math library following a logical and coherent structure with great levels of abstraction.")
                url.set("https://github.com/EsotericThought/library")
                packaging = "jar"

                licenses {
                    license {
                        name.set("MIT License")
                        url.set("https://github.com/EsotericThought/library/blob/main/LICENSE")
                    }
                }

                developers {
                    developer {
                        id.set("esotericenderman")
                        name.set("Esoteric Enderman")
                        email.set("esotericenderman@gmail.com")
                    }
                }

                scm {
                    connection.set("scm:git:git://github.com/EsotericThought/library.git")
                    developerConnection.set("scm:git:ssh://github.com:EsotericThought/library.git")
                    url.set("https://github.com/EsotericThought/library")
                }
            }
        }
    }

    repositories {
        maven {
            name = "OSSRH"
            url = uri("https://s01.oss.sonatype.org/service/local/staging/deploy/maven2/")

            credentials {
                username = project.findProperty("ossrhUsername") as String? ?: ""
                password = project.findProperty("ossrhPassword") as String? ?: ""
            }
        }
    }
}
