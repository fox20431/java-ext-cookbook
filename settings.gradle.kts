rootProject.name = "java-ext-cookbook"

plugins {
    id("com.gradle.enterprise") version "3.12.6"
}

include("h2-database")
include("tomcat")
include("tomcat-embed")
include("jdbc")
include("rxjava")
include("reactor")
include("jackson")
include("log")
include("apache-commons")
include("wiremock")
include("testcontainers")
include("redis")
include("kafka")
include("aspectj")
include("elk")
