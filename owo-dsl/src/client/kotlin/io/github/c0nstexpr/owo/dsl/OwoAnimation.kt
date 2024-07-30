package io.github.c0nstexpr.owo.dsl

import io.wispforest.owo.ui.core.Animatable
import io.wispforest.owo.ui.core.AnimatableProperty
import io.wispforest.owo.ui.core.Easing

data class OwoAnimation<T : Animatable<T>>(val duration: Int, val easing: Easing, val to: T) {
    companion object {
        fun <T : Animatable<T>> AnimatableProperty<T>.animate(owoAnimation: OwoAnimation<T>) =
            owoAnimation.apply {
                animate(duration, easing, to)
            }
    }
}
