package io.github.c0nstexpr.owo.dsl

import io.wispforest.owo.ui.core.Animatable
import io.wispforest.owo.ui.core.Easing

open class DefaultAnimationBuilder<T : Animatable<T>> : AnimationBuilder<T>() {
    var duration = invalidBuilder<Int>()
    var easing = invalidBuilder<Easing>()
    var to = invalidBuilder<T>()

    override fun build() = OwoAnimation(duration.build(), easing.build(), to.build())

    override val canBuild get() = duration.canBuild && easing.canBuild && to.canBuild
}

inline fun <T : Animatable<T>> defaultAnimation(
    crossinline block: DefaultAnimationBuilder<T>.() -> Unit
) = DefaultAnimationBuilder<T>().apply(block)
