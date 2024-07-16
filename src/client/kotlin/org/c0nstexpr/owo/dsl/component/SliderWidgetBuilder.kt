package org.c0nstexpr.owo.dsl.component

import net.minecraft.client.gui.widget.SliderWidget
import org.c0nstexpr.owo.dsl.invalidBuilder

abstract class SliderWidgetBuilder : ClickableWidgetBuilder() {
    var value = invalidBuilder<Double>()

    abstract override fun build(): SliderWidget
}
