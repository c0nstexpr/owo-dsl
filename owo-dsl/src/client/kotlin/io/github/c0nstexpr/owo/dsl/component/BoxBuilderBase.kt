package io.github.c0nstexpr.owo.dsl.component

import io.github.c0nstexpr.owo.dsl.ColorBuilder
import io.github.c0nstexpr.owo.dsl.DslBuilder
import io.github.c0nstexpr.owo.dsl.nullBuilder
import io.wispforest.owo.ui.component.BoxComponent
import io.wispforest.owo.ui.core.Color

abstract class BoxBuilderBase(
    var fill: Boolean? = null,
    var direction: DslBuilder<BoxComponent.GradientDirection> = nullBuilder(),
    var startColor: DslBuilder<Color> = nullBuilder(),
    var endColor: DslBuilder<Color> = nullBuilder()
) : BaseComponentBuilder(),
    DslBuilder<BoxComponent> {
    protected protected abstract fun configure(component: BoxComponent) {
        super.configure(component)
        fill?.let(component::fill)
        direction.value?.let(component::direction)
        startColor.value?.let(component::startColor)
        endColor.value?.let(component::endColor)
    }

    fun color(block: ColorBuilder) {
        startColor = block
        endColor = block
    }
}
