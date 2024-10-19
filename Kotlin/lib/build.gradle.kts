plugins {
    alias(libs.plugins.jvm)
    `java-library`
    `maven-publish` // Add maven-publish plugin
    signing          // Add signing plugin
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
            groupId = "dev.enderman"
            artifactId = rootProject.name
            version = project.version.toString()

            pom {
                name.set(rootProject.name)
                description.set("Your project description here")
                url.set("https://your.project.url") // Update with your project URL

                licenses {
                    license {
                        name.set("The Apache License, Version 2.0")
                        url.set("https://www.apache.org/licenses/LICENSE-2.0.txt")
                    }
                }

                developers {
                    developer {
                        id.set("esoteric-enderman")
                        name.set("Esoteric Enderman")
                        email.set("your.email@example.com")
                    }
                }

                scm {
                    connection.set("scm:git:git://github.com/your_username/your_project.git")
                    developerConnection.set("scm:git:ssh://github.com:your_username/your_project.git")
                    url.set("https://github.com/your_username/your_project")
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

signing {
    useGpgCmd() // Use GPG for signing the artifacts
    sign(publishing.publications["mavenJava"])
}
