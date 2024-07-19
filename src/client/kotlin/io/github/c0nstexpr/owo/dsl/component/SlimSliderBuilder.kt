package io.github.c0nstexpr.owo.dsl.component

import io.github.c0nstexpr.owo.dsl.applyBuild
import io.github.c0nstexpr.owo.dsl.invalidBuilder
import io.wispforest.owo.ui.component.Components
import io.wispforest.owo.ui.component.SlimSliderComponent
import io.wispforest.owo.ui.component.SlimSliderComponent.Axis

open class SlimSliderBuilder : BaseComponentBuilder() {
    var axis = invalidBuilder<Axis>()

    var value = invalidBuilder<Double>()

    var min = invalidBuilder<Double>()

    var max = invalidBuilder<Double>()

    var stepSize = invalidBuilder<Double>()

    override fun build() = Components.slimSlider(axis.build())!!.apply(::applyTo)

    override val canBuild get() = axis.canBuild
}

fun SlimSliderBuilder.applyTo(component: SlimSliderComponent) {
    (this as BaseComponentBuilder).applyTo(component)

    value.applyBuild { component.value(it) }

    min.applyBuild { component.min(it) }

    max.applyBuild { component.max(it) }

    stepSize.applyBuild { component.stepSize(it) }
}
