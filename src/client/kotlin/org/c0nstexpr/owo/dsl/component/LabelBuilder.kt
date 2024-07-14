package org.c0nstexpr.owo.dsl.component

import io.wispforest.owo.ui.component.Components
import org.c0nstexpr.owo.dsl.text

open class LabelBuilder : BaseComponentBuilder() {
    var text = text()

    override fun build() = Components.label(text.build())!!.apply(::applyTo)

    override val canBuild get() = text.canBuild
}

inline fun label(crossinline block: LabelBuilder.() -> Unit) = LabelBuilder().apply(block)
