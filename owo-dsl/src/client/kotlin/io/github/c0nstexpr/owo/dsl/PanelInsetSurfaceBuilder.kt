package io.github.c0nstexpr.owo.dsl

import io.wispforest.owo.ui.core.OwoUIDrawContext
import io.wispforest.owo.ui.core.Surface
import io.wispforest.owo.ui.util.NinePatchTexture

open class PanelInsetSurfaceBuilder(var inset: Int = 0) :
    DslBuilder<Surface> by
    dslBuilder({
        val inset2 = inset * 2

        Surface { context, component ->
            NinePatchTexture.draw(
                OwoUIDrawContext.PANEL_INSET_NINE_PATCH_TEXTURE,
                context,
                component.x() + inset,
                component.y() + inset,
                component.width() - inset2,
                component.height() - inset2
            )
        }
    })
