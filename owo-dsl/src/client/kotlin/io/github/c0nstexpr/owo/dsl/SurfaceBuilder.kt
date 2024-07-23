package io.github.c0nstexpr.owo.dsl

import io.wispforest.owo.ui.core.Surface

interface SurfaceBuilder : DslBuilder<Surface> {
    open class Entrance :
        SurfaceBuilder,
        DslBuilder<Surface> by invalidBuilder() {
        fun by(block: DslBuilder<Surface>): SurfaceBuilder =
            object : SurfaceBuilder, DslBuilder<Surface> by block {}

        fun by(block: () -> Surface?): SurfaceBuilder = by(dslBuilder { block() })

        fun darkPanel() = by { Surface.DARK_PANEL }

        fun panelInset() = by { Surface.PANEL_INSET }

        fun vanillaTranslucent() = by { Surface.VANILLA_TRANSLUCENT }

        fun optionsBackground() = by { Surface.OPTIONS_BACKGROUND }

        fun blank() = by { Surface.BLANK }

        fun tooltip() = by { Surface.TOOLTIP }

        fun blurSurface(quality: DslBuilder<Float>, size: DslBuilder<Float>) = surface {
            quality.applyBuilt { q -> size.applyBuilt { Surface.blur(q, it) } }
        }
    }
}

fun <R> surface(block: SurfaceBuilder.Entrance.() -> R) = SurfaceBuilder.Entrance().block()

infix fun SurfaceBuilder.and(other: SurfaceBuilder) =
    surface { applyBuilt { other.applyBuilt(it::and) } }
