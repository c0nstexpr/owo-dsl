package io.github.c0nstexpr.owo.dsl.component

import io.github.c0nstexpr.owo.dsl.DslBuilder.Companion.built
import io.github.c0nstexpr.owo.dsl.nullBuilder
import io.wispforest.owo.ui.container.Containers
import io.wispforest.owo.ui.container.FlowLayout
import io.wispforest.owo.ui.container.FlowLayout.Algorithm

open class FlowLayoutBuilder :
    BaseParentComponentBuilder(),
    ListChildren by listChildren() {
    var algo = nullBuilder<Algorithm>()

    var gap = nullBuilder<Int>()

    override fun build(): FlowLayout? {
        val horizontalSizing = horizontalSizing.built ?: return null
        val verticalSizing = verticalSizing.built ?: return null

        return when (val algorithm = algo.built ?: return null) {
            Algorithm.HORIZONTAL -> Containers.horizontalFlow(horizontalSizing, verticalSizing)
            Algorithm.VERTICAL -> Containers.verticalFlow(horizontalSizing, verticalSizing)
            Algorithm.LTR_TEXT -> Containers.ltrTextFlow(horizontalSizing, verticalSizing)
            else -> object : FlowLayout(horizontalSizing, verticalSizing, algorithm) {}
        }.also(::applyTo)
    }

    protected fun applyTo(component: FlowLayout) {
        super.applyTo(component)
        children.built?.forEach(component::child)
        gap.built?.let(component::gap)
    }
}
