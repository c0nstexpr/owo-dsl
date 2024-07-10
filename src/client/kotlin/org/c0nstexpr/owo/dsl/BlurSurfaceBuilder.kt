package org.c0nstexpr.owo.dsl

import io.wispforest.owo.ui.core.Surface

open class BlurSurfaceBuilder : SurfaceBuilder {
    private var initialized = false

    var quality: Float = 0f
        set(value) {
            initialized = true
            field = value
        }

    var size: Float = 0f
        set(value) {
            initialized = true
            field = value
        }

    override fun build() = if (initialized) Surface.blur(quality, size) else null
}
