package io.github.c0nstexpr.owo.dsl

import io.wispforest.owo.ui.core.Animatable
import io.wispforest.owo.ui.core.AnimatableProperty
import io.wispforest.owo.ui.core.Animation
import io.wispforest.owo.ui.core.Easing

@OwoDslMarker
open class OwoAnimation<T : Animatable<T>>(
    var duration: Int,
    var easing: Easing,
    var to: T,
    var callback: ((Animation<T>) -> Unit)? = null
) {
    companion object {
        fun <T : Animatable<T>> AnimatableProperty<T>.animate(owoAnimation: OwoAnimation<T>) =
            owoAnimation.apply {
                val animation = animate(duration, easing, to)
                callback?.invoke(animation)
            }
    }
}
