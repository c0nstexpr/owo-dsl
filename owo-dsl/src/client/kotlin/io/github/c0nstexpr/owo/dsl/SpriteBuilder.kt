package io.github.c0nstexpr.owo.dsl

import io.github.c0nstexpr.owo.dsl.SpriteBuilder.Companion.MC_ATLAS_ID
import net.minecraft.client.MinecraftClient
import net.minecraft.client.texture.Sprite
import net.minecraft.client.util.SpriteIdentifier
import net.minecraft.util.Identifier

abstract class SpriteBuilder : DslBuilder<Sprite> {
    companion object {
        val MC_ATLAS_ID = Identifier.of("textures/atlas/gui.png")!!
    }
}

fun sprite() = invalidBuilder<Sprite>()

fun sprite(block: DslBuilder<Sprite>): SpriteBuilder =
    object : SpriteBuilder(), DslBuilder<Sprite> by block {}

fun sprite(block: () -> Sprite?) = sprite(dslBuilder { block() })

fun DslBuilder<SpriteIdentifier>.toSprite() = sprite {
    built?.run {
        if (atlasId == MC_ATLAS_ID) MinecraftClient.getInstance().guiAtlasManager.getSprite(
            textureId
        )!!
        else sprite!!
    }
}
