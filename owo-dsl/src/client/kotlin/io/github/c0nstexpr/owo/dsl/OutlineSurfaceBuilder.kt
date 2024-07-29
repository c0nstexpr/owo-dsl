package io.github.c0nstexpr.owo.dsl

import io.wispforest.owo.ui.core.Surface

open class OutlineSurfaceBuilder(var color: Int = 0) :
    DslBuilder<Surface> by dslBuilder({ Surface.outline(color) })
