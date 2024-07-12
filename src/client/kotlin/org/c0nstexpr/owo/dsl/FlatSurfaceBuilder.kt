package org.c0nstexpr.owo.dsl

import io.wispforest.owo.ui.core.Surface

interface FlatSurfaceBuilder : SurfaceBuilder {
    var color: OwoBuilder<Int>

    override fun build() = Surface.flat(color.build())!!

    override val canBuild get() = color.canBuild
}

inline fun flatSurface(crossinline block: FlatSurfaceBuilder.() -> Unit) =
    object : FlatSurfaceBuilder {
        override var color = invalidBuilder<Int>()
    }.apply(block)
