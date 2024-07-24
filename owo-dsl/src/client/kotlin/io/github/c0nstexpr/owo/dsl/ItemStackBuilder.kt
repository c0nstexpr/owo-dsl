package io.github.c0nstexpr.owo.dsl

import net.minecraft.item.ItemStack
import net.minecraft.registry.Registries
import net.minecraft.util.Identifier

abstract class ItemStackBuilder : DslBuilder<ItemStack>

fun itemStack() = invalidBuilder<ItemStack>()

fun itemStack(block: DslBuilder<ItemStack>): ItemStackBuilder =
    object : ItemStackBuilder(), DslBuilder<ItemStack> by block {}

fun itemStack(block: () -> ItemStack?) = itemStack(dslBuilder { block() })

fun DslBuilder<Identifier>.toItemStack() = itemStack { Registries.ITEM.get(built).defaultStack }
