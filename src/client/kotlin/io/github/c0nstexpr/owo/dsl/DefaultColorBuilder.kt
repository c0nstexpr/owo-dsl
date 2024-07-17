package io.github.c0nstexpr.owo.dsl

import io.wispforest.owo.ui.core.Color

open class DefaultColorBuilder : ColorBuilder() {
    var red = invalidBuilder<Float>()
    var green = invalidBuilder<Float>()
    var blue = invalidBuilder<Float>()

    override fun build() = Color(red.build(), green.build(), blue.build())

    override val canBuild get() = red.canBuild && green.canBuild && blue.canBuild
}

inline fun defaultColor(crossinline block: DefaultColorBuilder.() -> Unit) =
    DefaultColorBuilder().apply(block)
