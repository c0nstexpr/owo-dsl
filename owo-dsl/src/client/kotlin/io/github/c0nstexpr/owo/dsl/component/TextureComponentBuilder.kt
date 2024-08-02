package io.github.c0nstexpr.owo.dsl.component

import io.github.c0nstexpr.owo.dsl.Id
import io.github.c0nstexpr.owo.dsl.PosRect
import io.github.c0nstexpr.owo.dsl.nullBuilder
import io.wispforest.owo.ui.component.Components
import io.wispforest.owo.ui.component.TextureComponent

open class TextureComponentBuilder : BaseComponentBuilder() {
    var texture = nullBuilder<Id>()

    var u: Int? = null

    var v: Int? = null

    var regionWidth: Int? = null

    var regionHeight: Int? = null

    var textureWidth = DEFAULT_TEXTURE_LENGTH

    var textureHeight = DEFAULT_TEXTURE_LENGTH

    var visibleArea = nullBuilder<PosRect>()

    var blend: Boolean? = null

    override fun provide(): TextureComponent? {
        return Components.texture(
            texture.value ?: return null,
            u ?: return null,
            v ?: return null,
            regionWidth ?: return null,
            regionHeight ?: return null,
            textureWidth,
            textureHeight
        ).also(::applyTo)
    }

    companion object {
        const val DEFAULT_TEXTURE_LENGTH = 256
    }

    protected fun applyTo(component: TextureComponent) {
        (this as BaseComponentBuilder).applyTo(component)
        visibleArea.value?.let(component::visibleArea)
        blend?.let(component::blend)
    }
}
