package io.github.c0nstexpr.owo.dsl

import io.github.c0nstexpr.owo.dsl.DslBuilder.Companion.built
import io.wispforest.owo.ui.core.Surface

interface SurfaceBuilder : DslBuilder<Surface> {
    companion object {
        infix fun DslBuilder<Surface>.and(other: DslBuilder<Surface>) =
            dslBuilder { built?.and(other.built ?: return@dslBuilder null) }
    }
}
