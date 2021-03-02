import kr.entree.spigradle.kotlin.*
plugins {
    java
    kotlin("jvm") version "1.4.10"
    id("kr.entree.spigradle") version "2.2.3"
}

group = "cc.squirtle"
version = "0.2"

repositories {
    maven{url = uri("https://hub.spigotmc.org/nexus/content/repositories/snapshots/")}
    maven{url = uri("https://maven.aliyun.com/repository/google")}
    maven{url = uri("https://maven.aliyun.com/repository/public")}
    maven{url = uri("https://maven.aliyun.com/repository/jcenter")}
}


dependencies {
    implementation(kotlin("stdlib"))
    compileOnly(spigot("1.16.5"))
    testCompile("junit", "junit", "4.12")
}
