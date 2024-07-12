package org.c0nstexpr.owo.dsl.component

import io.wispforest.owo.ui.container.Containers
import io.wispforest.owo.ui.container.FlowLayout
import io.wispforest.owo.ui.container.FlowLayout.Algorithm
import org.c0nstexpr.owo.dsl.invalidBuilder

abstract class FlowLayoutBuilder<T : FlowLayout> : BaseParentComponentBuilder<T>() {
    var algo = invalidBuilder<Algorithm>()

    var children = mutableListOf<ComponentBuilder<*>>()

    var gap = invalidBuilder<Int>()

    override val canBuild
        get() = horizontalSizingBuilder.canBuild &&
            verticalSizingBuilder.canBuild &&
            algo.canBuild

    override fun applyTo(component: T) {
        super.applyTo(component)

        children.map { it.build() }.forEach(component::child)

        if (gap.canBuild) component.gap(gap.build())
    }
}

fun flowLayout(block: FlowLayoutBuilder<FlowLayout>.() -> Unit) =
    object : FlowLayoutBuilder<FlowLayout>() {
        override fun build() = run {
            val horizontalSizing = horizontalSizingBuilder.build()
            val verticalSizing = verticalSizingBuilder.build()

            when (val algorithm = algo.build()) {
                Algorithm.HORIZONTAL -> Containers.horizontalFlow(horizontalSizing, verticalSizing)

                Algorithm.VERTICAL -> Containers.verticalFlow(horizontalSizing, verticalSizing)

                Algorithm.LTR_TEXT -> Containers.ltrTextFlow(horizontalSizing, verticalSizing)

                else -> object : FlowLayout(horizontalSizing, verticalSizing, algorithm) {}
            }
        }
    }.apply(block)

fun FlowLayoutBuilder<FlowLayout>.child(block: ComponentBuilder<*>) = children.add(block)

fun FlowLayoutBuilder<FlowLayout>.child(index: Int, block: ComponentBuilder<*>) =
    children.add(index, block)
