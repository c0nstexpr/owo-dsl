package io.github.c0nstexpr.owo.dsl

import io.github.c0nstexpr.owo.dsl.DslBuilder.Companion.built
import io.wispforest.owo.ui.core.Animatable

fun <T : Animatable<T>> DslBuilder<T>.interpolate(other: DslBuilder<T>, delta: DslBuilder<Float>) =
    dslBuilder {
        val left = built ?: return@dslBuilder
        val right = other.built ?: return@dslBuilder
        val d = delta.built ?: return@dslBuilder

        left.interpolate(right, d)
    }
