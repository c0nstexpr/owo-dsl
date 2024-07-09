package org.c0nstexpr.owo.dsl

import io.wispforest.owo.ui.container.FlowLayout
import io.wispforest.owo.ui.container.FlowLayout.Algorithm
import io.wispforest.owo.ui.core.Component

open class FlowLayoutBuilder : BaseParentComponentBuilder<FlowLayout> {
    var algo: Algorithm = Algorithm.VERTICAL

    override fun build() =
        object : FlowLayout(horizontalSizing.build(), verticalSizing.build(), algo) {}.apply {
        }
}

fun flowLayout(block: FlowLayoutBuilder.() -> Unit) = FlowLayoutBuilder().apply(block)

fun <T : Component, Flow : FlowLayout> Flow.component(getter: () -> T, setter: T.(Flow) -> Unit) {
    val t = getter()
    t.setter(this)
    child(t)
}
