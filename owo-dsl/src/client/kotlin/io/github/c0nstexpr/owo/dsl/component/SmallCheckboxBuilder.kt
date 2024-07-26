package io.github.c0nstexpr.owo.dsl.component

import io.github.c0nstexpr.owo.dsl.DslBuilder.Companion.built
import io.github.c0nstexpr.owo.dsl.nullBuilder
import io.wispforest.owo.ui.component.Components
import io.wispforest.owo.ui.component.SmallCheckboxComponent
import net.minecraft.text.Text

open class SmallCheckboxBuilder : BaseComponentBuilder() {
    var label = nullBuilder<Text>()

    var checked = nullBuilder<Boolean>()

    var labelShadow = nullBuilder<Boolean>()

    override fun build() = label.built?.let(Components::smallCheckbox)?.also(::applyTo)

    protected fun applyTo(component: SmallCheckboxComponent) {
        super.applyTo(component)
        checked.built?.let(component::checked)
        labelShadow.built?.let(component::labelShadow)
    }
}
