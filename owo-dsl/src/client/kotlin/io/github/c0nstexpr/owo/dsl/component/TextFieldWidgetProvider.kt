package io.github.c0nstexpr.owo.dsl.component

import io.github.c0nstexpr.owo.dsl.DslBuilder.Companion.built
import io.github.c0nstexpr.owo.dsl.nullBuilder
import io.github.c0nstexpr.owo.dsl.textRenderer
import net.minecraft.client.gui.widget.TextFieldWidget
import net.minecraft.text.Text

open class TextFieldWidgetProvider : ClickableWidgetProvider() {
    var placeholderBuilder = nullBuilder<Text>()

    var text: String? = null

    var maxLength: Int? = null

    var drawsBackground: Boolean? = null

    var editableColor: Int? = null

    var uneditableColor: Int? = null

    var editable: Boolean? = null

    var focusUnlocked: Boolean? = null

    var visible: Boolean? = null

    var suggestion: String? = null

    override fun provide(): TextFieldWidget? = TextFieldWidget(
        textRenderer,
        x ?: 0,
        y ?: 0,
        0,
        0,
        Text.empty()
    ).also(::applyTo)

    protected fun applyTo(component: TextFieldWidget) {
        super.applyTo(component)
        placeholderBuilder.built?.let(component::setPlaceholder)
        text?.let(component::setText)
        maxLength?.let(component::setMaxLength)
        drawsBackground?.let(component::setDrawsBackground)
        editableColor?.let(component::setEditableColor)
        uneditableColor?.let(component::setUneditableColor)
        editable?.let(component::setEditable)
        focusUnlocked?.let(component::setFocusUnlocked)
        visible?.let(component::setVisible)
        suggestion?.let(component::setSuggestion)
    }
}
