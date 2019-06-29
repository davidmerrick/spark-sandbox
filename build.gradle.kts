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
    implementation("com.amazonaws.serverless:aws-serverless-java-container-spark:1.3.2")
}

val deployDev = tasks.create<Exec>("deployDev") {
    commandLine = listOf("serverless", "deploy", "--stage=dev")
}

val deployPrd = tasks.create<Exec>("deployPrd") {
    commandLine = listOf("serverless", "deploy", "--stage=prd")
}

// Alias for deploy dev
val deploy = tasks.create("deploy")
deploy.dependsOn(deployDev)

deployDev.dependsOn(tasks.getByName("shadowJar"))
deployPrd.dependsOn(tasks.getByName("shadowJar"))

val compileKotlin: KotlinCompile by tasks
compileKotlin.kotlinOptions {
    jvmTarget = "1.8"
}

val compileTestKotlin: KotlinCompile by tasks
compileTestKotlin.kotlinOptions {
    jvmTarget = "1.8"
}