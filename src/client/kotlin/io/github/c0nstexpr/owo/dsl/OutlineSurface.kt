package io.github.c0nstexpr.owo.dsl

import io.wispforest.owo.ui.core.Surface

interface OutlineSurface : SurfaceBuilder {
    var color: OwoBuilder<Int>

    override fun build() = Surface.outline(color.build())!!

    override val canBuild get() = color.canBuild
}

inline fun outlineSurfaceOf(crossinline block: OutlineSurface.() -> Unit) =
    object : OutlineSurface {
        override var color = invalidBuilder<Int>()
    }.apply(block)
