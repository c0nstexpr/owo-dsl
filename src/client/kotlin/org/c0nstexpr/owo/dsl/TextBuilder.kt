package org.c0nstexpr.owo.dsl

import net.minecraft.text.Text

interface TextBuilder : DelegateBuilder<Text>

fun invalidTextBuilder() = object : TextBuilder {
    override var value = invalidBuilder<Text>()
}

fun textOf(block: OwoBuilder<String>) = object : TextBuilder {
    override var value: OwoBuilder<Text> = object : OwoBuilder<Text> {
        override fun build() = Text.of(block.build())

        override val canBuild get() = block.canBuild
    }
}
