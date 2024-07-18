package io.github.c0nstexpr.owo.dsl

import io.wispforest.owo.ui.core.Animatable

abstract class OwoAnimationBuilder<T : Animatable<T>> : OwoBuilder<OwoAnimation<T>>

fun <T : Animatable<T>> animation(block: OwoBuilder<OwoAnimation<T>> = invalidBuilder()) =
    object : OwoAnimationBuilder<T>() {
        override fun build() = block.build()

        override val canBuild get() = block.canBuild
    }
