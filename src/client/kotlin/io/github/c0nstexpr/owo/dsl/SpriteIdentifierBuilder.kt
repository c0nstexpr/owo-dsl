package io.github.c0nstexpr.owo.dsl

import net.minecraft.client.util.SpriteIdentifier

abstract class SpriteIdentifierBuilder : DslBuilder<SpriteIdentifier>

fun spriteIdentifier(block: DslBuilder<SpriteIdentifier> = invalidBuilder()) =
    object : SpriteIdentifierBuilder() {
        override fun build() = block.build()

        override val canBuild get() = block.canBuild
    }
