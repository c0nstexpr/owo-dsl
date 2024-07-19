package io.github.c0nstexpr.owo.dsl

import io.wispforest.owo.ui.core.Surface

@FunctionalInterface
fun interface SurfaceBuilder : DslBuilder<Surface>

fun surface(block: DslBuilder<Surface> = invalidBuilder()) = object : SurfaceBuilder {
    override fun build() = block.build()

    override val canBuild get() = block.canBuild
}

fun darkPanelSurface() = surface { Surface.DARK_PANEL }

fun panelInsetSurface() = surface { Surface.PANEL_INSET }

fun vanillaTranslucentSurface() = surface { Surface.VANILLA_TRANSLUCENT }

fun optionsBackgroundSurface() = surface { Surface.OPTIONS_BACKGROUND }

fun blankSurface() = surface { Surface.BLANK }

fun tooltipSurface() = surface { Surface.TOOLTIP }

infix fun SurfaceBuilder.and(other: SurfaceBuilder) = surface(
    object : DslBuilder<Surface> {
        override fun build() = this@and.build().and(other.build())

        override val canBuild = this@and.canBuild && other.canBuild
    }
)
