package org.c0nstexpr.owo.dsl.component

import io.wispforest.owo.ui.base.BaseComponent
import io.wispforest.owo.ui.core.CursorStyle
import org.c0nstexpr.owo.dsl.InsetsBuilder
import org.c0nstexpr.owo.dsl.PositioningBuilder
import org.c0nstexpr.owo.dsl.SizeBuilder
import org.c0nstexpr.owo.dsl.SizingBuilder
import org.c0nstexpr.owo.dsl.invalidBuilder

abstract class BaseComponentBuilder<T : BaseComponent> : ComponentBuilder<T> {
    override var positioningBuilder = PositioningBuilder()

    override var marginsBuilder = InsetsBuilder()

    override var horizontalSizingBuilder = SizingBuilder()

    override var verticalSizingBuilder = SizingBuilder()

    override var id = invalidBuilder<String>()

    override var tooltipBuilder = mutableListOf<TooltipBuilder<*>>()

    override var zIndex = invalidBuilder<Int>()

    override var cursor = invalidBuilder<CursorStyle>()

    override var x = invalidBuilder<Int>()

    override var y = invalidBuilder<Int>()

    override fun applyTo(component: T) {
        super.applyTo(component)
        if (spaceBuilder.canBuild) component.inflate(spaceBuilder.build())
    }

    var spaceBuilder = SizeBuilder()
}

inline val BaseComponentBuilder<*>.space get() = spaceBuilder

inline fun BaseComponentBuilder<*>.space(crossinline block: SizeBuilder.() -> Unit) =
    block(spaceBuilder)
