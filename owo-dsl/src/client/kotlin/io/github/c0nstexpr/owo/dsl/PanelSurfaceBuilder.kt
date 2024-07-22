package io.github.c0nstexpr.owo.dsl

import io.wispforest.owo.ui.core.Surface

interface PanelSurfaceBuilder : SurfaceBuilder {
    var insetWidth: DslBuilder<Int>

    override fun build() = Surface.panelWithInset(insetWidth.build())!!

    override val canBuild get() = insetWidth.canBuild
}

inline fun panelSurface(crossinline block: PanelSurfaceBuilder.() -> Unit) =
    object : PanelSurfaceBuilder {
        override var insetWidth = invalidBuilder<Int>()
    }.apply(block)
