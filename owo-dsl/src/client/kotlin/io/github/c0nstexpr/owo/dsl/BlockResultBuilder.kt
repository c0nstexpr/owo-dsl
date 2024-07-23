package io.github.c0nstexpr.owo.dsl

import net.minecraft.command.argument.BlockArgumentParser.BlockResult

abstract class BlockResultBuilder : DslBuilder<BlockResult> {
    open class Entrance :
        BlockResultBuilder(),
        DslBuilder<BlockResult> by invalidBuilder() {
        fun by(block: DslBuilder<BlockResult>): BlockResultBuilder =
            object : BlockResultBuilder(), DslBuilder<BlockResult> by block {}

        fun by(block: () -> BlockResult?) = by(dslBuilder { block() })

        fun with(value: BlockResult) = by { value }
    }
}

fun <R> blockResult(block: BlockResultBuilder.() -> R) = BlockResultBuilder.Entrance().block()
