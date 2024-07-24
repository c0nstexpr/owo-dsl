package io.github.c0nstexpr.owo.dsl

import io.github.c0nstexpr.owo.dsl.BlockResultBuilder.Companion.Parse
import net.minecraft.block.Block
import net.minecraft.command.argument.BlockArgumentParser
import net.minecraft.command.argument.BlockArgumentParser.BlockResult
import net.minecraft.registry.Registries
import net.minecraft.registry.RegistryWrapper

abstract class BlockResultBuilder : DslBuilder<BlockResult> {
    companion object {
        class Parse(
            var string: DslBuilder<String> = invalidBuilder(),
            var registry: DslBuilder<RegistryWrapper<Block>> =
                dslBuilder { Registries.BLOCK.readOnlyWrapper!! },
            var allowNbt: DslBuilder<Boolean> = dslBuilder { true }
        ) : BlockResultBuilder(),
            DslBuilder<BlockResult> by dslBuilder({
                val r = registry.built ?: return@dslBuilder null
                val s = string.built ?: return@dslBuilder null
                val a = allowNbt.built ?: return@dslBuilder null

                BlockArgumentParser.block(r, s, a)
            })
    }
}

fun blockResult() = invalidBuilder<BlockResult>()

fun blockResult(block: DslBuilder<BlockResult>): BlockResultBuilder =
    object : BlockResultBuilder(), DslBuilder<BlockResult> by block {}

fun blockResult(block: () -> BlockResult?) = blockResult(dslBuilder { block() })

inline fun parseBlockResult(crossinline block: Parse.() -> Unit) = Parse().apply(block)
