package org.c0nstexpr.owo.dsl.component

import org.c0nstexpr.owo.dsl.invalidBuilder

abstract class SliderWidgetBuilder : ClickableWidgetBuilder() {
    var value = invalidBuilder<Double>()
}
