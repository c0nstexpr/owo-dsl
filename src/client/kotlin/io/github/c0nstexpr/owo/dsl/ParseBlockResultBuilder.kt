package io.github.c0nstexpr.owo.dsl

import net.minecraft.command.argument.BlockArgumentParser
import net.minecraft.registry.Registries

open class ParseBlockResultBuilder : BlockResultBuilder() {
    var string = invalidBuilder<String>()
    var registry = DslBuilder { Registries.BLOCK.readOnlyWrapper!! }
    var allowNbt = DslBuilder { true }

    override fun build() = BlockArgumentParser.block(
        registry.build(),
        string.build(),
        allowNbt.build()
    )!!

    override val canBuild get() = string.canBuild && registry.canBuild && allowNbt.canBuild
}

inline fun parseBlockResult(crossinline block: ParseBlockResultBuilder.() -> Unit) =
    ParseBlockResultBuilder().apply(block)
