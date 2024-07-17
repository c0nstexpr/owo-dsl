plugins {
    `fabric-common`
}

repositories {
    maven("https://maven.terraformersmc.com")
    maven("https://maven.wispforest.io")
}

dependencies {
    implementation(project(":", "namedElements"))
    modImplementation(libs.modmenu)
}
