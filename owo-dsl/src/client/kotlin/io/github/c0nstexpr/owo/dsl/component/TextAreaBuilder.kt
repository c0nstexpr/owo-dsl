package io.github.c0nstexpr.owo.dsl.component

import io.github.c0nstexpr.owo.dsl.DslBuilder.Companion.built
import io.github.c0nstexpr.owo.dsl.nullBuilder
import io.wispforest.owo.ui.component.Components
import io.wispforest.owo.ui.component.TextAreaComponent

open class TextAreaBuilder : EditBoxBuilder() {
    var displayCharCount = nullBuilder<Boolean>()

    var maxLines = nullBuilder<Int>()

    override fun build(): TextAreaComponent? {
        return Components.textArea(
            horizontalSizing.built ?: return null,
            verticalSizing.built ?: return null
        )!!.also(::applyTo)
    }

    protected fun applyTo(component: TextAreaComponent) {
        super.applyTo(component)
        displayCharCount.built?.let(component::displayCharCount)
        maxLines.built?.let(component::maxLines)
    }
}
