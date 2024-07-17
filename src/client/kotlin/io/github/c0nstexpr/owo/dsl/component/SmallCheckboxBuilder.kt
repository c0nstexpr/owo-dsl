package io.github.c0nstexpr.owo.dsl.component

import io.github.c0nstexpr.owo.dsl.applyBuild
import io.github.c0nstexpr.owo.dsl.invalidBuilder
import io.github.c0nstexpr.owo.dsl.text
import io.wispforest.owo.ui.component.Components
import io.wispforest.owo.ui.component.SmallCheckboxComponent

open class SmallCheckboxBuilder : BaseComponentBuilder() {
    var label = text()

    var checked = invalidBuilder<Boolean>()

    var labelShadow = invalidBuilder<Boolean>()

    override fun build() = Components.smallCheckbox(label.build())!!.apply(::applyTo)

    override val canBuild get() = label.canBuild
}

fun SmallCheckboxBuilder.applyTo(component: SmallCheckboxComponent) {
    (this as BaseComponentBuilder).applyTo(component)

    checked.applyBuild(component::checked)
    labelShadow.applyBuild(component::labelShadow)
}

inline fun smallCheckbox(crossinline block: SmallCheckboxBuilder.() -> Unit) =
    SmallCheckboxBuilder().apply(block)
