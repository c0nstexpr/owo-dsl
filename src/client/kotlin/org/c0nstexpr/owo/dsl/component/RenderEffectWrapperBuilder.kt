package org.c0nstexpr.owo.dsl.component

import io.wispforest.owo.ui.container.Containers
import io.wispforest.owo.ui.container.RenderEffectWrapper
import io.wispforest.owo.ui.core.Component
import org.c0nstexpr.owo.dsl.applyBuild
import org.c0nstexpr.owo.dsl.invalidBuilder

open class RenderEffectWrapperBuilder<T : Component> : WrappingParentBuilder() {
    var closeOnClick = invalidBuilder<Boolean>()

    var child = invalidBuilder<T>()

    override fun build() = Containers.overlay(child.build())!!.apply(::applyTo)

    override val canBuild get() = child.canBuild
}

fun <T : Component> RenderEffectWrapperBuilder<T>.applyTo(component: RenderEffectWrapper<T>) {
    (this as WrappingParentBuilder).applyTo(component)

    closeOnClick.applyBuild(component::closeOnClick)
}

inline fun <T : Component> renderEffect(
    crossinline block: RenderEffectWrapperBuilder<T>.() -> Unit
) = RenderEffectWrapperBuilder<T>().apply(block)
