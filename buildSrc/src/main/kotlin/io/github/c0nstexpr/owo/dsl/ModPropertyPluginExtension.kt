package io.github.c0nstexpr.owo.dsl

import org.gradle.api.provider.MapProperty

interface ModPropertyPluginExtension {
    val properties: MapProperty<String, String>
}
