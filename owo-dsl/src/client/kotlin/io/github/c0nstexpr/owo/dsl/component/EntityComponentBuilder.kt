package io.github.c0nstexpr.owo.dsl.component

import io.github.c0nstexpr.owo.dsl.DslBuilder.Companion.built
import io.github.c0nstexpr.owo.dsl.nullBuilder
import io.wispforest.owo.ui.component.Components
import io.wispforest.owo.ui.component.EntityComponent
import io.wispforest.owo.ui.core.Sizing
import net.minecraft.entity.EntityType
import net.minecraft.nbt.NbtCompound

open class EntityComponentBuilder : BaseComponentBuilder() {
    var entityType = nullBuilder<EntityType<*>>()

    var nbtCompound = nullBuilder<NbtCompound>()

    var allowMouseRotation = nullBuilder<Boolean>()

    var lookAtCursor = nullBuilder<Boolean>()

    var scale = nullBuilder<Float>()

    var scaleToFit = nullBuilder<Boolean>()

    var showNametag = nullBuilder<Boolean>()

    override fun build(): EntityComponent<*>? {
        return Components.entity(
            Sizing.content(),
            entityType.built ?: return null,
            nbtCompound.built ?: return null
        )!!
            .also(::applyTo)
    }

    protected fun applyTo(component: EntityComponent<*>) {
        super.applyTo(component)
        allowMouseRotation.built?.let(component::allowMouseRotation)
        lookAtCursor.built?.let(component::lookAtCursor)
        scale.built?.let(component::scale)
        scaleToFit.built?.let(component::scaleToFit)
        showNametag.built?.let(component::showNametag)
    }
}
