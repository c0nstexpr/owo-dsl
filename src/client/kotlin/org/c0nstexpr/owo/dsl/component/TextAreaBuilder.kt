package org.c0nstexpr.owo.dsl.component

import io.wispforest.owo.ui.component.Components
import io.wispforest.owo.ui.component.TextAreaComponent
import org.c0nstexpr.owo.dsl.invalidBuilder

abstract class TextAreaBuilder<T : TextAreaComponent> : EditBoxBuilder<T>() {
    var displayCharCount = invalidBuilder<Boolean>()

    var maxLines = invalidBuilder<Int>()

    override val canBuild
        get() = horizontalSizingBuilder.canBuild && verticalSizingBuilder.canBuild

    override fun applyTo(component: T) {
        super.applyTo(component)

        if (displayCharCount.canBuild) component.displayCharCount(displayCharCount.build())

        if (maxLines.canBuild) component.maxLines(maxLines.build())
    }
}

inline fun textArea(crossinline block: TextAreaBuilder<TextAreaComponent>.() -> Unit) =
    object : TextAreaBuilder<TextAreaComponent>() {
        override fun build() = Components.textArea(
            horizontalSizingBuilder.build(),
            verticalSizingBuilder.build()
        )
    }.apply(block)
