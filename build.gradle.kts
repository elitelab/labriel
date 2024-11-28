plugins {
    kotlin("jvm") version "2.0.0"
    id("com.ncorti.ktfmt.gradle") version "0.19.0"
    id("app.cash.sqldelight") version "2.0.2"
    id("com.github.johnrengelman.shadow") version "8.1.1"
    id("org.flywaydb.flyway") version "10.16.0"
}

group = "io.runelab"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation("com.michael-bull.kotlin-inline-logger:kotlin-inline-logger:1.0.6")
    implementation("org.slf4j:slf4j-api:2.0.13")
    implementation("ch.qos.logback:logback-classic:1.5.6")

    implementation("app.cash.sqldelight:sqlite-driver:2.0.2")
    implementation("org.flywaydb:flyway-core:10.16.0")


    implementation("org.javacord:javacord:3.8.0")
    testImplementation(kotlin("test"))
}

tasks.test {
    useJUnitPlatform()
}
kotlin {
    jvmToolchain(21)
}

ktfmt {
    kotlinLangStyle()
}

sqldelight {
    databases {
        create("Database") {
            packageName.set("io.runelab")
            schemaOutputDirectory.set(file("src/main/sqldelight/databases"))
        }
    }
}
