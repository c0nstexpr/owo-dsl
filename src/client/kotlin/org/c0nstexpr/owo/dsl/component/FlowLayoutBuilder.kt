package org.c0nstexpr.owo.dsl.component

import io.wispforest.owo.ui.container.Containers
import io.wispforest.owo.ui.container.FlowLayout
import io.wispforest.owo.ui.container.FlowLayout.Algorithm

abstract class FlowLayoutBuilder<T : FlowLayout> : BaseParentComponentBuilder<T>() {
    var algo: Algorithm? = null

    var children = mutableListOf<ComponentBuilder<*>>()

    var gap: Int? = null

    override val canBuild
        get() = horizontalSizingBuilder.canBuild &&
            verticalSizingBuilder.canBuild &&
            algo != null

    override fun applyTo(component: T) {
        super.applyTo(component)
        children.map { it.build() }.forEach(component::child)
        gap?.let(component::gap)
    }
}

fun flowLayout(block: FlowLayoutBuilder<FlowLayout>.() -> Unit) =
    object : FlowLayoutBuilder<FlowLayout>() {
        override fun build() = run {
            val horizontalSizing = horizontalSizingBuilder.build()
            val verticalSizing = verticalSizingBuilder.build()

            when (algo) {
                Algorithm.HORIZONTAL -> Containers.horizontalFlow(horizontalSizing, verticalSizing)

                Algorithm.VERTICAL -> Containers.verticalFlow(horizontalSizing, verticalSizing)

                Algorithm.LTR_TEXT -> Containers.ltrTextFlow(horizontalSizing, verticalSizing)

                else -> object : FlowLayout(horizontalSizing, verticalSizing, algo) {}
            }
        }
    }.apply(block)

inline fun FlowLayoutBuilder<FlowLayout>.child(crossinline block: () -> ComponentBuilder<*>) =
    children.add(block())

inline fun FlowLayoutBuilder<FlowLayout>.child(
    index: Int,
    crossinline block: () -> ComponentBuilder<*>
) = children.add(index, block())
