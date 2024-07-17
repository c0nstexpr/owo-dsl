package io.github.c0nstexpr.owo.dsl

import io.wispforest.owo.ui.core.Color
import org.w3c.dom.Node

open class ColorParseBuilder : ColorBuilder() {
    var node = invalidBuilder<Node>()

    override fun build() = Color.parse(node.build())!!

    override val canBuild get() = node.canBuild
}

inline fun colorParse(crossinline block: ColorParseBuilder.() -> Unit) =
    ColorParseBuilder().apply(block)
