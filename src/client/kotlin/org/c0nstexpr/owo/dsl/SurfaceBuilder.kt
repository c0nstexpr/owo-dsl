package org.c0nstexpr.owo.dsl

import com.mojang.authlib.minecraft.InsecurePublicKeyException.InvalidException
import io.wispforest.owo.ui.core.Surface

interface SurfaceBuilder : OwoBuilder<Surface>

fun invalidSurface() = object : SurfaceBuilder {
    override fun build() = throw InvalidException("Invalid surface")

    override val canBuild = false
}

inline fun surfaceOf(crossinline block: () -> Surface) = object : SurfaceBuilder {
    override fun build() = block()

    override val canBuild = true
}

fun darkPanelSurface() = surfaceOf { Surface.DARK_PANEL }

fun panelInsetSurface() = surfaceOf { Surface.PANEL_INSET }

fun vanillaTranslucentSurface() = surfaceOf { Surface.VANILLA_TRANSLUCENT }

fun optionsBackgroundSurface() = surfaceOf { Surface.OPTIONS_BACKGROUND }

fun tooltipSurface() = surfaceOf { Surface.TOOLTIP }

fun SurfaceBuilder.and(other: SurfaceBuilder) = object : SurfaceBuilder {
    override fun build() = this@and.build().and(other.build())

    override val canBuild = this@and.canBuild && other.canBuild
}
