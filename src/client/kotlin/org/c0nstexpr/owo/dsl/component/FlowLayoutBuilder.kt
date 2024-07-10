package org.c0nstexpr.owo.dsl.component

import io.wispforest.owo.ui.container.Containers
import io.wispforest.owo.ui.container.FlowLayout
import io.wispforest.owo.ui.container.FlowLayout.Algorithm

abstract class FlowLayoutBuilder<T : FlowLayout> : BaseParentComponentBuilder<T>() {
    var algo: Algorithm? = null

    var children = mutableListOf<ComponentBuilder<*>>()

    var gap: Int? = null

    override fun applyTo(component: T) {
        super.applyTo(component)

        children.mapNotNull { it.build() }.forEach(component::child)
        gap?.let(component::gap)
    }
}

fun flowLayout(block: FlowLayoutBuilder<FlowLayout>.() -> Unit) =
    object : FlowLayoutBuilder<FlowLayout>() {
        override fun build(): FlowLayout? {
            if (algo == null) return null

            val horizontalSizing = horizontalSizingBuilder.build() ?: return null
            val verticalSizing = verticalSizingBuilder.build() ?: return null

            return when (algo) {
                Algorithm.HORIZONTAL ->
                    Containers.horizontalFlow(horizontalSizing, verticalSizing)

                Algorithm.VERTICAL ->
                    Containers.verticalFlow(horizontalSizing, verticalSizing)

                Algorithm.LTR_TEXT ->
                    Containers.ltrTextFlow(horizontalSizing, verticalSizing)

                else -> object : FlowLayout(horizontalSizing, verticalSizing, algo) {}
            }
        }
    }.apply(block)

inline fun <reified T : ComponentBuilder<*>> FlowLayoutBuilder<FlowLayout>.child(block: () -> T) =
    children.add(block())

inline fun <reified T : ComponentBuilder<*>> FlowLayoutBuilder<FlowLayout>.child(
    index: Int,
    block: () -> T
) = children.add(index, block())
