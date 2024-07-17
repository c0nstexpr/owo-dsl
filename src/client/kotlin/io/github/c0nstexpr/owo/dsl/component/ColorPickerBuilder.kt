package io.github.c0nstexpr.owo.dsl.component

import io.github.c0nstexpr.owo.dsl.applyBuild
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

    selectedColor.applyBuild(component::selectedColor)
    selectorWidth.applyBuild(component::selectorWidth)
    selectorPadding.applyBuild(component::selectorPadding)
    showAlpha.applyBuild(component::showAlpha)
}

inline fun colorPicker(crossinline block: ColorPickerBuilder.() -> Unit) =
    ColorPickerBuilder().apply(block)
