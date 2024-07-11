package org.c0nstexpr.owo.dsl.component

import net.minecraft.client.MinecraftClient
import net.minecraft.client.gui.widget.TextFieldWidget
import net.minecraft.text.Text
import org.c0nstexpr.owo.dsl.TextBuilder
import org.c0nstexpr.owo.dsl.invalidBuilder
import org.c0nstexpr.owo.dsl.invalidTextBuilder

abstract class TextFieldWidgetBuilder<T : TextFieldWidget> : ClickableWidgetBuilder<T>() {
    var placeholderBuilder = invalidTextBuilder()

    var text = invalidBuilder<String>()

    var maxLength = invalidBuilder<Int>()

    var drawsBackground = invalidBuilder<Boolean>()

    var editableColor = invalidBuilder<Int>()

    var uneditableColor = invalidBuilder<Int>()

    var editable = invalidBuilder<Boolean>()

    var focusUnlocked = invalidBuilder<Boolean>()

    var visible = invalidBuilder<Boolean>()

    var suggestion = invalidBuilder<String>()

    override val canBuild get() = true

    override fun applyTo(component: T) {
        super.applyTo(component)
        if (placeholderBuilder.canBuild) component.setPlaceholder(placeholderBuilder.build())

        if (text.canBuild) component.text = text.build()

        if (maxLength.canBuild) component.setMaxLength(maxLength.build())

        if (drawsBackground.canBuild) component.setDrawsBackground(drawsBackground.build())

        if (editableColor.canBuild) component.setEditableColor(editableColor.build())

        if (uneditableColor.canBuild) component.setUneditableColor(uneditableColor.build())

        if (editable.canBuild) component.setEditable(editable.build())

        if (focusUnlocked.canBuild) component.setFocusUnlocked(focusUnlocked.build())

        if (visible.canBuild) component.isVisible = visible.build()

        if (suggestion.canBuild) component.setSuggestion(suggestion.build())
    }
}

inline fun textFieldWidget(block: TextFieldWidgetBuilder<*>.() -> Unit) =
    object : TextFieldWidgetBuilder<TextFieldWidget>() {
        override fun build() = TextFieldWidget(
            MinecraftClient.getInstance().textRenderer,
            x.build(),
            y.build(),
            0,
            0,
            Text.empty()
        )
    }.apply(block)

inline val TextFieldWidgetBuilder<*>.placeholder get() = placeholderBuilder

inline fun TextFieldWidgetBuilder<*>.placeholder(crossinline block: TextBuilder.() -> Unit) =
    block(placeholderBuilder)
