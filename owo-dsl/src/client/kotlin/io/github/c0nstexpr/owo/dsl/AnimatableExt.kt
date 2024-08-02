package io.github.c0nstexpr.owo.dsl

import io.wispforest.owo.ui.core.Animatable

fun <T : Animatable<T>> DslBuilder<T>.interpolate(other: DslBuilder<T>, delta: Float = 0f) =
    dslBuilder {
        val left = value ?: return@dslBuilder
        val right = other.value ?: return@dslBuilder

        left.interpolate(right, delta)
    }
