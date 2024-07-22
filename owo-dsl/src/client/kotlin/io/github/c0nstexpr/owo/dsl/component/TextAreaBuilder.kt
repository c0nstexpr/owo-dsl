package io.github.c0nstexpr.owo.dsl.component

import io.github.c0nstexpr.owo.dsl.applyBuild
import io.github.c0nstexpr.owo.dsl.canBuild
import io.github.c0nstexpr.owo.dsl.invalidBuilder
import io.wispforest.owo.ui.component.Components
import io.wispforest.owo.ui.component.TextAreaComponent

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
