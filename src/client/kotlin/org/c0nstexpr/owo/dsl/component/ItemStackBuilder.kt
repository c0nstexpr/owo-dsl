package org.c0nstexpr.owo.dsl.component

import net.minecraft.item.ItemStack
import net.minecraft.registry.Registries
import net.minecraft.util.Identifier
import org.c0nstexpr.owo.dsl.OwoBuilder
import org.c0nstexpr.owo.dsl.invalidBuilder

open class ItemStackBuilder : OwoBuilder<ItemStack> {
    var stack = invalidBuilder<ItemStack>()

    override val canBuild get() = stack.canBuild

    override fun build() = stack.build()
}

fun ItemStackBuilder.itemId(id: OwoBuilder<Identifier>) {
    stack = object : OwoBuilder<ItemStack> {
        override val canBuild get() = id.canBuild && Registries.ITEM.containsId(id.build())

        override fun build() = Registries.ITEM.get(id.build()).defaultStack
    }
}
