package io.github.c0nstexpr.owo.dsl

import io.wispforest.owo.ui.core.Animatable
import io.wispforest.owo.ui.core.Easing

open class OwoAnimationBuilder<T : Animatable<T>>(
    var duration: Int,
    var easing: Easing,
    var to: T
) : DslBuilder<OwoAnimation<*>> by dslBuilder({ OwoAnimation(duration, easing, to) })
