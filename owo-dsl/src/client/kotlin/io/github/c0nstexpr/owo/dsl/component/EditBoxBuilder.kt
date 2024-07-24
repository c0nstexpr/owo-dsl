package io.github.c0nstexpr.owo.dsl.component

import io.github.c0nstexpr.owo.dsl.built
import io.github.c0nstexpr.owo.dsl.invalidBuilder
import net.minecraft.client.MinecraftClient
import net.minecraft.client.gui.widget.EditBoxWidget
import net.minecraft.text.Text

open class EditBoxBuilder : ScrollableWidgetBuilder() {
    var maxLength = invalidBuilder<Int>()

    var text = invalidBuilder<String>()

    override fun build(): EditBoxWidget? {
        return EditBoxWidget(
            MinecraftClient.getInstance().textRenderer,
            0,
            0,
            0,
            0,
            Text.empty(),
            message.built ?: return null
        ).apply(::applyTo)
    }
}

fun EditBoxBuilder.applyTo(component: EditBoxWidget) {
    (this as ScrollableWidgetBuilder).applyTo(component)

    maxLength.built?.let(component::setMaxLength)
    text.built?.let(component::setText)
}
