package io.github.c0nstexpr.owo.dsl

import io.github.c0nstexpr.owo.dsl.SpriteIdBuilder.Companion.Ctor
import net.minecraft.client.util.SpriteIdentifier
import net.minecraft.util.Identifier

typealias SpriteId = SpriteIdentifier

abstract class SpriteIdBuilder : DslBuilder<SpriteId> {
    companion object {
        class Ctor(
            var atlas: DslBuilder<Identifier> = invalidBuilder(),
            var texture: DslBuilder<Identifier> = invalidBuilder()
        ) : SpriteIdBuilder(),
            DslBuilder<SpriteId> by dslBuilder({
                SpriteId(
                    atlas.built ?: return@dslBuilder null,
                    texture.built ?: return@dslBuilder null
                )
            })
    }
}

fun spriteId() = invalidBuilder<SpriteId>()

fun spriteId(block: DslBuilder<SpriteId>): SpriteIdBuilder =
    object : SpriteIdBuilder(), DslBuilder<SpriteId> by block {}

fun spriteId(block: () -> SpriteId) = spriteId(dslBuilder { block() })

inline fun spriteIdCtor(crossinline block: Ctor.() -> Unit) = Ctor().apply(block)
