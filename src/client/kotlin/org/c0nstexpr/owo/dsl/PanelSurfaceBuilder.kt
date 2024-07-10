package org.c0nstexpr.owo.dsl

import io.wispforest.owo.ui.core.Surface

open class PanelSurfaceBuilder : SurfaceBuilder {
    var insetWidth: Int? = null

    override fun build() = insetWidth?.let(Surface::panelWithInset)
}
