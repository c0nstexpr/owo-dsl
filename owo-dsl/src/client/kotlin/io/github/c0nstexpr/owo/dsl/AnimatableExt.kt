package io.github.c0nstexpr.owo.dsl

import io.github.c0nstexpr.owo.dsl.DslBuilder.Companion.built
import io.wispforest.owo.ui.core.Animatable

fun <T : Animatable<T>> DslBuilder<T>.interpolate(other: DslBuilder<T>, delta: Float = 0f) =
    dslBuilder {
        val left = built ?: return@dslBuilder
        val right = other.built ?: return@dslBuilder

        left.interpolate(right, delta)
    }
