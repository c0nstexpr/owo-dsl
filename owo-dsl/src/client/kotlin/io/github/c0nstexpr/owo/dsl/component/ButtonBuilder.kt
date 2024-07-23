package io.github.c0nstexpr.owo.dsl.component

import io.github.c0nstexpr.owo.dsl.applyBuilt
import io.github.c0nstexpr.owo.dsl.canBuild
import io.github.c0nstexpr.owo.dsl.invalidBuilder
import io.wispforest.owo.ui.component.ButtonComponent
import io.wispforest.owo.ui.component.Components
import java.util.function.Consumer

open class ButtonBuilder : ButtonWidgetBuilder() {
    var onPress = invalidBuilder<Consumer<ButtonComponent>>()

    override fun build() = Components.button(message.build()) {}!!.apply(::applyTo)

    override val canBuild get() = message.canBuild
}

fun ButtonBuilder.applyTo(component: ButtonComponent) {
    (this as ButtonWidgetBuilder).applyTo(component)
    onPress.applyBuilt(component::onPress)
}
