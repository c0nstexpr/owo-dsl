package io.github.c0nstexpr.owo.dsl

import net.minecraft.client.MinecraftClient
import net.minecraft.util.Identifier

val MC_ATLAS_ID = Identifier.of("textures/atlas/gui.png")!!

open class Id2SpriteBuilder : SpriteBuilder() {
    var id = spriteIdentifier()

    override fun build() = id.build().run {
        if (atlasId == MC_ATLAS_ID)
            MinecraftClient.getInstance().guiAtlasManager.getSprite(textureId)!!
        else sprite!!
    }

    override val canBuild get() = id.canBuild
}

inline fun id2Sprite(crossinline block: Id2SpriteBuilder.() -> Unit) =
    Id2SpriteBuilder().apply(block)
