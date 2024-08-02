package io.github.c0nstexpr.owo.dsl.component

import io.github.c0nstexpr.owo.dsl.DslBuilder
import io.github.c0nstexpr.owo.dsl.nullBuilder
import io.wispforest.owo.ui.container.Containers
import io.wispforest.owo.ui.container.FlowLayout
import io.wispforest.owo.ui.container.FlowLayout.Algorithm

open class FlowLayoutBuilder(
    var algo: DslBuilder<Algorithm> = nullBuilder<Algorithm>(),
    var gap: Int? = null
) : BaseParentComponentBuilder(),
    ListChildrenBuilder by listChildrenBuilder() {
    override fun provide(): FlowLayout? {
        val horizontalSizing = horizontalSizing.value ?: return null
        val verticalSizing = verticalSizing.value ?: return null

        return when (val algorithm = algo.value ?: return null) {
            Algorithm.HORIZONTAL -> Containers.horizontalFlow(horizontalSizing, verticalSizing)
            Algorithm.VERTICAL -> Containers.verticalFlow(horizontalSizing, verticalSizing)
            Algorithm.LTR_TEXT -> Containers.ltrTextFlow(horizontalSizing, verticalSizing)
            else -> object : FlowLayout(horizontalSizing, verticalSizing, algorithm) {}
        }.also(::applyTo)
    }

    protected fun applyTo(component: FlowLayout) {
        super.applyTo(component)

        run {
            children.map { it.value ?: return@run null }.toList().forEach(component::child)
        }

        gap?.let(component::gap)
    }
}
