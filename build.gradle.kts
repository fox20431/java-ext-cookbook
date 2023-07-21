plugins {
    java
}

group = "com.hihusky"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
    google()
    gradlePluginPortal()
}

subprojects {

    apply(plugin = "java")

    repositories {
        mavenCentral()
    }

    java {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }

    dependencies {
        // log
        implementation("org.slf4j:slf4j-api:2.0.5")
        implementation("ch.qos.logback:logback-core:${property("logbackVersion")}")
        implementation("ch.qos.logback:logback-classic:${property("logbackVersion")}")

        // lombok
        implementation("org.projectlombok:lombok:${property("lombokVersion")}")
        annotationProcessor("org.projectlombok:lombok:${property("lombokVersion")}")
        testImplementation("org.projectlombok:lombok:${property("lombokVersion")}")
        testAnnotationProcessor("org.projectlombok:lombok:${property("lombokVersion")}")

        // junit
        testImplementation(platform("org.junit:junit-bom:${property("junitVersion")}"))
        testImplementation("org.junit.jupiter:junit-jupiter:${property("junitVersion")}")
    }

    tasks.withType<Test> {
        useJUnitPlatform()
    }
}

