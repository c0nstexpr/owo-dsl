package io.github.c0nstexpr.owo.dsl

import io.github.c0nstexpr.owo.dsl.DslBuilder.Companion.built
import net.minecraft.item.Item
import net.minecraft.registry.Registries
import net.minecraft.util.Identifier

abstract class ItemBuilder : DslBuilder<Item> {
    companion object {
        fun DslBuilder<Identifier>.toItem(): ItemBuilder = object :
            ItemBuilder(),
            DslBuilder<Item> by dslBuilder({ Registries.ITEM.get(built) }) {}
    }
}
