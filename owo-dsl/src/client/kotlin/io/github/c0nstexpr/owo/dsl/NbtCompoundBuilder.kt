package io.github.c0nstexpr.owo.dsl

import io.github.c0nstexpr.owo.dsl.DslBuilder.Companion.built
import net.minecraft.nbt.NbtCompound
import net.minecraft.nbt.StringNbtReader

abstract class NbtCompoundBuilder : DslBuilder<NbtCompound> {
    class Parse(var str: DslBuilder<String>) :
        NbtCompoundBuilder(),
        DslBuilder<NbtCompound> by dslBuilder({ str.built?.let(StringNbtReader::parse) })
}
