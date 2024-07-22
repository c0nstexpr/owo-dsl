package io.github.c0nstexpr.owo.dsl

import io.wispforest.owo.ui.core.Color
import net.minecraft.util.DyeColor

open class Dye2ColorBuilder : ColorBuilder() {
    var dye = invalidBuilder<DyeColor>()

    override fun build() = Color.ofDye(dye.build())!!

    override val canBuild get() = dye.canBuild
}

inline fun dye2Color(crossinline block: Dye2ColorBuilder.() -> Unit) =
    Dye2ColorBuilder().apply(block)
