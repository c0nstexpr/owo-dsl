package io.github.c0nstexpr.owo.dsl.component

import io.github.c0nstexpr.owo.dsl.applyBuilt
import io.github.c0nstexpr.owo.dsl.canBuild
import io.github.c0nstexpr.owo.dsl.invalidBuilder
import io.wispforest.owo.ui.container.Containers
import io.wispforest.owo.ui.container.StackLayout
import io.wispforest.owo.ui.core.Component

open class StackLayoutBuilder : BaseParentComponentBuilder() {
    var children = invalidBuilder<List<Component>>()

    override fun build() = Containers.stack(
        horizontalSizing.build(),
        verticalSizing.build()
    )!!.apply(::applyTo)

    override val canBuild get() = horizontalSizing.canBuild && verticalSizing.canBuild
}

fun StackLayoutBuilder.applyTo(component: StackLayout) {
    (this as BaseParentComponentBuilder).applyTo(component)

    children.applyBuilt { it.forEach(component::child) }
}
