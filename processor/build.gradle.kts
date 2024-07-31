plugins { `kotlin-common` }

repositories { maven("https://oss.sonatype.org/content/repositories/snapshots") }

dependencies { implementation(libs.bundles.ksp) }
