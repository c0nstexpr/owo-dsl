package io.github.c0nstexpr.owo.dsl.component

import io.github.c0nstexpr.owo.dsl.applyBuilt
import io.github.c0nstexpr.owo.dsl.canBuild
import io.github.c0nstexpr.owo.dsl.invalidBuilder
import io.wispforest.owo.ui.component.Components
import io.wispforest.owo.ui.component.SliderComponent
import net.minecraft.text.Text

open class SliderBuilder : SliderWidgetBuilder() {
    var translate = invalidBuilder<Boolean>()

    var scrollStep = invalidBuilder<Double>()

    var active = invalidBuilder<Boolean>()

    override fun build() = Components.slider(horizontalSizing.build())!!.apply(::applyTo)

    override val canBuild get() = horizontalSizing.canBuild
}

fun SliderBuilder.applyTo(component: SliderComponent) {
    (this as ClickableWidgetBuilder).applyTo(component)

    value.applyBuilt(component::value)

    if (translate.canBuild && translate.build()) message.applyBuilt { msg ->
        component.message { Text.translatable(msg.string, it) }
    }
    else message.applyBuilt { msg -> component.message { msg } }

    scrollStep.applyBuilt(component::scrollStep)
    active.applyBuilt(component::active)
}
