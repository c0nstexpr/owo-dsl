package io.github.c0nstexpr.owo.dsl

import io.wispforest.owo.ui.core.Surface

open class BlurSurfaceBuilder(var quality: Float = 0f, var size: Float = 0f) :
    DslBuilder<Surface> by dslBuilder({ Surface.blur(quality, size) })
