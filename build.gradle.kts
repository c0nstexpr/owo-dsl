plugins {
    `fabric-common`
    alias(libs.plugins.minotaur)
}

repositories {
    maven("https://maven.wispforest.io")
    maven("https://maven.terraformersmc.com")
}

dependencies {
    modApi(libs.owo)
    listOf(libs.bundles.reaktive).forEach {
        api(it)
        include(it)
    }
    modClientRuntimeOnly(libs.modmenu)
}

tasks {
    this.modrinth { dependsOn(remapJar, modrinthSyncBody) }

    processResources {
        doFirst {
            fabricProperty {
                put("owo", libs.versions.owo)
                put("fabricKotlin", libs.versions.fabric.kotlin)
            }
        }
    }
}

System.getenv().getOrDefault("MODRINTH_TOKEN", null)?.let {
    modrinth {
        // projectId.set("rjuXQb7H")
        token.set(it)
        versionNumber.set(version.toString())
        versionType.set("beta")
        uploadFile.set(tasks.remapJar.get())
        loaders.add("fabric")
        syncBodyFrom.set(rootProject.file("README.md").readText())
    }
}
