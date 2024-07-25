package io.github.c0nstexpr.owo.dsl.component

import io.github.c0nstexpr.owo.dsl.ColorBuilder
import io.github.c0nstexpr.owo.dsl.DslBuilder.Companion.built
import io.github.c0nstexpr.owo.dsl.nullBuilder
import io.wispforest.owo.ui.component.BoxComponent
import io.wispforest.owo.ui.component.BoxComponent.GradientDirection
import io.wispforest.owo.ui.component.Components
import io.wispforest.owo.ui.core.Color

open class BoxBuilder : BaseComponentBuilder() {
    var fill = nullBuilder<Boolean>()

    var direction = nullBuilder<GradientDirection>()

    var startColor = nullBuilder<Color>()

    var endColor = nullBuilder<Color>()

    override fun build(): BoxComponent? {
        return Components.box(
            horizontalSizing.built ?: return null,
            verticalSizing.built ?: return null
        )!!.also(::applyTo)
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
