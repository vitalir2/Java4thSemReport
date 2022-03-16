plugins {
    id("org.springframework.boot") version "2.6.4"
    id("io.spring.dependency-management") version "1.0.11.RELEASE"
    id("java")
    id("io.freefair.lombok") version "6.4.1"
}

group = "com.example"
version = "0.0.1-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springframework.boot:spring-boot-starter-actuator")
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    implementation("org.springframework.boot:spring-boot-starter-security")
    implementation("org.springframework.boot:spring-boot-starter-thymeleaf")
    implementation("org.springframework:spring-context:5.3.16")
    implementation("ch.qos.logback:logback-classic:1.2.11")
    implementation("org.slf4j:jcl-over-slf4j:1.7.36")
    implementation("org.postgresql:postgresql")
    testImplementation("org.springframework.boot:spring-boot-starter-test")
}

tasks.named<Test>("test") {
    useJUnitPlatform()
}
