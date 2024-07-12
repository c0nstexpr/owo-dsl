package org.c0nstexpr.owo.dsl

import net.minecraft.command.argument.BlockArgumentParser

abstract class BlockResultBuilder : OwoBuilder<BlockArgumentParser.BlockResult>

fun blockResultBuilder(block: OwoBuilder<BlockArgumentParser.BlockResult>) =
    object : BlockResultBuilder() {
        override fun build() = block.build()

        override val canBuild get() = block.canBuild
    }
