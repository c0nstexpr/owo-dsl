package io.github.c0nstexpr.owo.dsl.component

import io.github.c0nstexpr.owo.dsl.DslBuilder.Companion.built
import io.github.c0nstexpr.owo.dsl.nullBuilder
import io.wispforest.owo.ui.base.BaseComponent
import io.wispforest.owo.ui.core.Size

abstract class BaseComponentBuilder : ComponentBuilder by component() {
    var space = nullBuilder<Size>()

    override fun buildComponent(): BaseComponent? = null

    protected fun applyTo(component: BaseComponent) {
        super.applyTo(component)
        space.built?.let(component::inflate)
    }
}
