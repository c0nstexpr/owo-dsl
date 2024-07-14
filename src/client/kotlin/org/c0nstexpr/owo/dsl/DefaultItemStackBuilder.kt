package org.c0nstexpr.owo.dsl

import net.minecraft.registry.Registries
import net.minecraft.util.Identifier

open class DefaultItemStackBuilder : ItemStackBuilder() {
    var id = invalidBuilder<Identifier>()

    override val canBuild get() = id.canBuild && Registries.ITEM.containsId(id.build())

    override fun build() = Registries.ITEM.get(id.build()).defaultStack!!
}

inline fun itemStackFromId(crossinline block: DefaultItemStackBuilder.() -> Unit) =
    DefaultItemStackBuilder().apply(block)
