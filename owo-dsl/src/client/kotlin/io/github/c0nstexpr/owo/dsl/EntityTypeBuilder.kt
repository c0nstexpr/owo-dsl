package io.github.c0nstexpr.owo.dsl

import net.minecraft.entity.EntityType

abstract class EntityTypeBuilder : DslBuilder<EntityType<*>>

fun entityType(block: DslBuilder<EntityType<*>> = invalidBuilder()) = object : EntityTypeBuilder() {
    override fun build() = block.build()

    override val canBuild get() = block.canBuild
}

inline fun entityType(crossinline block: () -> EntityType<*>) = entityType(dslBuilder { block() })
