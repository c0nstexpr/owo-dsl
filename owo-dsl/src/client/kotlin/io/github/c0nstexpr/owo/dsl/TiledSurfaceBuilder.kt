package io.github.c0nstexpr.owo.dsl

import io.github.c0nstexpr.owo.dsl.DslBuilder.Companion.built
import io.wispforest.owo.ui.core.Surface

open class TiledSurfaceBuilder(
    var texture: DslBuilder<Id> = nullBuilder(),
    var textureWidth: Int = 0,
    var textureHeight: Int = 0
) : DslBuilder<Surface> by dslBuilder({
        Surface.tiled(texture.built ?: return@dslBuilder null, textureWidth, textureHeight)
    })
