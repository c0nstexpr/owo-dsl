package io.github.c0nstexpr.owo.dsl.component

import io.github.c0nstexpr.owo.dsl.DslBuilder.Companion.built
import io.github.c0nstexpr.owo.dsl.nullBuilder
import io.wispforest.owo.ui.component.Components
import io.wispforest.owo.ui.component.SlimSliderComponent
import io.wispforest.owo.ui.component.SlimSliderComponent.Axis

open class SlimSliderBuilder : BaseComponentBuilder() {
    var axis = nullBuilder<Axis>()

    var value = nullBuilder<Double>()

    var min = nullBuilder<Double>()

    var max = nullBuilder<Double>()

    var stepSize = nullBuilder<Double>()

    override fun build() = axis.built?.let(Components::slimSlider)?.also(::applyTo)
}

fun SlimSliderBuilder.applyTo(component: SlimSliderComponent) {
    (this as BaseComponentBuilder).applyTo(component)

    value.built?.let { component.value(it) }

    min.built?.let { component.min(it) }

    max.built?.let { component.max(it) }

    stepSize.built?.let { component.stepSize(it) }
}
