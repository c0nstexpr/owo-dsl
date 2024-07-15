package org.c0nstexpr.owo.dsl.component

import io.wispforest.owo.ui.component.Components
import io.wispforest.owo.ui.component.SpriteComponent
import org.c0nstexpr.owo.dsl.applyBuild
import org.c0nstexpr.owo.dsl.invalidBuilder
import org.c0nstexpr.owo.dsl.sprite

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

inline fun spriteComponent(crossinline block: SpriteComponentBuilder.() -> Unit) =
    SpriteComponentBuilder().apply(block)
