package io.github.c0nstexpr.owo.dsl.component

import io.github.c0nstexpr.owo.dsl.ColorBuilder
import io.github.c0nstexpr.owo.dsl.built
import io.github.c0nstexpr.owo.dsl.color
import io.github.c0nstexpr.owo.dsl.invalidBuilder
import io.wispforest.owo.ui.component.BoxComponent
import io.wispforest.owo.ui.component.BoxComponent.GradientDirection
import io.wispforest.owo.ui.component.Components

open class BoxBuilder : BaseComponentBuilder() {
    var fill = invalidBuilder<Boolean>()

    var direction = invalidBuilder<GradientDirection>()

    var startColor = color()

    var endColor = color()

    override fun build(): BoxComponent? {
        return Components.box(
            horizontalSizing.built ?: return null,
            verticalSizing.built ?: return null
        )!!.apply(::applyTo)
    }
}

fun BoxBuilder.applyTo(component: BoxComponent) {
    (this as BaseComponentBuilder).applyTo(component)

    fill.built?.let(component::fill)
    direction.built?.let(component::direction)
    startColor.built?.let(component::startColor)
    endColor.built?.let(component::endColor)
}

fun BoxBuilder.color(block: ColorBuilder) {
    startColor = block
    endColor = block
}
