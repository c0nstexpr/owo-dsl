plugins {
    `fabric-common`
}

repositories {
    maven("https://maven.terraformersmc.com")
}

dependencies {
    implementation(project(":", "namedElements"))
    modImplementation(libs.modmenu)
}
