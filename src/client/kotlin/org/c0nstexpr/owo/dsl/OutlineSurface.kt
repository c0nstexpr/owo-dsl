package org.c0nstexpr.owo.dsl

import io.wispforest.owo.ui.core.Surface

open class OutlineSurface : SurfaceBuilder {
    var color: Int? = null

    override fun build() = color?.let(Surface::outline)
}
