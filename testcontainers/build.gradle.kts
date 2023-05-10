group = "com.hihusky.testcontainers"
version = "1.0-SNAPSHOT"

dependencies {
    // mysql driver
    implementation("mysql:mysql-connector-java:8.0.28")

    testImplementation("org.testcontainers:testcontainers:1.18.0")
    testImplementation("org.testcontainers:mysql:1.18.0")
}
