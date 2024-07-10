package org.c0nstexpr.owo.dsl.component

import io.wispforest.owo.ui.base.BaseComponent
import io.wispforest.owo.ui.core.CursorStyle
import org.c0nstexpr.owo.dsl.InsetsBuilder
import org.c0nstexpr.owo.dsl.PositioningBuilder
import org.c0nstexpr.owo.dsl.SizeBuilder
import org.c0nstexpr.owo.dsl.SizingBuilder

abstract class BaseComponentBuilder<T : BaseComponent> : ComponentBuilder<T> {
    override var positioningBuilder = PositioningBuilder()

    override var marginsBuilder = InsetsBuilder()

    override var horizontalSizingBuilder = SizingBuilder()

    override var verticalSizingBuilder = SizingBuilder()

    override var id: String? = null

    override var tooltipBuilder = mutableListOf<TooltipBuilder<*>>()

    override var zIndex: Int? = null

    override var cursor: CursorStyle? = null

    override var x: Int? = null

    override var y: Int? = null

    override fun applyTo(component: T) {
        super.applyTo(component)
        spaceBuilder.build()?.let { component.inflate(it) }
    }

    var spaceBuilder = SizeBuilder()
}

inline val BaseComponentBuilder<*>.space get() = spaceBuilder

inline fun BaseComponentBuilder<*>.space(crossinline block: SizeBuilder.() -> Unit) =
    block(spaceBuilder)
