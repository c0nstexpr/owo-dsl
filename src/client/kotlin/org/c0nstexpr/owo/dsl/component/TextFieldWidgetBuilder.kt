package org.c0nstexpr.owo.dsl.component

import net.minecraft.client.MinecraftClient
import net.minecraft.client.gui.widget.TextFieldWidget
import net.minecraft.text.Text
import org.c0nstexpr.owo.dsl.applyBuild
import org.c0nstexpr.owo.dsl.invalidBuilder
import org.c0nstexpr.owo.dsl.text

open class TextFieldWidgetBuilder : ClickableWidgetBuilder() {
    var placeholderBuilder = text()

    var text = invalidBuilder<String>()

    var maxLength = invalidBuilder<Int>()

    var drawsBackground = invalidBuilder<Boolean>()

    var editableColor = invalidBuilder<Int>()

    var uneditableColor = invalidBuilder<Int>()

    var editable = invalidBuilder<Boolean>()

    var focusUnlocked = invalidBuilder<Boolean>()

    var visible = invalidBuilder<Boolean>()

    var suggestion = invalidBuilder<String>()

    override fun build() = TextFieldWidget(
        MinecraftClient.getInstance().textRenderer,
        x.build(),
        y.build(),
        0,
        0,
        Text.empty()
    ).apply(::applyTo)

    override val canBuild get() = true
}

fun TextFieldWidgetBuilder.applyTo(component: TextFieldWidget) {
    (this as ClickableWidgetBuilder).applyTo(component)

    placeholderBuilder.applyBuild(component::setPlaceholder)
    text.applyBuild(component::setText)
    maxLength.applyBuild(component::setMaxLength)
    drawsBackground.applyBuild(component::setDrawsBackground)
    editableColor.applyBuild(component::setEditableColor)
    uneditableColor.applyBuild(component::setUneditableColor)
    editable.applyBuild(component::setEditable)
    focusUnlocked.applyBuild(component::setFocusUnlocked)
    visible.applyBuild(component::setVisible)
    suggestion.applyBuild(component::setSuggestion)
}

inline fun textFieldWidget(block: TextFieldWidgetBuilder.() -> Unit) =
    TextFieldWidgetBuilder().apply(block)
