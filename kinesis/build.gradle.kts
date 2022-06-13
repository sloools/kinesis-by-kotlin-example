import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id("org.springframework.boot") version "2.7.0"
    id("io.spring.dependency-management") version "1.0.11.RELEASE"
    kotlin("jvm") version "1.6.21"
    kotlin("plugin.spring") version "1.6.21"
}

group = "com.example"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_1_8

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter")
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
    testImplementation("org.springframework.boot:spring-boot-starter-test")
    //kinesisClient
    implementation("software.amazon.kinesis:amazon-kinesis-client:2.4.1")
    //sdk
    implementation(platform("software.amazon.awssdk:bom:2.15.0"))
    implementation("software.amazon.awssdk:sts")
    implementation("software.amazon.awssdk:aws-crt-client:2.17.189-PREVIEW")
    implementation("com.amazonaws:amazon-kinesis-client:1.14.8")

    annotationProcessor("org.springframework.boot:spring-boot-configuration-processor")

}

tasks.withType<KotlinCompile> {
    kotlinOptions {
        freeCompilerArgs = listOf("-Xjsr305=strict")
        jvmTarget = "1.8"
    }
}

tasks.withType<Test> {
    useJUnitPlatform()
}
