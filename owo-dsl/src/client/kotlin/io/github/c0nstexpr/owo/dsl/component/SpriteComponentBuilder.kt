package io.github.c0nstexpr.owo.dsl.component

import io.github.c0nstexpr.owo.dsl.DslBuilder.Companion.built
import io.github.c0nstexpr.owo.dsl.nullBuilder
import io.wispforest.owo.ui.component.Components
import io.wispforest.owo.ui.component.SpriteComponent
import net.minecraft.client.texture.Sprite

open class SpriteComponentBuilder : BaseComponentBuilder() {
    var sprite = nullBuilder<Sprite>()

    var blend = nullBuilder<Boolean>()

    override fun build() = sprite.built?.let(Components::sprite)?.also(::applyTo)

    protected fun applyTo(component: SpriteComponent) {
        super.applyTo(component)
        blend.built?.let(component::blend)
    }
}
