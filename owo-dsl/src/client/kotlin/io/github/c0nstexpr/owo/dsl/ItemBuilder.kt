package io.github.c0nstexpr.owo.dsl

import net.minecraft.item.Item
import net.minecraft.registry.Registries

abstract class ItemBuilder : DslBuilder<Item> {
    companion object {
        fun DslBuilder<Id>.toItem() = object :
            DslBuilder<Item> by dslBuilder({ Registries.ITEM.get(value) }) {}
    }
}
