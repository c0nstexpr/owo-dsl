package io.github.c0nstexpr.owo.dsl.component

import io.github.c0nstexpr.owo.dsl.applyBuilt
import io.github.c0nstexpr.owo.dsl.canBuild
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

    maxLength.applyBuilt(component::setMaxLength)
    text.applyBuilt(component::setText)
}
