package io.github.c0nstexpr.owo.dsl

import org.gradle.api.artifacts.VersionCatalog

class VCVersionsAccess internal constructor(versionCatalog: VersionCatalog) :
    VersionCatalog by versionCatalog {
        operator fun get(name: String): String = getByName(name, VersionCatalog::findVersion).run {
            requiredVersion.ifEmpty { strictVersion.ifEmpty { preferredVersion } }
        }
    }
