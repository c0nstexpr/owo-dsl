package io.github.c0nstexpr.owo.dsl

import io.github.c0nstexpr.owo.dsl.DslBuilder.Companion.built
import net.minecraft.client.util.SpriteIdentifier

typealias SpriteId = SpriteIdentifier

abstract class SpriteIdBuilder(
    var atlas: DslBuilder<Id> = nullBuilder(),
    var texture: DslBuilder<Id> = nullBuilder()
) : DslBuilder<SpriteId> by dslBuilder({
        SpriteId(atlas.built ?: return@dslBuilder null, texture.built ?: return@dslBuilder null)
})
