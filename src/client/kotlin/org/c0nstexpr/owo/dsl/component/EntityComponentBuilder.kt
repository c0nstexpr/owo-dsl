package org.c0nstexpr.owo.dsl.component

import io.wispforest.owo.ui.component.Components
import io.wispforest.owo.ui.component.EntityComponent
import io.wispforest.owo.ui.core.Sizing
import net.minecraft.entity.EntityType
import net.minecraft.nbt.NbtCompound
import org.c0nstexpr.owo.dsl.EntityTypeBuilder
import org.c0nstexpr.owo.dsl.NbtCompoundBuilder
import org.c0nstexpr.owo.dsl.OwoBuilder

abstract class EntityComponentBuilder<T : EntityComponent<*>> : BaseComponentBuilder<T>() {
    var entityTypeBuilder = EntityTypeBuilder()

    var nbtCompoundBuilder = NbtCompoundBuilder()

    var allowMouseRotation: Boolean? = null

    var lookAtCursor: Boolean? = null

    var scale: Float? = null

    var scaleToFit: Boolean? = null

    var showNametag: Boolean? = null

    override val canBuild get() = entityType.canBuild

    override fun applyTo(component: T) {
        super.applyTo(component)
        allowMouseRotation?.let(component::allowMouseRotation)
        lookAtCursor?.let(component::lookAtCursor)
        scale?.let(component::scale)
        scaleToFit?.let(component::scaleToFit)
        showNametag?.let(component::showNametag)
    }
}

inline fun entityComponent(
    crossinline block: EntityComponentBuilder<EntityComponent<*>>.() -> Unit
) = object : EntityComponentBuilder<EntityComponent<*>>() {
    override fun build() = Components.entity(
        Sizing.content(),
        entityTypeBuilder.build(),
        nbtCompoundBuilder.build()
    )
}.apply(block)

inline val EntityComponentBuilder<*>.entityType get() = entityTypeBuilder

inline fun EntityComponentBuilder<*>.entityType(
    crossinline block: OwoBuilder<EntityType<*>>.() -> Unit
) = block(entityTypeBuilder)

inline val EntityComponentBuilder<*>.nbtCompound get() = nbtCompoundBuilder

inline fun EntityComponentBuilder<*>.nbtCompound(
    crossinline block: OwoBuilder<NbtCompound>.() -> Unit
) = block(nbtCompoundBuilder)
