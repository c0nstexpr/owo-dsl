package org.c0nstexpr.owo.dsl

import io.wispforest.owo.ui.core.Surface

open class OutlineSurface : SurfaceBuilder {
    private var initialized = false

    var color: Int = 0
        set(value) {
            initialized = true
            field = value
        }

    override fun build() = if (initialized) Surface.outline(color) else null
}
