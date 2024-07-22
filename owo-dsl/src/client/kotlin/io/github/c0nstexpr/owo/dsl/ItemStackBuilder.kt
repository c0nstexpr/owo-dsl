package io.github.c0nstexpr.owo.dsl

import net.minecraft.item.ItemStack

abstract class ItemStackBuilder : DslBuilder<ItemStack>

fun itemStack(block: DslBuilder<ItemStack> = invalidBuilder()) = object : ItemStackBuilder() {
    override fun build() = block.build()

    override val canBuild get() = block.canBuild
}

inline fun itemStack(crossinline block: () -> ItemStack) = itemStack(dslBuilder { block() })
