package io.github.c0nstexpr.owo.dsl

import io.wispforest.owo.ui.core.Animatable

abstract class AnimationBuilder<T : Animatable<T>> : DslBuilder<OwoAnimation<T>>

fun <T : Animatable<T>> animation(
    block: DslBuilder<OwoAnimation<T>> = invalidBuilder()
): AnimationBuilder<T> = object : AnimationBuilder<T>(), DslBuilder<OwoAnimation<T>> by block {}

inline fun <T : Animatable<T>> animation(crossinline block: () -> OwoAnimation<T>) =
    animation(dslBuilder { block() })
