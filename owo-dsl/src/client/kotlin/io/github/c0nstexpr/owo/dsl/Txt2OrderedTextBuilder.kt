package io.github.c0nstexpr.owo.dsl

import net.minecraft.text.Text

interface Txt2OrderedTextBuilder : OrderedTextBuilder {
    var txt: DslBuilder<Text>

    override fun build() = txt.build().asOrderedText()!!

    override val canBuild get() = txt.canBuild
}

inline fun txt2OrderedText(crossinline block: Txt2OrderedTextBuilder.() -> Unit) =
    object : Txt2OrderedTextBuilder {
        override var txt = invalidBuilder<Text>()
    }.apply(block)
