package org.c0nstexpr.owo.dsl

import io.wispforest.owo.ui.core.Color

open class RgbColorBuilder : ColorBuilder() {
    var rgb = invalidBuilder<Int>()

    override fun build() = Color.ofRgb(rgb.build())!!

    override val canBuild get() = rgb.canBuild
}

inline fun rgbColor(crossinline block: RgbColorBuilder.() -> Unit) = RgbColorBuilder().apply(block)
