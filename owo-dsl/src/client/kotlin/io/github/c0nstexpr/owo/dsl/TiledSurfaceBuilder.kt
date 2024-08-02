package io.github.c0nstexpr.owo.dsl

import io.wispforest.owo.ui.core.Surface

open class TiledSurfaceBuilder(
    var texture: DslBuilder<Id> = nullBuilder(),
    var textureWidth: Int = 0,
    var textureHeight: Int = 0
) : DslBuilder<Surface> by dslBuilder({
        Surface.tiled(texture.value ?: return@dslBuilder null, textureWidth, textureHeight)
    })
