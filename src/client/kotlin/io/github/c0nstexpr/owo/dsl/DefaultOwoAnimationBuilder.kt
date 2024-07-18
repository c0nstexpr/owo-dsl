package io.github.c0nstexpr.owo.dsl

import io.wispforest.owo.ui.core.Animatable
import io.wispforest.owo.ui.core.Easing

open class DefaultOwoAnimationBuilder<T : Animatable<T>> : OwoAnimationBuilder<T>() {
    var duration = invalidBuilder<Int>()
    var easing = invalidBuilder<Easing>()
    var to = invalidBuilder<T>()

    override fun build() = OwoAnimation(duration.build(), easing.build(), to.build())

    override val canBuild get() = duration.canBuild && easing.canBuild && to.canBuild
}

inline fun <T : Animatable<T>> defaultAnimation(
    crossinline block: DefaultOwoAnimationBuilder<T>.() -> Unit
) = DefaultOwoAnimationBuilder<T>().apply(block)
