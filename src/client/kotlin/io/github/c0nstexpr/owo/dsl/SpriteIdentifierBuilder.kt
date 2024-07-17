package io.github.c0nstexpr.owo.dsl

import net.minecraft.client.util.SpriteIdentifier

abstract class SpriteIdentifierBuilder : OwoBuilder<SpriteIdentifier>

fun spriteIdentifier(block: OwoBuilder<SpriteIdentifier> = invalidBuilder()) =
    object : SpriteIdentifierBuilder() {
        override fun build() = block.build()

        override val canBuild get() = block.canBuild
    }
