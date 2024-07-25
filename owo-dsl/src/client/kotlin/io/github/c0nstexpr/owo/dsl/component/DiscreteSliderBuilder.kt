package io.github.c0nstexpr.owo.dsl.component

import io.github.c0nstexpr.owo.dsl.DslBuilder.Companion.built
import io.github.c0nstexpr.owo.dsl.nullBuilder
import io.wispforest.owo.ui.component.Components
import io.wispforest.owo.ui.component.DiscreteSliderComponent

open class DiscreteSliderBuilder : SliderBuilder() {
    var min = nullBuilder<Double>()

    var max = nullBuilder<Double>()

    var discreteValue = nullBuilder<Double>()

    var decimalPlaces = nullBuilder<Int>()

    var snap = nullBuilder<Boolean>()

    override fun build(): DiscreteSliderComponent? {
        return Components.discreteSlider(
            horizontalSizing.built ?: return null,
            min.built ?: return null,
            max.built ?: return null
        ).also(::applyTo)
    }
}

fun DiscreteSliderBuilder.applyTo(component: DiscreteSliderComponent) {
    (this as SliderBuilder).applyTo(component)

    discreteValue.built?.let(component::setFromDiscreteValue)
    decimalPlaces.built?.let(component::decimalPlaces)
    snap.built?.let(component::snap)
}
