package io.github.c0nstexpr.owo.dsl

import net.minecraft.text.Text

interface Str2TextBuilder : TextBuilder {
    var str: DslBuilder<String>

    override fun build() = Text.of(str.build())!!

    override val canBuild get() = str.canBuild
}

inline fun str2Text(crossinline block: Str2TextBuilder.() -> Unit) = object : Str2TextBuilder {
    override var str = invalidBuilder<String>()
}.apply(block)
