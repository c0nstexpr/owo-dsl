package io.github.c0nstexpr.owo.dsl.component

import io.github.c0nstexpr.owo.dsl.built

?.let
import io.github.c0nstexpr.owo.dsl.invalidBuilder
import io.github.c0nstexpr.owo.dsl.text
import net.minecraft.client.MinecraftClient
import net.minecraft.client.gui.widget.TextFieldWidget
import net.minecraft.text.Text

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

    placeholderBuilder.built?.let(component::setPlaceholder)
    text.built?.let(component::setText)
    maxLength.built?.let(component::setMaxLength)
    drawsBackground.built?.let(component::setDrawsBackground)
    editableColor.built?.let(component::setEditableColor)
    uneditableColor.built?.let(component::setUneditableColor)
    editable.built?.let(component::setEditable)
    focusUnlocked.built?.let(component::setFocusUnlocked)
    visible.built?.let(component::setVisible)
    suggestion.built?.let(component::setSuggestion)
}
