package org.c0nstexpr.owo.dsl

import net.minecraft.command.argument.BlockArgumentParser
import net.minecraft.registry.Registries

open class BlockResultBuilder : OwoBuilder<BlockArgumentParser.BlockResult> {
    var string: String? = null
    var registry = Registries.BLOCK.readOnlyWrapper!!
    var allowNbt = true

    override fun build() = BlockArgumentParser.block(
        registry,
        string!!,
        allowNbt
    )!!

    override val canBuild get() = string != null
}
