package io.github.c0nstexpr.owo.dsl.component

import net.minecraft.client.gui.widget.SliderWidget

abstract class SliderWidgetProvider : ClickableWidgetProvider() {
    var value: Double = .0

    override fun provide(): SliderWidget? = null
}
