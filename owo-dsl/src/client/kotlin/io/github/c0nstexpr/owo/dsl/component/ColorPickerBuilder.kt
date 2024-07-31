package io.github.c0nstexpr.owo.dsl.component

import io.github.c0nstexpr.owo.dsl.DslBuilder
import io.github.c0nstexpr.owo.dsl.DslBuilder.Companion.built
import io.github.c0nstexpr.owo.dsl.nullBuilder
import io.wispforest.owo.ui.component.ColorPickerComponent
import io.wispforest.owo.ui.core.Color

open class ColorPickerBuilder(
    var selectedColor: DslBuilder<Color> = nullBuilder(),
    var selectorWidth: Int? = null,
    var selectorPadding: Int? = null,
    var showAlpha: Boolean? = null
) : BaseComponentBuilder() {
    override fun buildComponent(): ColorPickerComponent? = ColorPickerComponent().also(::applyTo)

    protected fun applyTo(component: ColorPickerComponent) {
        super.applyTo(component)
        selectedColor.built?.let(component::selectedColor)
        selectorWidth?.let(component::selectorWidth)
        selectorPadding?.let(component::selectorPadding)
        showAlpha?.let(component::showAlpha)
    }
}
