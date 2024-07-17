package io.github.c0nstexpr.owo.dsl

import net.minecraft.command.argument.BlockArgumentParser

abstract class BlockResultBuilder : OwoBuilder<BlockArgumentParser.BlockResult>

fun blockResult(block: OwoBuilder<BlockArgumentParser.BlockResult> = invalidBuilder()) =
    object : BlockResultBuilder() {
        override fun build() = block.build()

        override val canBuild get() = block.canBuild
    }
