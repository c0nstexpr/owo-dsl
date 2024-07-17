package io.github.c0nstexpr.owo.dsl

import net.minecraft.text.Text

interface OrderedTextFromTextBuilder : OrderedTextBuilder {
    var txt: OwoBuilder<Text>

    override fun build() = txt.build().asOrderedText()!!

    override val canBuild get() = txt.canBuild
}

inline fun orderedTextFromText(crossinline block: OrderedTextFromTextBuilder.() -> Unit) =
    object : OrderedTextFromTextBuilder {
        override var txt = invalidBuilder<Text>()
    }.apply(block)
