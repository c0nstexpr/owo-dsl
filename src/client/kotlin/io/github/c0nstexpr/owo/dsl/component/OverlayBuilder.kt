package io.github.c0nstexpr.owo.dsl.component

import io.github.c0nstexpr.owo.dsl.applyBuild
import io.github.c0nstexpr.owo.dsl.invalidBuilder
import io.wispforest.owo.ui.container.Containers
import io.wispforest.owo.ui.container.OverlayContainer
import io.wispforest.owo.ui.core.Component

open class OverlayBuilder<T : Component> : WrappingParentBuilder() {
    var closeOnClick = invalidBuilder<Boolean>()

    var child = invalidBuilder<T>()

    override fun build() = Containers.overlay(child.build())!!.apply(::applyTo)

    override val canBuild get() = child.canBuild
}

fun <T : Component> OverlayBuilder<T>.applyTo(component: OverlayContainer<T>) {
    (this as WrappingParentBuilder).applyTo(component)

    closeOnClick.applyBuild(component::closeOnClick)
}
