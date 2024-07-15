package org.c0nstexpr.owo.dsl

import io.wispforest.owo.ui.core.Color

open class HsvColorBuilder : ColorBuilder() {
    var hue = invalidBuilder<Float>()

    var saturation = invalidBuilder<Float>()

    var value = invalidBuilder<Float>()

    var alpha = invalidBuilder<Float>()

    override fun build() = if (alpha.canBuild) Color.ofHsv(
        hue.build(),
        saturation.build(),
        value.build(),
        alpha.build()
    )!! else Color.ofHsv(hue.build(), saturation.build(), value.build())!!

    override val canBuild get() = hue.canBuild && saturation.canBuild && value.canBuild
}

inline fun hsvColor(crossinline block: HsvColorBuilder.() -> Unit) = HsvColorBuilder().apply(block)
