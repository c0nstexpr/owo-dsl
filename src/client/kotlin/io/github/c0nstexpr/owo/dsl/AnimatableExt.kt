package io.github.c0nstexpr.owo.dsl

import io.wispforest.owo.ui.core.Animatable

fun <T : Animatable<T>> io.github.c0nstexpr.owo.dsl.OwoBuilder<T>.interpolate(
    other: io.github.c0nstexpr.owo.dsl.OwoBuilder<T>,
    delta: io.github.c0nstexpr.owo.dsl.OwoBuilder<Float>
) = object : io.github.c0nstexpr.owo.dsl.OwoBuilder<T> {
    val left = this@interpolate

    val right = other

    override fun build() = left.build().interpolate(right.build(), delta.build())

    override val canBuild get() = left.canBuild && right.canBuild && delta.canBuild
}
