package io.github.c0nstexpr.owo.dsl.component

import io.github.c0nstexpr.owo.dsl.DslBuilder
import io.github.c0nstexpr.owo.dsl.DslBuilder.Companion.built
import io.github.c0nstexpr.owo.dsl.nullBuilder
import io.wispforest.owo.ui.container.Containers
import io.wispforest.owo.ui.container.FlowLayout
import io.wispforest.owo.ui.container.FlowLayout.Algorithm

open class FlowLayoutProvider(
    var algo: DslBuilder<Algorithm> = nullBuilder<Algorithm>(),
    var gap: Int? = null
) : BaseParentComponentProvider(),
    ListChildrenProvider by listChildrenProvider() {
    override fun provide(): FlowLayout? {
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

        run {
            children.map { it.built ?: return@run null }.toList().forEach(component::child)
        }

        gap?.let(component::gap)
    }
}
