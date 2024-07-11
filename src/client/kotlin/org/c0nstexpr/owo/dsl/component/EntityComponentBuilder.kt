package org.c0nstexpr.owo.dsl.component

import io.wispforest.owo.ui.component.Components
import io.wispforest.owo.ui.component.EntityComponent
import io.wispforest.owo.ui.core.Sizing
import net.minecraft.entity.EntityType
import net.minecraft.nbt.NbtCompound
import org.c0nstexpr.owo.dsl.EntityTypeBuilder
import org.c0nstexpr.owo.dsl.NbtCompoundBuilder
import org.c0nstexpr.owo.dsl.OwoBuilder
import org.c0nstexpr.owo.dsl.invalidBuilder

abstract class EntityComponentBuilder<T : EntityComponent<*>> : BaseComponentBuilder<T>() {
    var entityTypeBuilder = EntityTypeBuilder()

    var nbtCompoundBuilder = NbtCompoundBuilder()

    var allowMouseRotation = invalidBuilder<Boolean>()

    var lookAtCursor = invalidBuilder<Boolean>()

    var scale = invalidBuilder<Float>()

    var scaleToFit = invalidBuilder<Boolean>()

    var showNametag = invalidBuilder<Boolean>()

    override val canBuild get() = entityType.canBuild

    override fun applyTo(component: T) {
        super.applyTo(component)

        if (allowMouseRotation.canBuild) component.allowMouseRotation(allowMouseRotation.build())

        if (lookAtCursor.canBuild) component.lookAtCursor(lookAtCursor.build())

        if (scale.canBuild) component.scale(scale.build())

        if (scaleToFit.canBuild) component.scaleToFit(scaleToFit.build())

        if (showNametag.canBuild) component.showNametag(showNametag.build())
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
