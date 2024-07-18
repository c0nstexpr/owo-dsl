package io.github.c0nstexpr.owo.dsl

import io.wispforest.owo.ui.core.Animatable
import io.wispforest.owo.ui.core.Animation
import io.wispforest.owo.ui.core.Easing

open class OwoAnimation<T : Animatable<T>>(
    var duration: Int,
    var easing: Easing,
    var to: T,
    var callback: Animation<T>? = null
)
