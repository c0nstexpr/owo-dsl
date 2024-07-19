package io.github.c0nstexpr.owo.dsl.component

import io.github.c0nstexpr.owo.dsl.invalidBuilder
import io.github.c0nstexpr.owo.dsl.text
import io.wispforest.owo.ui.container.Containers

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
