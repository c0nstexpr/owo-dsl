package io.github.c0nstexpr.owo.dsl.component

import io.github.c0nstexpr.owo.dsl.ColorBuilder
import io.github.c0nstexpr.owo.dsl.applyBuild
import io.github.c0nstexpr.owo.dsl.canBuild
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

    override fun build() = Components.box(
        horizontalSizing.build(),
        verticalSizing.build()
    )!!.apply(::applyTo)

    override val canBuild get() = horizontalSizing.canBuild && verticalSizing.canBuild
}

fun BoxBuilder.applyTo(component: BoxComponent) {
    (this as BaseComponentBuilder).applyTo(component)

    fill.applyBuild(component::fill)
    direction.applyBuild(component::direction)
    startColor.applyBuild(component::startColor)
    endColor.applyBuild(component::endColor)
}

fun BoxBuilder.color(block: ColorBuilder) {
    startColor = block
    endColor = block
}
