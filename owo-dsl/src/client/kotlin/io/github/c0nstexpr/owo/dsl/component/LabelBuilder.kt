package io.github.c0nstexpr.owo.dsl.component

import io.github.c0nstexpr.owo.dsl.built
import io.github.c0nstexpr.owo.dsl.color
import io.github.c0nstexpr.owo.dsl.invalidBuilder
import io.github.c0nstexpr.owo.dsl.text
import io.wispforest.owo.ui.component.Components
import io.wispforest.owo.ui.component.LabelComponent
import io.wispforest.owo.ui.core.HorizontalAlignment
import io.wispforest.owo.ui.core.VerticalAlignment

open class LabelBuilder : BaseComponentBuilder() {
    var text = text()

    var maxWidth = invalidBuilder<Int>()

    var shadow = invalidBuilder<Boolean>()

    var color = color()

    var verticalTextAlignment = invalidBuilder<VerticalAlignment>()

    var horizontalTextAlignment = invalidBuilder<HorizontalAlignment>()

    var lineHeight = invalidBuilder<Int>()

    var lineSpacing = invalidBuilder<Int>()

    override fun build() = Components.label(text.build())!!.apply(::applyTo)

    override val canBuild get() = text.canBuild
}

fun LabelBuilder.applyTo(label: LabelComponent) {
    (this as BaseComponentBuilder).applyTo(label)

    maxWidth.built?.let(label::maxWidth)
    shadow.built?.let(label::shadow)
    color.applyBuild(label::color)
    verticalTextAlignment.built?.let(label::verticalTextAlignment)
    horizontalTextAlignment.built?.let(label::horizontalTextAlignment)
    lineHeight.built?.let(label::lineHeight)
}
