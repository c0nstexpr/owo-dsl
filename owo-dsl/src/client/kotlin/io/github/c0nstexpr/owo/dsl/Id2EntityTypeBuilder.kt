package io.github.c0nstexpr.owo.dsl

import net.minecraft.registry.Registries

open class Id2EntityTypeBuilder : EntityTypeBuilder() {
    var id = identifier()

    override fun build() = Registries.ENTITY_TYPE.get(id.build())

    override val canBuild get() = id.canBuild
}

inline fun id2EntityType(crossinline block: Id2EntityTypeBuilder.() -> Unit) =
    Id2EntityTypeBuilder().apply(block)
