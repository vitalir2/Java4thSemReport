plugins {
    java
}

group = "io.vitalir"
version = "1.0"

repositories {
    mavenCentral()
}

java {
    version = JavaVersion.VERSION_11
}

dependencies {
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.6.0")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine")
}

tasks.getByName<Test>("test") {
    useJUnitPlatform()
}

tasks.register<Exec>("myJar") {
    setDependsOn(listOf("build"))
    executable = "jar"
    setArgs(listOf("cfe", ".docker/main.jar", "task9.Main", "-C", "build/classes/java/main/", "task9/Main.class"))
}

tasks.register<Exec>("myDockerBuild") {
    setDependsOn(listOf("myJar"))
    executable = "docker"
    setArgs(listOf("image", "build", ".", "-t", MY_CONTAINER))
}

tasks.register<Exec>("task9") {
    setDependsOn(listOf("myDockerBuild"))
    executable = "docker"
    setArgs(listOf("container", "run", MY_CONTAINER))
}

val MY_CONTAINER = "my_container"
