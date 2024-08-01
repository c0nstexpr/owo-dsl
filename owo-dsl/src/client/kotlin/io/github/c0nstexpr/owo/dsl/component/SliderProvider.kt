package io.github.c0nstexpr.owo.dsl.component

import io.github.c0nstexpr.owo.dsl.DslBuilder.Companion.built
import io.wispforest.owo.ui.component.Components
import io.wispforest.owo.ui.component.SliderComponent
import net.minecraft.text.Text

open class SliderProvider(
    var translate: Boolean = false,
    var scrollStep: Double? = null,
    var active: Boolean = true
) : SliderWidgetProvider() {
    override fun provide() = horizontalSizing.built?.let(Components::slider)?.also(::applyTo)

    protected fun applyTo(component: SliderComponent) {
        super.applyTo(component)

        component.value(value)

        message.built?.let { msg ->
            if (translate) component.message { Text.translatable(msg.string, it) }
            else component.message { msg }
        }

        scrollStep?.let(component::scrollStep)
        component.active(active)
    }
}
