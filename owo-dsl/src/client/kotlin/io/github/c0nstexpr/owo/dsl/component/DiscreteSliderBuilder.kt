package io.github.c0nstexpr.owo.dsl.component

import io.github.c0nstexpr.owo.dsl.DslBuilder.Companion.built
import io.wispforest.owo.ui.component.Components
import io.wispforest.owo.ui.component.DiscreteSliderComponent

open class DiscreteSliderBuilder(
    var min: Double = .0,
    var max: Double? = null,
    var discreteValue: Double? = null,
    var decimalPlaces: Int? = null,
    var snap: Boolean? = null
) : SliderBuilder() {
    override fun buildComponent(): DiscreteSliderComponent? {
        return Components.discreteSlider(
            horizontalSizing.built ?: return null,
            min,
            max ?: return null
        ).also(::applyTo)
    }

    protected fun applyTo(component: DiscreteSliderComponent) {
        super.applyTo(component)
        discreteValue?.let(component::setFromDiscreteValue)
        decimalPlaces?.let(component::decimalPlaces)
        snap?.let(component::snap)
    }
}
