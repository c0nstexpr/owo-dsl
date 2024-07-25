package io.github.c0nstexpr.owo.dsl.component

import io.github.c0nstexpr.owo.dsl.DslBuilder.Companion.built
import io.github.c0nstexpr.owo.dsl.nullBuilder
import io.wispforest.owo.ui.component.Components
import io.wispforest.owo.ui.component.LabelComponent
import io.wispforest.owo.ui.core.Color
import io.wispforest.owo.ui.core.HorizontalAlignment
import io.wispforest.owo.ui.core.VerticalAlignment
import net.minecraft.text.Text

open class LabelBuilder : BaseComponentBuilder() {
    var text = nullBuilder<Text>()

    var maxWidth = nullBuilder<Int>()

    var shadow = nullBuilder<Boolean>()

    var color = nullBuilder<Color>()

    var verticalTextAlignment = nullBuilder<VerticalAlignment>()

    var horizontalTextAlignment = nullBuilder<HorizontalAlignment>()

    var lineHeight = nullBuilder<Int>()

    var lineSpacing = nullBuilder<Int>()

    override fun build() = text.built?.let(Components::label)?.also(::applyTo)
}

fun LabelBuilder.applyTo(label: LabelComponent) {
    (this as BaseComponentBuilder).applyTo(label)

    maxWidth.built?.let(label::maxWidth)
    shadow.built?.let(label::shadow)
    color.built?.let(label::color)
    verticalTextAlignment.built?.let(label::verticalTextAlignment)
    horizontalTextAlignment.built?.let(label::horizontalTextAlignment)
    lineHeight.built?.let(label::lineHeight)
}
