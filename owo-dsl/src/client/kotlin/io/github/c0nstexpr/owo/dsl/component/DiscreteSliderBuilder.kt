package io.github.c0nstexpr.owo.dsl.component

import io.github.c0nstexpr.owo.dsl.applyBuilt
import io.github.c0nstexpr.owo.dsl.canBuild
import io.github.c0nstexpr.owo.dsl.invalidBuilder
import io.wispforest.owo.ui.component.Components
import io.wispforest.owo.ui.component.DiscreteSliderComponent

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

    discreteValue.applyBuilt(component::setFromDiscreteValue)
    decimalPlaces.applyBuilt(component::decimalPlaces)
    snap.applyBuilt(component::snap)
}
