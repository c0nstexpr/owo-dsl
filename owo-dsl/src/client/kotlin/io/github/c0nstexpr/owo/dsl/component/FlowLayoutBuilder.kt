package io.github.c0nstexpr.owo.dsl.component

import io.github.c0nstexpr.owo.dsl.applyBuilt
import io.github.c0nstexpr.owo.dsl.canBuild
import io.github.c0nstexpr.owo.dsl.invalidBuilder
import io.wispforest.owo.ui.container.Containers
import io.wispforest.owo.ui.container.FlowLayout
import io.wispforest.owo.ui.container.FlowLayout.Algorithm
import io.wispforest.owo.ui.core.Component

open class FlowLayoutBuilder : BaseParentComponentBuilder() {
    var algo = invalidBuilder<Algorithm>()

    var children = invalidBuilder<List<Component>>()

    var gap = invalidBuilder<Int>()

    override val canBuild
        get() = horizontalSizing.canBuild &&
            verticalSizing.canBuild &&
            algo.canBuild

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

    children.applyBuilt { it.forEach(component::child) }
    gap.applyBuilt(component::gap)
}
