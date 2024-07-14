package org.c0nstexpr.owo.dsl.component

import io.wispforest.owo.ui.component.Components
import io.wispforest.owo.ui.component.TextAreaComponent
import org.c0nstexpr.owo.dsl.applyBuild
import org.c0nstexpr.owo.dsl.invalidBuilder

open class TextAreaBuilder : EditBoxBuilder() {
    var displayCharCount = invalidBuilder<Boolean>()

    var maxLines = invalidBuilder<Int>()

    override fun build() = Components.textArea(
        horizontalSizing.build(),
        verticalSizing.build()
    )!!.apply(::applyTo)

    override val canBuild get() = horizontalSizing.canBuild && verticalSizing.canBuild
}

fun TextAreaBuilder.applyTo(component: TextAreaComponent) {
    (this as EditBoxBuilder).applyTo(component)

    displayCharCount.applyBuild(component::displayCharCount)
    maxLines.applyBuild(component::maxLines)
}

inline fun textArea(crossinline block: TextAreaBuilder.() -> Unit) = TextAreaBuilder().apply(block)
