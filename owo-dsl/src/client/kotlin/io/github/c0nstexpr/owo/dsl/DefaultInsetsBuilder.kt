package io.github.c0nstexpr.owo.dsl

import io.wispforest.owo.ui.core.Insets

open class DefaultInsetsBuilder : InsetsBuilder() {
    var top = invalidBuilder<Int>()
    var bottom = invalidBuilder<Int>()
    var left = invalidBuilder<Int>()
    var right = invalidBuilder<Int>()

    override fun build() = Insets.of(top.build(), left.build(), bottom.build(), right.build())!!

    override val canBuild get() = top.canBuild && left.canBuild && bottom.canBuild && right.canBuild

    fun vertical(v: DslBuilder<Int>) {
        top = v
        bottom = v
    }

    fun horizontal(h: DslBuilder<Int>) {
        left = h
        right = h
    }

    fun both(h: DslBuilder<Int>, v: DslBuilder<Int>) {
        horizontal(h)
        vertical(v)
    }

    fun of(v: DslBuilder<Int>) = both(v, v)

    fun none() = of { 0 }
}

inline fun defaultInsets(crossinline block: DefaultInsetsBuilder.() -> Unit) =
    DefaultInsetsBuilder().apply(block)
