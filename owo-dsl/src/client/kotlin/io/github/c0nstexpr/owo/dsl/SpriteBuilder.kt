package io.github.c0nstexpr.owo.dsl

import net.minecraft.client.texture.Sprite

abstract class SpriteBuilder : DslBuilder<Sprite>

fun sprite(block: DslBuilder<Sprite> = invalidBuilder()) = object : SpriteBuilder() {
    override fun build() = block.build()

    override val canBuild get() = block.canBuild
}

inline fun sprite(crossinline block: () -> Sprite) = sprite(dslBuilder { block() })
