package org.c0nstexpr.owo.dsl.component

import io.wispforest.owo.ui.container.Containers
import io.wispforest.owo.ui.container.StackLayout
import io.wispforest.owo.ui.core.Component
import org.c0nstexpr.owo.dsl.applyBuild
import org.c0nstexpr.owo.dsl.invalidBuilder

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

    children.applyBuild { it.forEach(component::child) }
}

inline fun stackLayout(crossinline block: StackLayoutBuilder.() -> Unit) =
    StackLayoutBuilder().apply(block)
