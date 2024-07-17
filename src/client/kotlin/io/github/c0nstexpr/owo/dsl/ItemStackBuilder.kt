package io.github.c0nstexpr.owo.dsl

import net.minecraft.item.ItemStack

abstract class ItemStackBuilder : OwoBuilder<ItemStack>

fun itemStack(block: OwoBuilder<ItemStack> = invalidBuilder()) = object : ItemStackBuilder() {
    override fun build() = block.build()

    override val canBuild get() = block.canBuild
}
