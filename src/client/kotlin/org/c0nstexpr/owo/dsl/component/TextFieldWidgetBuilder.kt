package org.c0nstexpr.owo.dsl.component

import net.minecraft.client.MinecraftClient
import net.minecraft.client.gui.widget.TextFieldWidget
import net.minecraft.text.Text
import org.c0nstexpr.owo.dsl.TextBuilder
import org.c0nstexpr.owo.dsl.invalidTextBuilder

abstract class TextFieldWidgetBuilder<T : TextFieldWidget> : ClickableWidgetBuilder<T>() {
    var placeholderBuilder = invalidTextBuilder()

    var text: String? = null

    var maxLength: Int? = null

    var drawsBackground: Boolean? = null

    var editableColor: Int? = null

    var uneditableColor: Int? = null

    var editable: Boolean? = null

    var focusUnlocked: Boolean? = null

    var visible: Boolean? = null

    var suggestion: String? = null

    override val canBuild get() = true

    override fun applyTo(component: T) {
        super.applyTo(component)
        if (placeholderBuilder.canBuild) component.setPlaceholder(placeholderBuilder.build())
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

inline fun textFieldWidget(block: TextFieldWidgetBuilder<*>.() -> Unit) =
    object : TextFieldWidgetBuilder<TextFieldWidget>() {
        override fun build() = TextFieldWidget(
            MinecraftClient.getInstance().textRenderer,
            x ?: 0,
            y ?: 0,
            0,
            0,
            Text.empty()
        )
    }.apply(block)

inline val TextFieldWidgetBuilder<*>.placeholder get() = placeholderBuilder

inline fun TextFieldWidgetBuilder<*>.placeholder(crossinline block: TextBuilder.() -> Unit) =
    block(placeholderBuilder)
