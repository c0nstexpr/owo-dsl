package io.github.c0nstexpr.owo.dsl

import io.wispforest.owo.ui.core.Color

open class ArgbColorBuilder(var argb: DslBuilder<Int> = invalidBuilder()) :
    ColorBuilder(),
    DslBuilder<Color> by color({ argb.applyBuild(Color::ofArgb) })

inline fun argbColor(crossinline block: ArgbColorBuilder.() -> Unit) =
    ArgbColorBuilder().apply(block)
