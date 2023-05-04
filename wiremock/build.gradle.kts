group="com.hihusky.wiremock"
version="1.0-SNAPSHOT"

java {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
}

dependencies {
    testImplementation("com.github.tomakehurst:wiremock-jre8-standalone:2.35.0")
}