package io.github.c0nstexpr.owo.dsl.component

import io.wispforest.owo.ui.component.Components
import io.wispforest.owo.ui.component.SpriteComponent
import io.wispforest.owo.ui.core.Sizing

open class SpacerBuilder : BaseComponentBuilder() {
    var percent: Int? = null

    override fun provide() = Components.spacer()!!.also(::applyTo)

    protected fun applyTo(component: SpriteComponent) {
        super.applyTo(component)
        percent?.let { component.sizing(Sizing.expand(it)) }
    }
}
