package io.github.c0nstexpr.owo.dsl

import io.github.c0nstexpr.owo.dsl.DslBuilder.Companion.built
import net.minecraft.client.util.SpriteIdentifier
import net.minecraft.util.Identifier

typealias SpriteId = SpriteIdentifier

abstract class SpriteIdBuilder : DslBuilder<SpriteId> {
    companion object {
        class Of(
            var atlas: DslBuilder<Identifier> = nullBuilder(),
            var texture: DslBuilder<Identifier> = nullBuilder()
        ) : SpriteIdBuilder(),
            DslBuilder<SpriteId> by dslBuilder({
                SpriteId(
                    atlas.built ?: return@dslBuilder null,
                    texture.built ?: return@dslBuilder null
                )
            })
    }
}
