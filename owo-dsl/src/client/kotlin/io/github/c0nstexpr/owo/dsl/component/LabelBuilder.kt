package io.github.c0nstexpr.owo.dsl.component

import io.github.c0nstexpr.owo.dsl.DslBuilder
import io.github.c0nstexpr.owo.dsl.nullBuilder
import io.wispforest.owo.ui.component.Components
import io.wispforest.owo.ui.component.LabelComponent
import io.wispforest.owo.ui.core.Color
import io.wispforest.owo.ui.core.HorizontalAlignment
import io.wispforest.owo.ui.core.VerticalAlignment
import net.minecraft.text.Text

open class LabelBuilder(
    var text: DslBuilder<Text> = nullBuilder(),
    var maxWidth: Int? = null,
    var shadow: Boolean? = null,
    var color: DslBuilder<Color> = nullBuilder(),
    var verticalTextAlignment: VerticalAlignment? = null,
    var horizontalTextAlignment: HorizontalAlignment? = null,
    var lineHeight: Int? = null,
    var lineSpacing: Int? = null
) : BaseComponentBuilder() {
    override fun provide() = text.value?.let(Components::label)?.also(::applyTo)

    protected fun applyTo(label: LabelComponent) {
        super.applyTo(label)
        maxWidth?.let(label::maxWidth)
        shadow?.let(label::shadow)
        color.value?.let(label::color)
        verticalTextAlignment?.let(label::verticalTextAlignment)
        horizontalTextAlignment?.let(label::horizontalTextAlignment)
        lineHeight?.let(label::lineHeight)
    }
}
