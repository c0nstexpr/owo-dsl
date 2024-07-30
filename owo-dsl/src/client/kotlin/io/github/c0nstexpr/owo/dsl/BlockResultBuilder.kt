package io.github.c0nstexpr.owo.dsl

import io.github.c0nstexpr.owo.dsl.DslBuilder.Companion.built
import net.minecraft.block.BlockState
import net.minecraft.command.argument.BlockArgumentParser.BlockResult
import net.minecraft.nbt.NbtCompound
import net.minecraft.state.property.Property

open class BlockResultBuilder(
    var state: DslBuilder<BlockState> = nullBuilder(),
    var properties: MutableMap<Property<*>, Comparable<*>> = mutableMapOf(),
    var nbt: DslBuilder<NbtCompound> = nullBuilder()
) : DslBuilder<BlockResult> by dslBuilder({
        BlockResult(state.built ?: return@dslBuilder null, properties, nbt.built)
    })
