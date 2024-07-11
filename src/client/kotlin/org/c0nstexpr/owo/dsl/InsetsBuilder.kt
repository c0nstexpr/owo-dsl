package org.c0nstexpr.owo.dsl

import io.wispforest.owo.ui.core.Insets

open class InsetsBuilder : OwoBuilder<Insets> {
    var top: Int? = null

    var left: Int? = null

    var bottom: Int? = null

    var right: Int? = null

    override fun build() = Insets.of(top!!, left!!, bottom!!, right!!)!!

    override val canBuild get() = top != null && left != null && bottom != null && right != null
}

fun InsetsBuilder.vertical(v: Int) {
    top = v
    bottom = v
}

fun InsetsBuilder.horizontal(h: Int) {
    left = h
    right = h
}

fun InsetsBuilder.both(v: Int) {
    vertical(v)
    horizontal(v)
}

fun InsetsBuilder.none() = both(0)
