package io.github.c0nstexpr.owo.dsl.component

import io.github.c0nstexpr.owo.dsl.DslBuilder.Companion.built
import io.github.c0nstexpr.owo.dsl.nullBuilder
import io.wispforest.owo.ui.component.ColorPickerComponent
import io.wispforest.owo.ui.core.Color

open class ColorPickerBuilder : BaseComponentBuilder() {
    var selectedColor = nullBuilder<Color>()

    var selectorWidth = nullBuilder<Int>()

    var selectorPadding = nullBuilder<Int>()

    var showAlpha = nullBuilder<Boolean>()

    override fun build(): ColorPickerComponent? = ColorPickerComponent().also(::applyTo)

    protected fun applyTo(component: ColorPickerComponent) {
        super.applyTo(component)
        selectedColor.built?.let(component::selectedColor)
        selectorWidth.built?.let(component::selectorWidth)
        selectorPadding.built?.let(component::selectorPadding)
        showAlpha.built?.let(component::showAlpha)
    }
}
