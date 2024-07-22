package io.github.c0nstexpr.owo.dsl

import io.wispforest.owo.ui.core.Surface

interface BlurSurfaceBuilder : SurfaceBuilder {
    var qualityBuilder: DslBuilder<Float>

    var sizeBuilder: DslBuilder<Float>

    override fun build() = Surface.blur(
        qualityBuilder.build(),
        sizeBuilder.build()
    )!!

    override val canBuild get() = qualityBuilder.canBuild && sizeBuilder.canBuild
}

inline fun blurSurface(crossinline block: BlurSurfaceBuilder.() -> Unit) =
    object : BlurSurfaceBuilder {
        override var qualityBuilder = invalidBuilder<Float>()

        override var sizeBuilder = invalidBuilder<Float>()
    }.apply(block)
