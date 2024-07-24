package io.github.c0nstexpr.owo.dsl.component

import io.github.c0nstexpr.owo.dsl.built
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

    allowMouseRotation.built?.let(component::allowMouseRotation)
    lookAtCursor.built?.let(component::lookAtCursor)
    scale.built?.let(component::scale)
    scaleToFit.built?.let(component::scaleToFit)
    showNametag.built?.let(component::showNametag)
}
