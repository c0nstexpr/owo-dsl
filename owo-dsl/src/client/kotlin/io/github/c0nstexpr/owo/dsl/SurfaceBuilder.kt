package io.github.c0nstexpr.owo.dsl

import io.github.c0nstexpr.owo.dsl.DslBuilder.Companion.built
import io.wispforest.owo.ui.core.OwoUIDrawContext
import io.wispforest.owo.ui.core.Surface
import io.wispforest.owo.ui.util.NinePatchTexture
import net.minecraft.util.Identifier

interface SurfaceBuilder : DslBuilder<Surface> {
    companion object {
        infix fun DslBuilder<Surface>.and(other: DslBuilder<Surface>) =
            dslBuilder { built?.and(other.built ?: return@dslBuilder null) }
    }

    class Tiled(
        var texture: DslBuilder<Identifier> = nullBuilder(),
        var textureWidth: DslBuilder<Int> = nullBuilder(),
        var textureHeight: DslBuilder<Int> = nullBuilder()
    ) : SurfaceBuilder,
        DslBuilder<Surface> by dslBuilder({
            Surface.tiled(
                texture.built ?: return@dslBuilder null,
                textureWidth.built ?: return@dslBuilder null,
                textureHeight.built ?: return@dslBuilder null
            )
        })

    class Outline(var color: DslBuilder<Int> = nullBuilder()) :
        SurfaceBuilder,
        DslBuilder<Surface> by dslBuilder({
            Surface.outline(color.built ?: return@dslBuilder null)
        })

    class Flat(var color: DslBuilder<Int> = nullBuilder()) :
        SurfaceBuilder,
        DslBuilder<Surface> by dslBuilder({
            Surface.flat(color.built ?: return@dslBuilder null)
        })

    class Blur(
        var quality: DslBuilder<Float> = nullBuilder(),
        var size: DslBuilder<Float> = nullBuilder()
    ) : SurfaceBuilder,
        DslBuilder<Surface> by dslBuilder({
            Surface.blur(
                quality.built ?: return@dslBuilder null,
                size.built ?: return@dslBuilder null
            )
        })

    class PanelInset(var inset: DslBuilder<Int> = nullBuilder()) :
        SurfaceBuilder,
        DslBuilder<Surface> by dslBuilder({
            inset.built?.let {
                val it2 = it * 2

                Surface { context, component ->
                    NinePatchTexture.draw(
                        OwoUIDrawContext.PANEL_INSET_NINE_PATCH_TEXTURE,
                        context,
                        component.x() + it,
                        component.y() + it,
                        component.width() - it2,
                        component.height() - it2
                    )
                }
            }
        })
}
