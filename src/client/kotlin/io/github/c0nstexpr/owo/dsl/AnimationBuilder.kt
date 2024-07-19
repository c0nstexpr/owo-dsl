package io.github.c0nstexpr.owo.dsl

import io.wispforest.owo.ui.core.Animatable

abstract class AnimationBuilder<T : Animatable<T>> : DslBuilder<OwoAnimation<T>>

fun <T : Animatable<T>> animation(block: DslBuilder<OwoAnimation<T>> = invalidBuilder()) =
    object : AnimationBuilder<T>() {
        override fun build() = block.build()

        override val canBuild get() = block.canBuild
    }
