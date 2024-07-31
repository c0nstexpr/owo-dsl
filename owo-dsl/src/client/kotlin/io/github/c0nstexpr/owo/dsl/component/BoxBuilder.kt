package io.github.c0nstexpr.owo.dsl.component

import io.github.c0nstexpr.owo.dsl.ColorBuilder
import io.github.c0nstexpr.owo.dsl.DslBuilder
import io.github.c0nstexpr.owo.dsl.DslBuilder.Companion.built
import io.github.c0nstexpr.owo.dsl.nullBuilder
import io.wispforest.owo.ui.component.BoxComponent
import io.wispforest.owo.ui.component.BoxComponent.GradientDirection
import io.wispforest.owo.ui.component.Components
import io.wispforest.owo.ui.core.Color

open class BoxBuilder(
    var fill: Boolean? = null,
    var direction: DslBuilder<GradientDirection> = nullBuilder(),
    var startColor: DslBuilder<Color> = nullBuilder(),
    var endColor: DslBuilder<Color> = nullBuilder()
) : BaseComponentBuilder() {
    override fun buildComponent(): BoxComponent? {
        return Components.box(
            horizontalSizing.built ?: return null,
            verticalSizing.built ?: return null
        )!!.also(::applyTo)
    }

    protected fun applyTo(component: BoxComponent) {
        super.applyTo(component)
        fill?.let(component::fill)
        direction.built?.let(component::direction)
        startColor.built?.let(component::startColor)
        endColor.built?.let(component::endColor)
    }

    fun color(block: ColorBuilder) {
        startColor = block
        endColor = block
    }
}
