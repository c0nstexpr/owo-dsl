package io.github.c0nstexpr.owo.dsl

import io.wispforest.owo.ui.core.Color
import net.minecraft.util.Formatting

open class FormattingColorBuilder : ColorBuilder() {
    var formatting = invalidBuilder<Formatting>()

    override fun build() = Color.ofFormatting(formatting.build())!!

    override val canBuild get() = formatting.canBuild
}

inline fun formattingColor(crossinline block: HsvColorBuilder.() -> Unit) =
    HsvColorBuilder().apply(block)
