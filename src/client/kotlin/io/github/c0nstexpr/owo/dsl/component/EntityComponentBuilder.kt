package io.github.c0nstexpr.owo.dsl.component

import io.github.c0nstexpr.owo.dsl.applyBuild
import io.github.c0nstexpr.owo.dsl.entityType
import io.github.c0nstexpr.owo.dsl.invalidBuilder
import io.github.c0nstexpr.owo.dsl.nbtCompound
import io.wispforest.owo.ui.component.Components
import io.wispforest.owo.ui.component.EntityComponent
import io.wispforest.owo.ui.core.Sizing

open class EntityComponentBuilder : BaseComponentBuilder() {
    var entityType = entityType()

    var nbtCompound = nbtCompound()

    var allowMouseRotation = invalidBuilder<Boolean>()

    var lookAtCursor = invalidBuilder<Boolean>()

    var scale = invalidBuilder<Float>()

    var scaleToFit = invalidBuilder<Boolean>()

    var showNametag = invalidBuilder<Boolean>()

    override fun build() =
        Components.entity(Sizing.content(), entityType.build(), nbtCompound.build())!!
            .apply(::applyTo)

    override val canBuild get() = entityType.canBuild
}

fun EntityComponentBuilder.applyTo(component: EntityComponent<*>) {
    (this as BaseComponentBuilder).applyTo(component)

    allowMouseRotation.applyBuild(component::allowMouseRotation)
    lookAtCursor.applyBuild(component::lookAtCursor)
    scale.applyBuild(component::scale)
    scaleToFit.applyBuild(component::scaleToFit)
    showNametag.applyBuild(component::showNametag)
}

inline fun entityComponent(crossinline block: EntityComponentBuilder.() -> Unit) =
    EntityComponentBuilder().apply(block)
