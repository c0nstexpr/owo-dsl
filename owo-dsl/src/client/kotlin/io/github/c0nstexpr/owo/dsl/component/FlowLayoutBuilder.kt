package io.github.c0nstexpr.owo.dsl.component

import io.github.c0nstexpr.owo.dsl.built
import io.github.c0nstexpr.owo.dsl.invalidBuilder
import io.wispforest.owo.ui.container.Containers
import io.wispforest.owo.ui.container.FlowLayout
import io.wispforest.owo.ui.container.FlowLayout.Algorithm
import io.wispforest.owo.ui.core.Component

open class FlowLayoutBuilder : BaseParentComponentBuilder() {
    var algo = invalidBuilder<Algorithm>()

    var children = invalidBuilder<List<Component>>()

    var gap = invalidBuilder<Int>()

    override fun build(): FlowLayout? {
        val horizontalSizing = horizontalSizing.built ?: return null
        val verticalSizing = verticalSizing.built ?: return null

        return when (val algorithm = algo.built ?: return null) {
            Algorithm.HORIZONTAL -> Containers.horizontalFlow(horizontalSizing, verticalSizing)
            Algorithm.VERTICAL -> Containers.verticalFlow(horizontalSizing, verticalSizing)
            Algorithm.LTR_TEXT -> Containers.ltrTextFlow(horizontalSizing, verticalSizing)
            else -> object : FlowLayout(horizontalSizing, verticalSizing, algorithm) {}
        }.apply(::applyTo)
    }
}

fun FlowLayoutBuilder.applyTo(component: FlowLayout) {
    (this as BaseParentComponentBuilder).applyTo(component)

    children.built?.forEach(component::child)
    gap.built?.let(component::gap)
}
