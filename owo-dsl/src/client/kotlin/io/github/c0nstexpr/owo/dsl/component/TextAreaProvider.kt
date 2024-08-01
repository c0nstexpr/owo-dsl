package io.github.c0nstexpr.owo.dsl.component

import io.github.c0nstexpr.owo.dsl.DslBuilder.Companion.built
import io.wispforest.owo.ui.component.Components
import io.wispforest.owo.ui.component.TextAreaComponent

open class TextAreaProvider : EditBoxProvider() {
    var displayCharCount: Boolean? = null

    var maxLines: Int? = null

    override fun provide(): TextAreaComponent? {
        return Components.textArea(
            horizontalSizing.built ?: return null,
            verticalSizing.built ?: return null
        )!!.also(::applyTo)
    }

    protected fun applyTo(component: TextAreaComponent) {
        super.applyTo(component)
        displayCharCount?.let(component::displayCharCount)
        maxLines?.let(component::maxLines)
    }
}
