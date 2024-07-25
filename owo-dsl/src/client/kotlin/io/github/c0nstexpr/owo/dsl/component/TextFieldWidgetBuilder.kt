package io.github.c0nstexpr.owo.dsl.component

import io.github.c0nstexpr.owo.dsl.DslBuilder.Companion.built
import io.github.c0nstexpr.owo.dsl.nullBuilder
import io.github.c0nstexpr.owo.dsl.textRenderer
import net.minecraft.client.gui.widget.TextFieldWidget
import net.minecraft.text.Text

open class TextFieldWidgetBuilder : ClickableWidgetBuilder() {
    var placeholderBuilder = nullBuilder<Text>()

    var text = nullBuilder<String>()

    var maxLength = nullBuilder<Int>()

    var drawsBackground = nullBuilder<Boolean>()

    var editableColor = nullBuilder<Int>()

    var uneditableColor = nullBuilder<Int>()

    var editable = nullBuilder<Boolean>()

    var focusUnlocked = nullBuilder<Boolean>()

    var visible = nullBuilder<Boolean>()

    var suggestion = nullBuilder<String>()

    override fun build(): TextFieldWidget? = TextFieldWidget(
        textRenderer,
        x.built ?: 0,
        y.built ?: 0,
        0,
        0,
        Text.empty()
    ).also(::applyTo)
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
