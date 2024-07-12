package org.c0nstexpr.owo.dsl

import net.minecraft.text.Text

fun interface TextBuilder : OwoBuilder<Text>

fun text(block: OwoBuilder<Text> = invalidBuilder()): TextBuilder = object : TextBuilder {
    override fun build() = block.build()

    override val canBuild get() = block.canBuild
}
