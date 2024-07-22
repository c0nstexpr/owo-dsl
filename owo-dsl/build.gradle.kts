plugins {
    `fabric-common`
}

repositories {
    maven("https://maven.wispforest.io")
}

dependencies {
    modApi(libs.owo)
    listOf(libs.bundles.reaktive).forEach {
        api(it)
        include(it)
    }
}

tasks {
    processResources {
        doFirst {
            fabricProperty {
                put("owo", libs.versions.owo)
                put("fabricKotlin", libs.versions.fabric.kotlin)
            }
        }
    }
}
