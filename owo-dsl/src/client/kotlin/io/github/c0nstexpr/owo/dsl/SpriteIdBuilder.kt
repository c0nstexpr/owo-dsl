package io.github.c0nstexpr.owo.dsl

import net.minecraft.client.util.SpriteIdentifier

abstract class SpriteIdBuilder : DslBuilder<SpriteIdentifier>

fun spriteIdentifier(block: DslBuilder<SpriteIdentifier> = invalidBuilder()) =
    object : SpriteIdBuilder() {
        override fun build() = block.build()

        override val canBuild get() = block.canBuild
    }

inline fun spriteIdentifier(crossinline block: () -> SpriteIdentifier) =
    spriteIdentifier(dslBuilder { block() })
