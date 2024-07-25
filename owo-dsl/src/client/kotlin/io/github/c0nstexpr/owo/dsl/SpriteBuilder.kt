package io.github.c0nstexpr.owo.dsl

import io.github.c0nstexpr.owo.dsl.DslBuilder.Companion.built
import net.minecraft.client.texture.Sprite
import net.minecraft.util.Identifier

abstract class SpriteBuilder : DslBuilder<Sprite> {
    companion object {
        val MC_ATLAS_ID = Identifier.of("textures/atlas/gui.png")!!

        fun DslBuilder<SpriteId>.toSprite(): SpriteBuilder = object :
            SpriteBuilder(),
            DslBuilder<Sprite> by dslBuilder({
                built?.run {
                    if (atlasId == MC_ATLAS_ID) atlasManager.getSprite(
                        textureId
                    )!!
                    else sprite!!
                }
            }) {}
    }
}
