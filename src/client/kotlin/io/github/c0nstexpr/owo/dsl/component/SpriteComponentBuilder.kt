package io.github.c0nstexpr.owo.dsl.component

import io.github.c0nstexpr.owo.dsl.applyBuild
import io.github.c0nstexpr.owo.dsl.invalidBuilder
import io.github.c0nstexpr.owo.dsl.sprite
import io.wispforest.owo.ui.component.Components
import io.wispforest.owo.ui.component.SpriteComponent

open class SpriteComponentBuilder : BaseComponentBuilder() {
    var sprite = sprite()

    var blend = invalidBuilder<Boolean>()

    override fun build() = Components.sprite(sprite.build())!!.apply(::applyTo)

    override val canBuild get() = sprite.canBuild
}

fun SpriteComponentBuilder.applyTo(component: SpriteComponent) {
    (this as BaseComponentBuilder).applyTo(component)

    blend.applyBuild(component::blend)
}
