package org.c0nstexpr.owo.dsl

import net.minecraft.nbt.NbtCompound
import net.minecraft.nbt.StringNbtReader

open class NbtCompoundBuilder : OwoBuilder<NbtCompound> {
    var nbt = invalidBuilder<NbtCompound>()

    override val canBuild get() = nbt.canBuild

    override fun build() = nbt.build()
}

fun NbtCompoundBuilder.nbtString(nbtStr: String?) {
    nbt = builder { StringNbtReader.parse(nbtStr!!) }
}
