plugins {
    id("kotlin-common")
    id("com.google.devtools.ksp")
}

repositories { maven("https://oss.sonatype.org/content/repositories/snapshots") }

val processorProj = project(":processor")

dependencies {
    implementation(processorProj)
    ksp(processorProj)
}
