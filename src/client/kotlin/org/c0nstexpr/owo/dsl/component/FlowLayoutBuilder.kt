package org.c0nstexpr.owo.dsl.component

import io.wispforest.owo.ui.container.Containers
import io.wispforest.owo.ui.container.FlowLayout
import io.wispforest.owo.ui.container.FlowLayout.Algorithm
import io.wispforest.owo.ui.core.Component
import org.c0nstexpr.owo.dsl.OwoBuilder
import org.c0nstexpr.owo.dsl.applyBuild
import org.c0nstexpr.owo.dsl.invalidBuilder

open class FlowLayoutBuilder : BaseParentComponentBuilder() {
    var algo = invalidBuilder<Algorithm>()

    var children = mutableListOf<OwoBuilder<Component>>()

    var gap = invalidBuilder<Int>()

    override val canBuild
        get() = horizontalSizing.canBuild &&
            verticalSizing.canBuild &&
            algo.canBuild &&
            children.all { it.canBuild }

    override fun build(): FlowLayout {
        val horizontalSizing = horizontalSizing.build()
        val verticalSizing = verticalSizing.build()

        return when (val algorithm = algo.build()) {
            Algorithm.HORIZONTAL -> Containers.horizontalFlow(horizontalSizing, verticalSizing)
            Algorithm.VERTICAL -> Containers.verticalFlow(horizontalSizing, verticalSizing)
            Algorithm.LTR_TEXT -> Containers.ltrTextFlow(horizontalSizing, verticalSizing)
            else -> object : FlowLayout(horizontalSizing, verticalSizing, algorithm) {}
        }.apply(::applyTo)
    }
}

fun FlowLayoutBuilder.applyTo(component: FlowLayout) {
    (this as BaseParentComponentBuilder).applyTo(component)

    children.map { it.build() }.forEach(component::child)
    gap.applyBuild(component::gap)
}

inline fun flowLayout(crossinline block: FlowLayoutBuilder.() -> Unit) =
    FlowLayoutBuilder().apply(block)

inline fun FlowLayoutBuilder.children(crossinline block: ChildrenScope.() -> Unit) =
    ChildrenScope(children).block()
