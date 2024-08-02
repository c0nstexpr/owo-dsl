package io.github.c0nstexpr.owo.dsl

import net.minecraft.block.Block
import net.minecraft.command.argument.BlockArgumentParser
import net.minecraft.registry.Registries
import net.minecraft.registry.RegistryWrapper

open class ParseBlockResultBuilder(
    var string: String? = null,
    var registry: DslBuilder<RegistryWrapper<Block>> =
        dslBuilder { Registries.BLOCK.readOnlyWrapper!! },
    var allowNbt: Boolean = true
) : DslBuilder<BlockArgumentParser.BlockResult> by dslBuilder({
        BlockArgumentParser.block(
            registry.value ?: return@dslBuilder null,
            string ?: return@dslBuilder null,
            allowNbt
        )
    })
