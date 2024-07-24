package io.github.c0nstexpr.owo.dsl

import net.minecraft.nbt.NbtCompound
import net.minecraft.nbt.StringNbtReader

abstract class NbtCompoundBuilder : DslBuilder<NbtCompound>

fun nbtCompound() = invalidBuilder<NbtCompound>()

fun nbtCompound(block: DslBuilder<NbtCompound>): NbtCompoundBuilder =
    object : NbtCompoundBuilder(), DslBuilder<NbtCompound> by block {}

fun nbtCompound(block: () -> NbtCompound?) = nbtCompound(dslBuilder { block() })

fun parseNbtCompound(block: DslBuilder<String>) =
    nbtCompound { block.built?.let(StringNbtReader::parse) }
