package io.github.c0nstexpr.owo.dsl

import net.minecraft.nbt.NbtCompound

abstract class NbtCompoundBuilder : DslBuilder<NbtCompound>

fun nbtCompound(block: DslBuilder<NbtCompound> = invalidBuilder()) = object : NbtCompoundBuilder() {
    override fun build() = block.build()

    override val canBuild get() = block.canBuild
}
