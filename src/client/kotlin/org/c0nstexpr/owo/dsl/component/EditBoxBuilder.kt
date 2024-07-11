package org.c0nstexpr.owo.dsl.component

import net.minecraft.client.MinecraftClient
import net.minecraft.client.gui.widget.EditBoxWidget
import net.minecraft.text.Text
import org.c0nstexpr.owo.dsl.invalidBuilder

abstract class EditBoxBuilder<T : EditBoxWidget> : ScrollableWidgetBuilder<T>() {
    var maxLength = invalidBuilder<Int>()

    var text = invalidBuilder<String>()

    override val canBuild = message.canBuild

    override fun applyTo(component: T) {
        super.applyTo(component)

        if (maxLength.canBuild) component.setMaxLength(maxLength.build())

        if (text.canBuild) component.text = text.build()
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
