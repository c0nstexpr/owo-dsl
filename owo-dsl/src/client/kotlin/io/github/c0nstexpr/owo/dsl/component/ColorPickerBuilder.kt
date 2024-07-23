package io.github.c0nstexpr.owo.dsl.component

import io.github.c0nstexpr.owo.dsl.applyBuilt
import io.github.c0nstexpr.owo.dsl.color
import io.github.c0nstexpr.owo.dsl.invalidBuilder
import io.wispforest.owo.ui.component.ColorPickerComponent

open class ColorPickerBuilder : BaseComponentBuilder() {
    var selectedColor = color()

    var selectorWidth = invalidBuilder<Int>()

    var selectorPadding = invalidBuilder<Int>()

    var showAlpha = invalidBuilder<Boolean>()

    override fun build() = ColorPickerComponent().apply(::applyTo)

    override val canBuild get() = true
}

fun ColorPickerBuilder.applyTo(component: ColorPickerComponent) {
    (this as BaseComponentBuilder).applyTo(component)

    selectedColor.applyBuild(component::selectedColor)
    selectorWidth.applyBuilt(component::selectorWidth)
    selectorPadding.applyBuilt(component::selectorPadding)
    showAlpha.applyBuilt(component::showAlpha)
}
