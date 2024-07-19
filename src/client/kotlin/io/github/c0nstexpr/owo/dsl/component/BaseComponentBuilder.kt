package io.github.c0nstexpr.owo.dsl.component

import io.github.c0nstexpr.owo.dsl.SizeBuilder
import io.github.c0nstexpr.owo.dsl.animation
import io.github.c0nstexpr.owo.dsl.applyBuild
import io.github.c0nstexpr.owo.dsl.insets
import io.github.c0nstexpr.owo.dsl.invalidBuilder
import io.github.c0nstexpr.owo.dsl.positioning
import io.github.c0nstexpr.owo.dsl.size
import io.github.c0nstexpr.owo.dsl.sizing
import io.wispforest.owo.ui.base.BaseComponent
import io.wispforest.owo.ui.core.CursorStyle
import io.wispforest.owo.ui.core.Insets
import io.wispforest.owo.ui.core.Positioning
import io.wispforest.owo.ui.core.Sizing
import net.minecraft.client.gui.tooltip.TooltipComponent

abstract class BaseComponentBuilder : ComponentBuilder {
    override var positioning = positioning()

    override var margins = insets()

    override var horizontalSizing = sizing()

    override var verticalSizing = sizing()

    override var positioningAnimation = animation<Positioning>()

    override var marginsAnimation = animation<Insets>()

    override var horizontalSizingAnimation = animation<Sizing>()

    override var verticalSizingAnimation = animation<Sizing>()

    override var id = invalidBuilder<String>()

    override var tooltip = invalidBuilder<List<TooltipComponent>>()

    override var zIndex = invalidBuilder<Int>()

    override var cursor = invalidBuilder<CursorStyle>()

    override var x = invalidBuilder<Int>()

    override var y = invalidBuilder<Int>()

    var space = size()

    abstract override fun build(): BaseComponent
}

fun BaseComponentBuilder.applyTo(component: BaseComponent) {
    (this as ComponentBuilder).applyTo(component)

    space.applyBuild(component::inflate)
}

inline fun BaseComponentBuilder.space(crossinline block: SizeBuilder.() -> Unit) = block(space)
