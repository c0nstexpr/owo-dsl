package io.github.c0nstexpr.owo.dsl

import io.wispforest.owo.ui.core.Surface

interface TiledSurface : SurfaceBuilder {
    var texture: IdentifierBuilder

    var textureWidth: DslBuilder<Int>

    var textureHeight: DslBuilder<Int>

    override fun build() = Surface.tiled(
        texture.build(),
        textureWidth.build(),
        textureHeight.build()
    )!!

    override val canBuild
        get() = texture.canBuild && textureWidth.canBuild && textureHeight.canBuild
}

inline fun titledSurface(crossinline block: TiledSurface.() -> Unit) = object : TiledSurface {
    override var texture = identifier()

    override var textureWidth = invalidBuilder<Int>()

    override var textureHeight = invalidBuilder<Int>()
}.apply(block)
