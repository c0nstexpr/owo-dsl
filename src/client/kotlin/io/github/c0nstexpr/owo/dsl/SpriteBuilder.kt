package io.github.c0nstexpr.owo.dsl

import net.minecraft.client.texture.Sprite

abstract class SpriteBuilder : OwoBuilder<Sprite>

fun sprite(block: OwoBuilder<Sprite> = invalidBuilder()) = object : SpriteBuilder() {
    override fun build() = block.build()

    override val canBuild get() = block.canBuild
}
