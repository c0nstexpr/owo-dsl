package io.github.c0nstexpr.owo.dsl.component

import io.github.c0nstexpr.owo.dsl.DslBuilder.Companion.built
import io.github.c0nstexpr.owo.dsl.nullBuilder
import io.wispforest.owo.ui.container.Containers
import io.wispforest.owo.ui.container.RenderEffectWrapper
import io.wispforest.owo.ui.container.RenderEffectWrapper.RenderEffect
import io.wispforest.owo.ui.core.Component

open class RenderEffectorBuilder<T : Component> : WrappingParentBuilder<T>() {
    var effects = nullBuilder<List<RenderEffect>>()

    override fun build() = child.built?.let(Containers::renderEffect)?.also(::applyTo)
}

fun <T : Component> RenderEffectorBuilder<T>.applyTo(component: RenderEffectWrapper<T>) {
    (this as WrappingParentBuilder<T>).applyTo(component)

    effects.built?.forEach(component::effect)
}
