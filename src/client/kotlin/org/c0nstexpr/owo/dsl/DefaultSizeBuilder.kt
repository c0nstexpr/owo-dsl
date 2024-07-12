package org.c0nstexpr.owo.dsl

import io.wispforest.owo.ui.core.Size

open class DefaultSizeBuilder : SizeBuilder() {
    var width = invalidBuilder<Int>()

    var height = invalidBuilder<Int>()

    override fun build(): Size = Size.of(width.build(), height.build())

    override val canBuild get() = width.canBuild && height.canBuild
}

inline fun defaultSize(crossinline block: DefaultSizeBuilder.() -> Unit) =
    DefaultSizeBuilder().apply(block)
