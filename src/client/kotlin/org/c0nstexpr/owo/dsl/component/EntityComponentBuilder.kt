package org.c0nstexpr.owo.dsl.component

import io.wispforest.owo.ui.component.Components
import io.wispforest.owo.ui.component.EntityComponent
import io.wispforest.owo.ui.core.Sizing
import net.minecraft.entity.EntityType
import net.minecraft.nbt.NbtCompound
import net.minecraft.nbt.StringNbtReader
import net.minecraft.registry.Registries
import org.c0nstexpr.owo.dsl.IdentifierBuilder

abstract class EntityComponentBuilder<T : EntityComponent<*>> : BaseComponentBuilder<T>() {
    var entityId = IdentifierBuilder()

    var nbtCompound: NbtCompound? = null

    var allowMouseRotation: Boolean? = null

    var lookAtCursor: Boolean? = null

    var scale: Float? = null

    var scaleToFit: Boolean? = null

    var showNametag: Boolean? = null

    override fun applyTo(component: T) {
        super.applyTo(component)
        allowMouseRotation?.let(component::allowMouseRotation)
        lookAtCursor?.let(component::lookAtCursor)
        scale?.let(component::scale)
        scaleToFit?.let(component::scaleToFit)
        showNametag?.let(component::showNametag)
    }
}

inline val EntityComponentBuilder<*>.entityType: EntityType<*>?
    get() = Registries.ENTITY_TYPE.getOrEmpty(entityId.build()).orElse(null)

inline var EntityComponentBuilder<*>.nbtCompoundString: String?
    get() = nbtCompound?.toString()
    set(value) {
        nbtCompound = value?.let(StringNbtReader::parse)
    }

inline fun entityComponent(
    crossinline block: EntityComponentBuilder<EntityComponent<*>>.() -> Unit
) = object : EntityComponentBuilder<EntityComponent<*>>() {
    override fun build() = Components.entity(Sizing.content(), entityType, nbtCompound)
}.apply(block)
