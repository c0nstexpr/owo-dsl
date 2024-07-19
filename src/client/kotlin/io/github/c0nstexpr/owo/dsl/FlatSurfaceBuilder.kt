package io.github.c0nstexpr.owo.dsl

import io.wispforest.owo.ui.core.Surface

interface FlatSurfaceBuilder : SurfaceBuilder {
    var color: DslBuilder<Int>

    override fun build() = Surface.flat(color.build())!!

    override val canBuild get() = color.canBuild
}

inline fun flatSurface(crossinline block: FlatSurfaceBuilder.() -> Unit) =
    object : FlatSurfaceBuilder {
        override var color = invalidBuilder<Int>()
    }.apply(block)
