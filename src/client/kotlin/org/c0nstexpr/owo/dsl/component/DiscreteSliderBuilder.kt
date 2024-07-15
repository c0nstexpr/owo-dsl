package org.c0nstexpr.owo.dsl.component

import io.wispforest.owo.ui.component.Components
import io.wispforest.owo.ui.component.DiscreteSliderComponent
import org.c0nstexpr.owo.dsl.applyBuild
import org.c0nstexpr.owo.dsl.invalidBuilder

open class DiscreteSliderBuilder : SliderBuilder() {
    var min = invalidBuilder<Double>()

    var max = invalidBuilder<Double>()

    var discreteValue = invalidBuilder<Double>()

    var decimalPlaces = invalidBuilder<Int>()

    var snap = invalidBuilder<Boolean>()

    override fun build() =
        Components.discreteSlider(horizontalSizing.build(), min.build(), max.build())!!
            .apply(::applyTo)

    override val canBuild: Boolean
        get() = horizontalSizing.canBuild && min.canBuild && max.canBuild
}

fun DiscreteSliderBuilder.applyTo(component: DiscreteSliderComponent) {
    (this as SliderBuilder).applyTo(component)

    discreteValue.applyBuild(component::setFromDiscreteValue)
    decimalPlaces.applyBuild(component::decimalPlaces)
    snap.applyBuild(component::snap)
}

inline fun discreteSlider(crossinline block: DiscreteSliderBuilder.() -> Unit) =
    DiscreteSliderBuilder().apply(block)
