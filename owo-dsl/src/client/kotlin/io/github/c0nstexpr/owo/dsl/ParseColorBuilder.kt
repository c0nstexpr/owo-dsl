package io.github.c0nstexpr.owo.dsl

import io.wispforest.owo.ui.core.Color
import org.w3c.dom.Node

open class ParseColorBuilder : ColorBuilder() {
    var node = invalidBuilder<Node>()

    override fun build() = Color.parse(node.build())!!

    override val canBuild get() = node.canBuild
}

inline fun parseColor(crossinline block: ParseColorBuilder.() -> Unit) =
    ParseColorBuilder().apply(block)
