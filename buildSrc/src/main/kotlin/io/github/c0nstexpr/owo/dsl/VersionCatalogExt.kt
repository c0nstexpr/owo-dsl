package io.github.c0nstexpr.owo.dsl

import org.gradle.api.artifacts.VersionCatalog
import java.util.Optional

inline fun <R> VersionCatalog.getByName(
    name: String,
    block: VersionCatalog.(String) -> Optional<R>
) = block(name).get()

operator fun VersionCatalog.get(name: String) = getByName(name, VersionCatalog::findLibrary)

val VersionCatalog.bundles get() = VCBundleAccess(this)

val VersionCatalog.versions get() = VCVersionsAccess(this)
