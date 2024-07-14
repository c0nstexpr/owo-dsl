package org.c0nstexpr.owo.dsl.component

import net.minecraft.client.MinecraftClient
import net.minecraft.client.gui.widget.EditBoxWidget
import net.minecraft.text.Text
import org.c0nstexpr.owo.dsl.applyBuild
import org.c0nstexpr.owo.dsl.invalidBuilder

open class EditBoxBuilder : ScrollableWidgetBuilder() {
    var maxLength = invalidBuilder<Int>()

    var text = invalidBuilder<String>()

    override fun build() = EditBoxWidget(
        MinecraftClient.getInstance().textRenderer,
        0,
        0,
        0,
        0,
        Text.empty(),
        message.build()
    ).apply(::applyTo)

    override val canBuild = message.canBuild
}

fun EditBoxBuilder.applyTo(component: EditBoxWidget) {
    (this as ScrollableWidgetBuilder).applyTo(component)

    maxLength.applyBuild(component::setMaxLength)
    text.applyBuild(component::setText)
}

inline fun editBoxWidget(crossinline block: EditBoxBuilder.() -> Unit) =
    object : EditBoxBuilder() {}.apply(block)
