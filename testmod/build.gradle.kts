plugins {
    `fabric-common`
}

repositories {
    maven("https://maven.terraformersmc.com")
    maven("https://maven.wispforest.io")
}

dependencies {
    api(project(":owo-dsl", "namedElements"))

    listOf(libs.owo, libs.modmenu).forEach(::modImplementation)
}
