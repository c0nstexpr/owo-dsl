package io.github.c0nstexpr.owo.dsl.component

import io.github.c0nstexpr.owo.dsl.nullBuilder
import net.minecraft.client.gui.widget.SliderWidget

abstract class SliderWidgetBuilder : ClickableWidgetBuilder() {
    var value = nullBuilder<Double>()

    abstract override fun build(): SliderWidget?
}
