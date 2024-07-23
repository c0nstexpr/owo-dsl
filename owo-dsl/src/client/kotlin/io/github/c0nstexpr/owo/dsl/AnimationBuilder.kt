package io.github.c0nstexpr.owo.dsl

import io.wispforest.owo.ui.core.Animatable

abstract class AnimationBuilder<T : Animatable<T>> : DslBuilder<OwoAnimation<T>> {
    open class Entrance<T : Animatable<T>> :
        AnimationBuilder<T>(),
        DslBuilder<OwoAnimation<T>> by invalidBuilder() {
        fun by(block: DslBuilder<OwoAnimation<T>>): AnimationBuilder<T> =
            object : AnimationBuilder<T>(), DslBuilder<OwoAnimation<T>> by block {}

        fun by(block: () -> OwoAnimation<T>?) = by(dslBuilder { block() })

        fun with(value: OwoAnimation<T>) = by { value }
    }
}

fun <T : Animatable<T>, R> animation(block: AnimationBuilder<T>.() -> R) =
    AnimationBuilder.Entrance<T>().block()
