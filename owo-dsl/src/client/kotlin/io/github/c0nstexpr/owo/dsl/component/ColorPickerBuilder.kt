package io.github.c0nstexpr.owo.dsl.component

import io.github.c0nstexpr.owo.dsl.built
import io.github.c0nstexpr.owo.dsl.color
import io.github.c0nstexpr.owo.dsl.invalidBuilder
import io.wispforest.owo.ui.component.ColorPickerComponent

open class ColorPickerBuilder : BaseComponentBuilder() {
    var selectedColor = color()

    var selectorWidth = invalidBuilder<Int>()

    var selectorPadding = invalidBuilder<Int>()

    var showAlpha = invalidBuilder<Boolean>()

    override fun build() = ColorPickerComponent().apply(::applyTo)
}

fun ColorPickerBuilder.applyTo(component: ColorPickerComponent) {
    (this as BaseComponentBuilder).applyTo(component)

    selectedColor.built?.let(component::selectedColor)
    selectorWidth.built?.let(component::selectorWidth)
    selectorPadding.built?.let(component::selectorPadding)
    showAlpha.built?.let(component::showAlpha)
}
