package io.github.c0nstexpr.owo.dsl

import io.github.c0nstexpr.owo.dsl.EntityTypeBuilder.Companion.Id
import net.minecraft.entity.EntityType
import net.minecraft.registry.Registries
import net.minecraft.util.Identifier

abstract class EntityTypeBuilder : DslBuilder<EntityType<*>> {
    companion object {
        class Id(var id: DslBuilder<Identifier> = invalidBuilder()) :
            EntityTypeBuilder(),
            DslBuilder<EntityType<*>> by dslBuilder({ Registries.ENTITY_TYPE.get(id.built) })
    }
}

fun entityType() = invalidBuilder<DslBuilder<EntityType<*>>>()

fun entityType(block: DslBuilder<EntityType<*>> = invalidBuilder()): EntityTypeBuilder =
    object : EntityTypeBuilder(), DslBuilder<EntityType<*>> by block {}

fun entityType(block: () -> EntityType<*>?) = entityType(dslBuilder { block() })

fun DslBuilder<Identifier>.toEntityType() = Id(this)
