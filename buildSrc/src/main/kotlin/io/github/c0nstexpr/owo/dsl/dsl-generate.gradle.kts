plugins {
    id("kotlin-common")
    id("com.google.devtools.ksp")
}

val processorProj = project(":processor")

dependencies {
    implementation(processorProj)
    ksp(processorProj)
}
