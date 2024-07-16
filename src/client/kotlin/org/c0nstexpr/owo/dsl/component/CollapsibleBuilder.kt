package org.c0nstexpr.owo.dsl.component

import io.wispforest.owo.ui.container.Containers
import org.c0nstexpr.owo.dsl.invalidBuilder
import org.c0nstexpr.owo.dsl.text

open class CollapsibleBuilder : FlowLayoutBuilder() {
    var title = text()

    var expended = invalidBuilder<Boolean>()

    override fun build() = Containers.collapsible(
        horizontalSizing.build(),
        verticalSizing.build(),
        title.build(),
        expended.build()
    )!!.apply(::applyTo)

    override val canBuild
        get() = horizontalSizing.canBuild &&
            verticalSizing.canBuild &&
            title.canBuild &&
            expended.canBuild
}

inline fun collapsible(crossinline block: CollapsibleBuilder.() -> Unit) =
    CollapsibleBuilder().apply(block)
