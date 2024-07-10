package org.c0nstexpr.owo.dsl.component

import net.minecraft.client.gui.widget.TextFieldWidget
import org.c0nstexpr.owo.dsl.TextBuilder

abstract class TextFieldWidgetBuilder<T : TextFieldWidget> : ClickableWidgetBuilder<T>() {
    var placeholderBuilder = TextBuilder { null }

    var text: String? = null

    var maxLength: Int? = null

    var drawsBackground: Boolean? = null

    var editableColor: Int? = null

    var uneditableColor: Int? = null

    var editable: Boolean? = null

    var focusUnlocked: Boolean? = null

    var visible: Boolean? = null

    var suggestion: String? = null

    override fun applyTo(component: T) {
        super.applyTo(component)
        placeholderBuilder.build()?.let(component::setPlaceholder)
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

inline val TextFieldWidgetBuilder<*>.placeholder: TextBuilder
    get() = placeholderBuilder

inline fun TextFieldWidgetBuilder<*>.placeholder(crossinline block: TextBuilder.() -> Unit) =
    placeholderBuilder.apply(block)
