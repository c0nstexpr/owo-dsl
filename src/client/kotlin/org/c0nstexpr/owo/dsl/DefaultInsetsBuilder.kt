package org.c0nstexpr.owo.dsl

import io.wispforest.owo.ui.core.Insets

open class DefaultInsetsBuilder : InsetsBuilder() {
    var top = invalidBuilder<Int>()
    var bottom = invalidBuilder<Int>()
    var left = invalidBuilder<Int>()
    var right = invalidBuilder<Int>()

    override fun build() = Insets.of(top.build(), left.build(), bottom.build(), right.build())!!

    override val canBuild
        get() = top.canBuild && left.canBuild && bottom.canBuild && right.canBuild

    fun vertical(v: OwoBuilder<Int> = invalidBuilder()) {
        top = v
        bottom = v
    }

    fun horizontal(h: OwoBuilder<Int> = invalidBuilder()) {
        left = h
        right = h
    }

    fun both(v: OwoBuilder<Int> = invalidBuilder()) {
        vertical(v)
        horizontal(v)
    }

    fun none() = both { 0 }
}

inline fun insets(crossinline block: DefaultInsetsBuilder.() -> Unit) =
    DefaultInsetsBuilder().apply(block)
