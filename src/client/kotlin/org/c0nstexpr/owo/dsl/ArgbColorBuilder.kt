package org.c0nstexpr.owo.dsl

import io.wispforest.owo.ui.core.Color

open class ArgbColorBuilder : ColorBuilder() {
    var argb = invalidBuilder<Int>()

    override fun build() = Color.ofArgb(argb.build())!!

    override val canBuild get() = argb.canBuild
}

inline fun argbColor(crossinline block: ArgbColorBuilder.() -> Unit) =
    ArgbColorBuilder().apply(block)
