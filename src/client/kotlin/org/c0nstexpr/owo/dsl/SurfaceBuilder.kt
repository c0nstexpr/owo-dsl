package org.c0nstexpr.owo.dsl

import io.wispforest.owo.ui.core.Surface

fun interface SurfaceBuilder : OwoBuilder<Surface>

fun darkPanelSurface() = SurfaceBuilder { Surface.DARK_PANEL }

fun panelInsetSurface() = SurfaceBuilder { Surface.PANEL_INSET }

fun vanillaTranslucentSurface() = SurfaceBuilder { Surface.VANILLA_TRANSLUCENT }

fun optionsBackgroundSurface() = SurfaceBuilder { Surface.OPTIONS_BACKGROUND }

fun tooltipSurface() = SurfaceBuilder { Surface.TOOLTIP }

fun SurfaceBuilder.and(other: SurfaceBuilder) = SurfaceBuilder {
    build()?.and(other.build() ?: return@SurfaceBuilder null)
}
