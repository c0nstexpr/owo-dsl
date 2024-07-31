package io.github.c0nstexpr.owo.dsl.component

import io.github.c0nstexpr.owo.dsl.DslBuilder
import io.github.c0nstexpr.owo.dsl.DslBuilder.Companion.built
import io.github.c0nstexpr.owo.dsl.nullBuilder
import io.wispforest.owo.ui.component.Components
import io.wispforest.owo.ui.component.EntityComponent
import io.wispforest.owo.ui.core.Sizing
import net.minecraft.entity.EntityType
import net.minecraft.nbt.NbtCompound

open class EntityComponentBuilder(
    var entityType: DslBuilder<EntityType<*>> = nullBuilder(),
    var nbtCompound: DslBuilder<NbtCompound> = nullBuilder(),
    var allowMouseRotation: Boolean? = null,
    var lookAtCursor: Boolean? = null,
    var scale: Float? = null,
    var scaleToFit: Boolean? = null,
    var showNametag: Boolean? = null
) : BaseComponentBuilder() {
    override fun buildComponent(): EntityComponent<*>? {
        return Components.entity(
            Sizing.content(),
            entityType.built ?: return null,
            nbtCompound.built ?: return null
        )!!
            .also(::applyTo)
    }

    protected fun applyTo(component: EntityComponent<*>) {
        super.applyTo(component)
        allowMouseRotation?.let(component::allowMouseRotation)
        lookAtCursor?.let(component::lookAtCursor)
        scale?.let(component::scale)
        scaleToFit?.let(component::scaleToFit)
        showNametag?.let(component::showNametag)
    }
}
