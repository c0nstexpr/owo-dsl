package io.github.c0nstexpr.owo.dsl

import io.wispforest.owo.ui.core.Color
import net.minecraft.util.DyeColor

open class ColorFromDyeBuilder : ColorBuilder() {
    var dye = invalidBuilder<DyeColor>()

    override fun build() = Color.ofDye(dye.build())!!

    override val canBuild get() = dye.canBuild
}

inline fun colorFromDye(crossinline block: ColorFromDyeBuilder.() -> Unit) =
    ColorFromDyeBuilder().apply(block)
