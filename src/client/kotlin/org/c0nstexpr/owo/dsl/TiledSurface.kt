package org.c0nstexpr.owo.dsl

import io.wispforest.owo.ui.core.Surface

open class TiledSurface : SurfaceBuilder {
    var texture = IdentifierBuilder()

    var textureWidth: Int = 0

    var textureHeight: Int = 0

    override fun build() = texture.build()?.let { Surface.tiled(it, textureWidth, textureHeight) }
}
