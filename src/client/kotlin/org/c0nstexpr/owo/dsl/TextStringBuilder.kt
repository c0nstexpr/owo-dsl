package org.c0nstexpr.owo.dsl

import net.minecraft.text.Text

interface TextStringBuilder : TextBuilder {
    var str: OwoBuilder<String>

    override fun build() = Text.of(str.build())!!

    override val canBuild get() = str.canBuild
}

inline fun textString(crossinline block: TextStringBuilder.() -> Unit) =
    object : TextStringBuilder {
        override var str = invalidBuilder<String>()
    }.apply(block)
