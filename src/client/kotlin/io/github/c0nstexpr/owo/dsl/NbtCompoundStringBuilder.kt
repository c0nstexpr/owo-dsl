package io.github.c0nstexpr.owo.dsl

import net.minecraft.nbt.StringNbtReader

open class NbtCompoundStringBuilder : NbtCompoundBuilder() {
    var nbtStr = invalidBuilder<String>()

    override fun build() = StringNbtReader.parse(nbtStr.build())!!

    override val canBuild get() = nbtStr.canBuild
}

inline fun nbtCompoundString(block: NbtCompoundStringBuilder.() -> Unit) =
    NbtCompoundStringBuilder().apply(block)
