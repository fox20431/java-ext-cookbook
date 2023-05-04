group = "org.example"
version = "1.0-SNAPSHOT"

dependencies {
    implementation("org.apache.tomcat.embed:tomcat-embed-core:10.1.7")
    implementation("org.apache.tomcat.embed:tomcat-embed-jasper:10.1.7")
}

tasks.withType<Test> {
    useJUnitPlatform()
    testLogging {
        events("passed", "skipped", "failed")
    }
}