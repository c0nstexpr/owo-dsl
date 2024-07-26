package io.github.c0nstexpr.owo.dsl

import org.gradle.api.Project
import org.gradle.api.artifacts.VersionCatalog
import org.gradle.api.artifacts.VersionCatalogsExtension
import org.gradle.api.provider.MapProperty
import org.gradle.api.tasks.SourceSet
import org.gradle.api.tasks.SourceSetContainer
import org.gradle.kotlin.dsl.get
import org.gradle.kotlin.dsl.getByType

inline fun Project.fabricProperty(block: MapProperty<String, String>.() -> Unit) =
    block(extensions.getByType(ModPropertyPluginExtension::class.java).properties)

inline val Project.versionCatalog: VersionCatalog
    get() = extensions.getByType<VersionCatalogsExtension>().named("libs")

inline val Project.sourceSets get() = extensions.getByType<SourceSetContainer>()

inline val Project.srcClient: SourceSet get() = sourceSets["client"]

inline val Project.srcMain: SourceSet get() = sourceSets["main"]
