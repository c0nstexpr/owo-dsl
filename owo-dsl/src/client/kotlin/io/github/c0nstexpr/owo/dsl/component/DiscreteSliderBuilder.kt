package io.github.c0nstexpr.owo.dsl.component

import io.github.c0nstexpr.owo.dsl.built
import io.github.c0nstexpr.owo.dsl.invalidBuilder
import io.wispforest.owo.ui.component.Components
import io.wispforest.owo.ui.component.DiscreteSliderComponent

open class DiscreteSliderBuilder : SliderBuilder() {
    var min = invalidBuilder<Double>()

    var max = invalidBuilder<Double>()

    var discreteValue = invalidBuilder<Double>()

    var decimalPlaces = invalidBuilder<Int>()

    var snap = invalidBuilder<Boolean>()

    override fun build(): DiscreteSliderComponent? {
        return Components.discreteSlider(
            horizontalSizing.built ?: return null,
            min.built ?: return null,
            max.built ?: return null
        ).apply(::applyTo)
    }
}

fun DiscreteSliderBuilder.applyTo(component: DiscreteSliderComponent) {
    (this as SliderBuilder).applyTo(component)

    discreteValue.built?.let(component::setFromDiscreteValue)
    decimalPlaces.built?.let(component::decimalPlaces)
    snap.built?.let(component::snap)
}
