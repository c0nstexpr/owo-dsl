package org.c0nstexpr.owo.dsl

import io.wispforest.owo.ui.core.Animatable

fun <T : Animatable<T>> OwoBuilder<T>.interpolate(other: OwoBuilder<T>, delta: OwoBuilder<Float>) =
    object : OwoBuilder<T> {
        val left = this@interpolate

        val right = other

        override fun build() = left.build().interpolate(right.build(), delta.build())

        override val canBuild get() = left.canBuild && right.canBuild && delta.canBuild
    }
