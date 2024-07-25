package io.github.c0nstexpr.owo.dsl.component

import io.github.c0nstexpr.owo.dsl.DslBuilder.Companion.built
import io.github.c0nstexpr.owo.dsl.nullBuilder
import io.wispforest.owo.ui.component.Components
import io.wispforest.owo.ui.component.SliderComponent
import net.minecraft.text.Text

open class SliderBuilder : SliderWidgetBuilder() {
    var translate = nullBuilder<Boolean>()

    var scrollStep = nullBuilder<Double>()

    var active = nullBuilder<Boolean>()

    override fun build() = horizontalSizing.built?.let(Components::slider)?.also(::applyTo)
}

fun SliderBuilder.applyTo(component: SliderComponent) {
    (this as ClickableWidgetBuilder).applyTo(component)

    value.built?.let(component::value)

    message.built?.let { msg ->
        if (translate.built == true) component.message { Text.translatable(msg.string, it) }
        else component.message { msg }
    }

    scrollStep.built?.let(component::scrollStep)
    active.built?.let(component::active)
}
