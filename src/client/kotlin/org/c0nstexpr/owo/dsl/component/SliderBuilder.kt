package org.c0nstexpr.owo.dsl.component

import io.wispforest.owo.ui.component.Components
import io.wispforest.owo.ui.component.SliderComponent
import net.minecraft.text.Text
import org.c0nstexpr.owo.dsl.applyBuild
import org.c0nstexpr.owo.dsl.invalidBuilder

open class SliderBuilder : SliderWidgetBuilder() {
    var translate = invalidBuilder<Boolean>()

    var scrollStep = invalidBuilder<Double>()

    var active = invalidBuilder<Boolean>()

    override fun build() = Components.slider(horizontalSizing.build())!!.apply(::applyTo)

    override val canBuild get() = horizontalSizing.canBuild
}

fun SliderBuilder.applyTo(component: SliderComponent) {
    (this as ClickableWidgetBuilder).applyTo(component)

    value.applyBuild(component::value)

    if (translate.canBuild && translate.build()) message.applyBuild { msg ->
        component.message { Text.translatable(msg.string, it) }
    }
    else message.applyBuild { msg -> component.message { msg } }

    scrollStep.applyBuild(component::scrollStep)
    active.applyBuild(component::active)
}

inline fun slider(crossinline block: SliderBuilder.() -> Unit) = SliderBuilder().apply(block)
