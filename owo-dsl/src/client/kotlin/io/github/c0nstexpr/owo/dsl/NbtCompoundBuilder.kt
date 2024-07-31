package io.github.c0nstexpr.owo.dsl

import net.minecraft.nbt.NbtCompound
import net.minecraft.nbt.NbtElement
import net.minecraft.nbt.StringNbtReader

open class NbtCompoundBuilder(var entries: Map<String, NbtElement> = mapOf()) :
    DslBuilder<NbtCompound> by
    dslBuilder({ NbtCompound().apply { entries.forEach { (k, v) -> put(k, v) } } }) {
    companion object {
        fun String.parseNbtCompound() = object :
            DslBuilder<NbtCompound> by dslBuilder({ StringNbtReader.parse(this) }) {}
    }
}
