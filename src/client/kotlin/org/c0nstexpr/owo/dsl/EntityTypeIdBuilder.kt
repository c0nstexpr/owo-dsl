package org.c0nstexpr.owo.dsl

import net.minecraft.registry.Registries

open class EntityTypeIdBuilder : EntityTypeBuilder() {
    var id = identifier()

    override fun build() = Registries.ENTITY_TYPE.get(id.build())

    override val canBuild get() = id.canBuild
}

inline fun entityTypeId(crossinline block: EntityTypeIdBuilder.() -> Unit) =
    EntityTypeIdBuilder().apply(block)
