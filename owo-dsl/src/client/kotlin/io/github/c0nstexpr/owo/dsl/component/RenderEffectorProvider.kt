package io.github.c0nstexpr.owo.dsl.component

import io.github.c0nstexpr.owo.dsl.DslBuilder
import io.github.c0nstexpr.owo.dsl.DslBuilder.Companion.built
import io.wispforest.owo.ui.container.Containers
import io.wispforest.owo.ui.container.RenderEffectWrapper
import io.wispforest.owo.ui.container.RenderEffectWrapper.RenderEffect
import io.wispforest.owo.ui.core.Component

open class RenderEffectorProvider<T : Component>(
    var effects: List<DslBuilder<RenderEffect>> = listOf()
) : WrappingParentProvider<T>() {
    override fun provide() = child.built?.let(Containers::renderEffect)?.also(::applyTo)

    protected fun applyTo(component: RenderEffectWrapper<T>) {
        super.applyTo(component)
        effects.map { it.built ?: return }.toList().forEach(component::effect)
    }
}
