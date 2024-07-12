package org.c0nstexpr.owo.dsl

import net.minecraft.nbt.NbtCompound

abstract class NbtCompoundBuilder : OwoBuilder<NbtCompound>

fun nbtCompound(block: OwoBuilder<NbtCompound> = invalidBuilder()) = object : NbtCompoundBuilder() {
    override fun build() = block.build()

    override val canBuild get() = block.canBuild
}
