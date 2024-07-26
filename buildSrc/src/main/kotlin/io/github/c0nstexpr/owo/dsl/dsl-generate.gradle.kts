plugins {
    id("kotlin-common")
}

tasks {
    val generate = register<Task>("generate") {
        doLast {
        }
    }

    build { dependsOn(generate) }
}
