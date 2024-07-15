package org.c0nstexpr.owo.dsl

import net.minecraft.client.MinecraftClient
import net.minecraft.util.Identifier

val MC_ATLAS_ID = Identifier.of("textures/atlas/gui.png")!!

open class SpriteFromIdBuilder : SpriteBuilder() {
    var id = spriteIdentifier()

    override fun build() = id.build().run {
        if (atlasId == MC_ATLAS_ID)
            MinecraftClient.getInstance().guiAtlasManager.getSprite(textureId)!!
        else sprite!!
    }

    override val canBuild get() = id.canBuild
}
