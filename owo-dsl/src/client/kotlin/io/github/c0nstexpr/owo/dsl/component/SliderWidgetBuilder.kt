package io.github.c0nstexpr.owo.dsl.component

import net.minecraft.client.gui.widget.SliderWidget

abstract class SliderWidgetBuilder : ClickableWidgetBuilder() {
    var value: Double = .0

    override fun buildComponent(): SliderWidget? = null
}
