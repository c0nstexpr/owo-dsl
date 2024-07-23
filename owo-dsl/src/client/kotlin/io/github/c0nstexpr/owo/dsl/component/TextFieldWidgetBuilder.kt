package io.github.c0nstexpr.owo.dsl.component

import io.github.c0nstexpr.owo.dsl.applyBuilt
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

    placeholderBuilder.applyBuilt(component::setPlaceholder)
    text.applyBuilt(component::setText)
    maxLength.applyBuilt(component::setMaxLength)
    drawsBackground.applyBuilt(component::setDrawsBackground)
    editableColor.applyBuilt(component::setEditableColor)
    uneditableColor.applyBuilt(component::setUneditableColor)
    editable.applyBuilt(component::setEditable)
    focusUnlocked.applyBuilt(component::setFocusUnlocked)
    visible.applyBuilt(component::setVisible)
    suggestion.applyBuilt(component::setSuggestion)
}
