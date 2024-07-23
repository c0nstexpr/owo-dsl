package io.github.c0nstexpr.owo.dsl

import io.wispforest.owo.ui.core.Animatable

fun <T : Animatable<T>> DslBuilder<T>.interpolate(other: DslBuilder<T>, delta: DslBuilder<Float>) =
    dslBuilder {
        applyBuilt { left ->
            other.applyBuilt { right -> delta.applyBuilt { left.interpolate(right, it) } }
        }
    }
