import org.gradle.kotlin.dsl.`maven-publish`

plugins {
    id("kotlin-common")
    `maven-publish`
}

val modId: String by project

publishing {
    publications {
        create<MavenPublication>("maven") {
            groupId = group.toString()
            artifactId = modId
            version = version.toString()

            from(components["java"])
        }
    }
}
