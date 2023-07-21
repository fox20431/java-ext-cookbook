plugins {
    id("io.freefair.aspectj.post-compile-weaving") version "8.1.0"
}

group="com.hihusky.aspectj"
version="1.0-SNAPSHOT"

dependencies {
    implementation("junit:junit:4.13.1")
    implementation("org.aspectj", "aspectjrt","1.9.19")
    implementation("org.aspectj", "aspectjweaver", "1.9.19")
}

