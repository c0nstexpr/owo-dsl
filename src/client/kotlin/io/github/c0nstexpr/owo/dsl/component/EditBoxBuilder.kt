package io.github.c0nstexpr.owo.dsl.component

import io.github.c0nstexpr.owo.dsl.applyBuild
import io.github.c0nstexpr.owo.dsl.invalidBuilder
import net.minecraft.client.MinecraftClient
import net.minecraft.client.gui.widget.EditBoxWidget
import net.minecraft.text.Text

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
