package org.c0nstexpr.owo.dsl

import net.minecraft.block.Block
import net.minecraft.command.argument.BlockArgumentParser
import net.minecraft.registry.Registries
import net.minecraft.registry.RegistryWrapper

open class ParseBlockResultBuilder : BlockResultBuilder() {
    var string = invalidBuilder<String>()
    var registry: OwoBuilder<RegistryWrapper<Block>> =
        OwoBuilder { Registries.BLOCK.readOnlyWrapper }
    var allowNbt = OwoBuilder { true }

    override fun build() = BlockArgumentParser.block(
        registry.build(),
        string.build(),
        allowNbt.build()
    )!!

    override val canBuild get() = string.canBuild && registry.canBuild && allowNbt.canBuild
}

inline fun parseBlockResult(crossinline block: ParseBlockResultBuilder.() -> Unit) =
    ParseBlockResultBuilder().apply(block)
