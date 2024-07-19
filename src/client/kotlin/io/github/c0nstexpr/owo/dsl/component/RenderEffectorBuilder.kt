package io.github.c0nstexpr.owo.dsl.component

import io.github.c0nstexpr.owo.dsl.applyBuild
import io.github.c0nstexpr.owo.dsl.invalidBuilder
import io.wispforest.owo.ui.container.Containers
import io.wispforest.owo.ui.container.RenderEffectWrapper
import io.wispforest.owo.ui.container.RenderEffectWrapper.RenderEffect
import io.wispforest.owo.ui.core.Component

open class RenderEffectorBuilder<T : Component> : WrappingParentBuilder() {
    var child = invalidBuilder<T>()

    var effects = invalidBuilder<List<RenderEffect>>()

    override fun build() = Containers.renderEffect(child.build())!!.apply(::applyTo)

    override val canBuild get() = child.canBuild
}

fun <T : Component> RenderEffectorBuilder<T>.applyTo(component: RenderEffectWrapper<T>) {
    (this as WrappingParentBuilder).applyTo(component)

    effects.applyBuild { it.forEach(component::effect) }
}
