package io.github.c0nstexpr.owo.dsl

import io.wispforest.owo.ui.core.Animatable

fun <T : Animatable<T>> DslBuilder<T>.interpolate(other: DslBuilder<T>, delta: DslBuilder<Float>) =
    object : DslBuilder<T> {
        val left = this@interpolate

        val right = other

        override fun build() = left.build().interpolate(right.build(), delta.build())

        override val canBuild get() = left.canBuild && right.canBuild && delta.canBuild
    }
