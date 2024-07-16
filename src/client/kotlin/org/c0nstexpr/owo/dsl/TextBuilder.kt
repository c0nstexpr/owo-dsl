package org.c0nstexpr.owo.dsl

import net.minecraft.text.Text

@FunctionalInterface
fun interface TextBuilder : OwoBuilder<Text>

fun text(block: OwoBuilder<Text> = invalidBuilder()) = object : TextBuilder {
    override fun build() = block.build()

    override val canBuild get() = block.canBuild
}
