package io.github.c0nstexpr.owo.dsl.component

import io.github.c0nstexpr.owo.dsl.DslBuilder.Companion.built
import io.github.c0nstexpr.owo.dsl.nullBuilder
import io.wispforest.owo.ui.component.Components
import io.wispforest.owo.ui.component.SlimSliderComponent
import io.wispforest.owo.ui.component.SlimSliderComponent.Axis

open class SlimSliderBuilder : BaseComponentBuilder() {
    var axis = nullBuilder<Axis>()

    var value: Double? = null

    var min = .0

    var max: Double? = null

    var stepSize: Double? = null

    override fun buildComponent() = axis.built?.let(Components::slimSlider)?.also(::applyTo)

    protected fun applyTo(component: SlimSliderComponent) {
        super.applyTo(component)
        value?.let(component::value)
        component.min(min)
        max?.let(component::max)
        stepSize?.let(component::stepSize)
    }
}
