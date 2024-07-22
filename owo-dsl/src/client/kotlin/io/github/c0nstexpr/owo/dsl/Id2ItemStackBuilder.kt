package io.github.c0nstexpr.owo.dsl

import net.minecraft.registry.Registries
import net.minecraft.util.Identifier

open class Id2ItemStackBuilder : ItemStackBuilder() {
    var id = invalidBuilder<Identifier>()

    override val canBuild get() = id.canBuild

    override fun build() = Registries.ITEM.get(id.build()).defaultStack!!
}

inline fun id2ItemStack(crossinline block: Id2ItemStackBuilder.() -> Unit) =
    Id2ItemStackBuilder().apply(block)
