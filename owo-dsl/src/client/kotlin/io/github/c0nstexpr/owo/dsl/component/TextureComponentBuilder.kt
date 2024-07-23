package io.github.c0nstexpr.owo.dsl.component

import io.github.c0nstexpr.owo.dsl.applyBuilt
import io.github.c0nstexpr.owo.dsl.canBuild
import io.github.c0nstexpr.owo.dsl.identifier
import io.github.c0nstexpr.owo.dsl.invalidBuilder
import io.github.c0nstexpr.owo.dsl.posRect
import io.wispforest.owo.ui.component.Components
import io.wispforest.owo.ui.component.TextureComponent

open class TextureComponentBuilder : BaseComponentBuilder() {
    var texture = identifier()

    var u = invalidBuilder<Int>()

    var v = invalidBuilder<Int>()

    var regionWidth = invalidBuilder<Int>()

    var regionHeight = invalidBuilder<Int>()

    var textureWidth = invalidBuilder<Int>()

    var textureHeight = invalidBuilder<Int>()

    var visibleArea = posRect()

    var blend = invalidBuilder<Boolean>()

    override fun build() = Components.texture(
        texture.build(),
        u.build(),
        v.build(),
        regionWidth.build(),
        regionHeight.build(),
        if (textureWidth.canBuild) textureWidth.build() else DEFAULT_TEXTURE_LENGTH,
        if (textureHeight.canBuild) textureHeight.build() else DEFAULT_TEXTURE_LENGTH
    )!!.apply(::applyTo)

    override val canBuild
        get() = texture.canBuild &&
            u.canBuild &&
            v.canBuild &&
            regionWidth.canBuild &&
            regionHeight.canBuild

    companion object {
        const val DEFAULT_TEXTURE_LENGTH = 256
    }
}

fun TextureComponentBuilder.applyTo(component: TextureComponent) {
    (this as BaseComponentBuilder).applyTo(component)

    visibleArea.applyBuilt(component::visibleArea)
    blend.applyBuilt(component::blend)
}
