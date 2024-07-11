package org.c0nstexpr.owo.dsl

import io.wispforest.owo.ui.core.Surface

open class BlurSurfaceBuilder : SurfaceBuilder {
    var quality = invalidBuilder<Float>()

    var size = invalidBuilder<Float>()

    override fun build() = Surface.blur(quality.build(), size.build())!!

    override val canBuild get() = quality.canBuild && size.canBuild
}
