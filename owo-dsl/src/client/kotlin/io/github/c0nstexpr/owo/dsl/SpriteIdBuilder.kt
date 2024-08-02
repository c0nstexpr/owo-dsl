package io.github.c0nstexpr.owo.dsl

import net.minecraft.client.util.SpriteIdentifier

typealias SpriteId = SpriteIdentifier

open class SpriteIdBuilder(
    var atlas: DslBuilder<Id> = nullBuilder(),
    var texture: DslBuilder<Id> = nullBuilder()
) : DslBuilder<SpriteId> by dslBuilder({
        SpriteId(atlas.value ?: return@dslBuilder null, texture.value ?: return@dslBuilder null)
    })
