package org.c0nstexpr.owo.dsl

import net.minecraft.entity.EntityType
import net.minecraft.registry.Registries
import net.minecraft.util.Identifier

open class EntityTypeBuilder : DelegateBuilder<EntityType<*>> {
    override var value = invalidBuilder<EntityType<*>>()
}

fun EntityTypeBuilder.id(id: OwoBuilder<Identifier>) {
    value = builder { Registries.ENTITY_TYPE.get(id.build()) }
}
