package io.github.c0nstexpr.owo.dsl

import net.minecraft.command.argument.BlockArgumentParser

abstract class BlockResultBuilder : DslBuilder<BlockArgumentParser.BlockResult>

fun blockResult(block: DslBuilder<BlockArgumentParser.BlockResult> = invalidBuilder()) =
    object : BlockResultBuilder() {
        override fun build() = block.build()

        override val canBuild get() = block.canBuild
    }

inline fun blockResult(crossinline block: () -> BlockArgumentParser.BlockResult) =
    blockResult(dslBuilder { block() })
