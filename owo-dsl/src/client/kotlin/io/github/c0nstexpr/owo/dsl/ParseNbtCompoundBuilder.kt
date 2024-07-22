package io.github.c0nstexpr.owo.dsl

import net.minecraft.nbt.StringNbtReader

open class ParseNbtCompoundBuilder : NbtCompoundBuilder() {
    var nbtStr = invalidBuilder<String>()

    override fun build() = StringNbtReader.parse(nbtStr.build())!!

    override val canBuild get() = nbtStr.canBuild
}

inline fun parseNbtCompound(block: ParseNbtCompoundBuilder.() -> Unit) =
    ParseNbtCompoundBuilder().apply(block)
