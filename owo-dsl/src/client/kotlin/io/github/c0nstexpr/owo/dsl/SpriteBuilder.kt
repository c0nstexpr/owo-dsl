package io.github.c0nstexpr.owo.dsl

import net.minecraft.client.texture.Sprite

abstract class SpriteBuilder : DslBuilder<Sprite> {
    companion object {
        val MC_ATLAS_ID = Id.of("textures/atlas/gui.png")!!

        fun DslBuilder<SpriteId>.toSprite(): SpriteBuilder = object :
            SpriteBuilder(),
            DslBuilder<Sprite> by dslBuilder({
                value?.run {
                    if (atlasId == MC_ATLAS_ID) atlasManager.getSprite(
                        textureId
                    )!!
                    else sprite!!
                }
            }) {}
    }
}
