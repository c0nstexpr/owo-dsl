package io.github.c0nstexpr.owo.dsl.component

import io.github.c0nstexpr.owo.dsl.SizeBuilder
import io.github.c0nstexpr.owo.dsl.applyBuild
import io.github.c0nstexpr.owo.dsl.insets
import io.github.c0nstexpr.owo.dsl.invalidBuilder
import io.github.c0nstexpr.owo.dsl.positioning
import io.github.c0nstexpr.owo.dsl.size
import io.github.c0nstexpr.owo.dsl.sizing
import io.wispforest.owo.ui.base.BaseComponent
import io.wispforest.owo.ui.core.CursorStyle

abstract class BaseComponentBuilder : ComponentBuilder {
    override var positioning = positioning()

    override var margins = insets()

    override var horizontalSizing = sizing()

    override var verticalSizing = sizing()

    override var id = invalidBuilder<String>()

    override var tooltip = mutableListOf<TooltipBuilder>()

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
