package io.github.c0nstexpr.owo.dsl

import io.github.c0nstexpr.owo.dsl.SurfaceBuilder.Companion.Blur
import io.github.c0nstexpr.owo.dsl.SurfaceBuilder.Companion.Tiled
import io.wispforest.owo.ui.core.OwoUIDrawContext
import io.wispforest.owo.ui.core.Surface
import io.wispforest.owo.ui.util.NinePatchTexture
import net.minecraft.util.Identifier

interface SurfaceBuilder : DslBuilder<Surface> {
    companion object {
        class Blur(
            var quality: DslBuilder<Float> = invalidBuilder(),
            var size: DslBuilder<Float> = invalidBuilder()
        ) : SurfaceBuilder,
            DslBuilder<Surface> by dslBuilder({
                Surface.blur(
                    quality.built ?: return@dslBuilder null,
                    size.built ?: return@dslBuilder null
                )
            })

        class Tiled(
            var texture: DslBuilder<Identifier> = invalidBuilder(),
            var textureWidth: DslBuilder<Int> = invalidBuilder(),
            var textureHeight: DslBuilder<Int> = invalidBuilder()
        ) : SurfaceBuilder,
            DslBuilder<Surface> by dslBuilder({
                Surface.tiled(
                    texture.built ?: return@dslBuilder null,
                    textureWidth.built ?: return@dslBuilder null,
                    textureHeight.built ?: return@dslBuilder null
                )
            })

        infix fun DslBuilder<Surface>.and(other: DslBuilder<Surface>) =
            dslBuilder { built?.and(other.built ?: return@dslBuilder null) }
    }
}

fun surface() = invalidBuilder<Surface>()

fun surface(block: DslBuilder<Surface>): SurfaceBuilder =
    object : SurfaceBuilder, DslBuilder<Surface> by block {}

fun surface(block: () -> Surface?): SurfaceBuilder = surface(dslBuilder { block() })

fun darkPanelSurface() = surface { Surface.DARK_PANEL }

fun panelSurface() = surface { Surface.PANEL }

fun vanillaTranslucentSurface() = surface { Surface.VANILLA_TRANSLUCENT }

fun optionsBackgroundSurface() = surface { Surface.OPTIONS_BACKGROUND }

fun blankSurface() = surface { Surface.BLANK }

fun tooltipSurface() = surface { Surface.TOOLTIP }

fun panelInsetSurface(block: DslBuilder<Int>) = surface {
    block.built?.let {
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
}

fun blurSurface(block: Blur.() -> Unit) = Blur().apply(block)

fun flatSurface(block: DslBuilder<Int>) = surface {
    block.built?.let(Surface::flat)
}

fun outlineSurface(block: DslBuilder<Int>) = surface { block.built?.let(Surface::outline) }

fun tiledSurface(block: Tiled.() -> Unit) = Tiled().apply(block)
