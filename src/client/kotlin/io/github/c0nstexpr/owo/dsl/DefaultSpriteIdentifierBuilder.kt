package io.github.c0nstexpr.owo.dsl

import net.minecraft.client.util.SpriteIdentifier

open class DefaultSpriteIdentifierBuilder : SpriteIdentifierBuilder() {
    var atlas = identifier()

    var texture = identifier()

    override fun build() = SpriteIdentifier(atlas.build(), texture.build())

    override val canBuild get() = atlas.canBuild && texture.canBuild
}

inline fun defaultSpriteIdentifier(crossinline block: DefaultSpriteIdentifierBuilder.() -> Unit) =
    DefaultSpriteIdentifierBuilder().apply(block)
