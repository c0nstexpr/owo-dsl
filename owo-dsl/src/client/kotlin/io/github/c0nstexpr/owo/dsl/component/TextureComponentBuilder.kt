package io.github.c0nstexpr.owo.dsl.component

import io.github.c0nstexpr.owo.dsl.DslBuilder.Companion.built
import io.github.c0nstexpr.owo.dsl.PosRect
import io.github.c0nstexpr.owo.dsl.nullBuilder
import io.wispforest.owo.ui.component.Components
import io.wispforest.owo.ui.component.TextureComponent
import net.minecraft.util.Identifier

open class TextureComponentBuilder : BaseComponentBuilder() {
    var texture = nullBuilder<Identifier>()

    var u = nullBuilder<Int>()

    var v = nullBuilder<Int>()

    var regionWidth = nullBuilder<Int>()

    var regionHeight = nullBuilder<Int>()

    var textureWidth = nullBuilder<Int>()

    var textureHeight = nullBuilder<Int>()

    var visibleArea = nullBuilder<PosRect>()

    var blend = nullBuilder<Boolean>()

    override fun build(): TextureComponent? {
        return Components.texture(
            texture.built ?: return null,
            u.built ?: return null,
            v.built ?: return null,
            regionWidth.built ?: return null,
            regionHeight.built ?: return null,
            textureWidth.built ?: DEFAULT_TEXTURE_LENGTH,
            textureHeight.built ?: DEFAULT_TEXTURE_LENGTH
        ).also(::applyTo)
    }

    companion object {
        const val DEFAULT_TEXTURE_LENGTH = 256
    }
}

fun TextureComponentBuilder.applyTo(component: TextureComponent) {
    (this as BaseComponentBuilder).applyTo(component)

    visibleArea.built?.let(component::visibleArea)
    blend.built?.let(component::blend)
}
