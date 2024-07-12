package org.c0nstexpr.owo.dsl

import net.minecraft.entity.EntityType

abstract class EntityTypeBuilder : OwoBuilder<EntityType<*>>

fun entityType(block: OwoBuilder<EntityType<*>> = invalidBuilder()) = object : EntityTypeBuilder() {
    override fun build() = block.build()

    override val canBuild get() = block.canBuild
}
