import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

group = "com.merricklabs.sparksandbox"

repositories {
    mavenCentral()
    jcenter()
}

plugins {
    id("de.fayard.buildSrcVersions") version "0.3.2"
    kotlin("jvm") version "1.3.40"
    id("com.github.johnrengelman.shadow") version "5.0.0"
}

dependencies {
    implementation("com.sparkjava:spark-core:2.9.1")
    implementation(kotlin("stdlib-jdk8"))
}

val compileKotlin: KotlinCompile by tasks
compileKotlin.kotlinOptions {
    jvmTarget = "1.8"
}
val compileTestKotlin: KotlinCompile by tasks
compileTestKotlin.kotlinOptions {
    jvmTarget = "1.8"
}