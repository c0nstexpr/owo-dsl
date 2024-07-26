package io.github.c0nstexpr.owo.dsl

import io.github.c0nstexpr.owo.dsl.DslBuilder.Companion.built
import net.minecraft.entity.EntityType
import net.minecraft.registry.Registries
import net.minecraft.util.Identifier

abstract class EntityTypeBuilder : DslBuilder<EntityType<*>> {
    companion object {
        fun DslBuilder<Identifier>.toEntityType() = Id(this)
    }

    class Id(var id: DslBuilder<Identifier> = nullBuilder()) :
        EntityTypeBuilder(),
        DslBuilder<EntityType<*>> by dslBuilder({ Registries.ENTITY_TYPE.get(id.built) })
}
