package org.c0nstexpr.owo.dsl

import net.minecraft.command.argument.BlockArgumentParser
import net.minecraft.registry.Registries

open class BlockResultBuilder : OwoBuilder<BlockArgumentParser.BlockResult> {
    var string: String? = null
    var registry = Registries.BLOCK.readOnlyWrapper!!
    var allowNbt = true

    override fun build() = string?.let {
        BlockArgumentParser.block(
            registry,
            it,
            allowNbt
        )
    }
}
