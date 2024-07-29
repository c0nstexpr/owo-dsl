package io.github.c0nstexpr.owo.dsl

import net.minecraft.nbt.NbtCompound
import net.minecraft.nbt.StringNbtReader

abstract class NbtCompoundBuilder : DslBuilder<NbtCompound> {
    companion object {
        fun String.parseNbtCompound() = object :
            DslBuilder<NbtCompound> by dslBuilder({ StringNbtReader.parse(this) }) {}
    }
}
