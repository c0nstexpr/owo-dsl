package org.c0nstexpr.owo.dsl

import net.minecraft.nbt.NbtCompound
import net.minecraft.nbt.StringNbtReader

open class NbtCompoundBuilder : DelegateBuilder<NbtCompound> {
    override var value = invalidBuilder<NbtCompound>()
}

fun NbtCompoundBuilder.nbtString(nbtStr: OwoBuilder<String>) {
    value = object : OwoBuilder<NbtCompound> {
        override fun build(): NbtCompound = StringNbtReader.parse(nbtStr.build())

        override val canBuild get() = nbtStr.canBuild
    }
}
