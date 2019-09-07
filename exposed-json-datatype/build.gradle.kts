group = "json-datatype"
version = "0.0.1"

plugins {
    id("org.jetbrains.kotlin.jvm").version("1.3.10")
    application
}

application {
    mainClassName = "com.jetherrodrigues.application.ApplicationKt"
}

tasks.withType<Jar> {
    manifest {
        attributes(
                mapOf(
                        "Main-Class" to application.mainClassName
                )
        )
    }
}

repositories {
    jcenter()
    mavenCentral()
}

dependencies {
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
    implementation("io.javalin:javalin:3.4.1")
    implementation("com.fasterxml.jackson.core:jackson-databind:2.9.8")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin:2.9.8")
    implementation("org.koin:koin-core:1.0.2")
    implementation("org.valiktor:valiktor-core:0.8.0")

    implementation ("io.azam.ulidj:ulidj:1.0.0")
    implementation ("org.jetbrains.exposed:exposed:0.16.1")
    implementation ("com.zaxxer:HikariCP:3.3.0")
    implementation ("org.postgresql:postgresql:42.2.2")

    testImplementation("org.jetbrains.kotlin:kotlin-test")
    testImplementation("org.jetbrains.kotlin:kotlin-test-junit")

    compile("org.slf4j", "slf4j-log4j12" , "1.7.26")
    compile("log4j", "log4j", "1.2.17")
}