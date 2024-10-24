plugins {
    id("org.jetbrains.kotlin.jvm") version "2.0.21"
    id("org.jetbrains.kotlin.plugin.allopen") version "2.0.21"
    id("com.google.devtools.ksp") version "2.0.21-1.0.25"
    id("org.jetbrains.kotlin.plugin.jpa") version "2.0.21"
    id("com.github.johnrengelman.shadow") version "8.1.1"
    id("io.micronaut.application") version "4.4.3"
    id("io.micronaut.test-resources") version "4.4.3"
}

version = "0.1"
group = "demo"

val kotlinVersion = project.properties["kotlinVersion"]
repositories {
    mavenCentral()
}

dependencies {
    ksp("io.micronaut.data:micronaut-data-processor")
    ksp("io.micronaut:micronaut-http-validation")
    ksp("io.micronaut.serde:micronaut-serde-processor")
    implementation("io.micronaut.data:micronaut-data-hibernate-jpa")
    implementation("io.micronaut.flyway:micronaut-flyway")
    implementation("io.micronaut.kotlin:micronaut-kotlin-runtime")
    implementation("io.micronaut.serde:micronaut-serde-jackson")
    implementation("io.micronaut.sql:micronaut-jdbc-hikari:")
    implementation("org.jetbrains.kotlin:kotlin-reflect:${kotlinVersion}")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8:${kotlinVersion}")
    compileOnly("io.micronaut:micronaut-http-client")
    runtimeOnly("ch.qos.logback:logback-classic")
    runtimeOnly("com.fasterxml.jackson.module:jackson-module-kotlin")
    runtimeOnly("com.mysql:mysql-connector-j")
    runtimeOnly("org.flywaydb:flyway-mysql")
    testImplementation("io.micronaut:micronaut-http-client")
}

micronaut {
    runtime("netty")
    testRuntime("kotest5")
    processing {
        incremental(true)
        annotations("demo.*")
    }
}

application {
    mainClass = "demo.ApplicationKt"
}
java {
    sourceCompatibility = JavaVersion.toVersion("21")
}


graalvmNative.toolchainDetection = false

tasks.named<io.micronaut.gradle.docker.NativeImageDockerfile>("dockerfileNative") {
    jdkVersion = "21"
}


