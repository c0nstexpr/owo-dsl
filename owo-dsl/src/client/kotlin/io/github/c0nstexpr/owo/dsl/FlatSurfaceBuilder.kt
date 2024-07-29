package io.github.c0nstexpr.owo.dsl

import io.wispforest.owo.ui.core.Surface

open class FlatSurfaceBuilder(var color: Int = 0) :
    DslBuilder<Surface> by dslBuilder({ Surface.flat(color) })
