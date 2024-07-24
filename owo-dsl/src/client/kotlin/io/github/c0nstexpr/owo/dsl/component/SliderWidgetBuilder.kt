package io.github.c0nstexpr.owo.dsl.component

import io.github.c0nstexpr.owo.dsl.invalidBuilder
import net.minecraft.client.gui.widget.SliderWidget

abstract class SliderWidgetBuilder : ClickableWidgetBuilder() {
    var value = invalidBuilder<Double>()

    abstract override fun build(): SliderWidget?
}
