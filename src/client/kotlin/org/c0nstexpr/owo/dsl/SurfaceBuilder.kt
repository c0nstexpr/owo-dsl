package org.c0nstexpr.owo.dsl

import io.wispforest.owo.ui.core.Surface

interface SurfaceBuilder : DelegateBuilder<Surface>

fun invalidSurface() = object : SurfaceBuilder {
    override var value = invalidBuilder<Surface>()
}

fun surfaceOf(block: OwoBuilder<Surface>) = object : SurfaceBuilder {
    override var value = block
}

fun darkPanelSurface() = surfaceOf { Surface.DARK_PANEL }

fun panelInsetSurface() = surfaceOf { Surface.PANEL_INSET }

fun vanillaTranslucentSurface() = surfaceOf { Surface.VANILLA_TRANSLUCENT }

fun optionsBackgroundSurface() = surfaceOf { Surface.OPTIONS_BACKGROUND }

fun tooltipSurface() = surfaceOf { Surface.TOOLTIP }

fun SurfaceBuilder.and(other: SurfaceBuilder) = object : SurfaceBuilder {
    override var value: OwoBuilder<Surface> = object : OwoBuilder<Surface> {
        override fun build() = this@and.build().and(other.build())

        override val canBuild = this@and.canBuild && other.canBuild
    }
}
