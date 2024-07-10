package org.c0nstexpr.owo.dsl.component

import net.minecraft.client.MinecraftClient
import net.minecraft.client.gui.widget.EditBoxWidget
import net.minecraft.text.Text

abstract class EditBoxBuilder<T : EditBoxWidget> : ScrollableWidgetBuilder<T>() {
    var maxLength: Int? = null

    var text: String? = null

    override val canBuild = message.canBuild

    override fun applyTo(component: T) {
        super.applyTo(component)
        maxLength?.let(component::setMaxLength)
        text?.let(component::setText)
    }
}

inline fun editBoxWidget(crossinline block: EditBoxBuilder<EditBoxWidget>.() -> Unit) =
    object : EditBoxBuilder<EditBoxWidget>() {
        override fun build() = EditBoxWidget(
            MinecraftClient.getInstance().textRenderer,
            0,
            0,
            0,
            0,
            Text.empty(),
            message.build()
        )
    }.apply(block)
