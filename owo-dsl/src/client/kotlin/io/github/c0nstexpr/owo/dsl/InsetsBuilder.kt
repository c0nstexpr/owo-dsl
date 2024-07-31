package io.github.c0nstexpr.owo.dsl

import io.wispforest.owo.ui.core.Insets

open class InsetsBuilder(
    var top: Int = 0,
    var bottom: Int = 0,
    var left: Int = 0,
    var right: Int = 0
) : DslBuilder<Insets> by dslBuilder({ Insets.of(top, bottom, left, right) }) {
    fun vertical(v: Int) {
        top = v
        bottom = v
    }

    fun horizontal(h: Int) {
        left = h
        right = h
    }

    fun both(h: Int, v: Int) {
        horizontal(h)
        vertical(v)
    }

    fun of(v: Int) = both(v, v)

    fun none() = of(0)
}
