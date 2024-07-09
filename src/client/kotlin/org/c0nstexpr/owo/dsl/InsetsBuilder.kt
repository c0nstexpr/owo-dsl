package org.c0nstexpr.owo.dsl

import io.wispforest.owo.ui.core.Insets

open class InsetsBuilder : OwoBuilder<Insets> {
    private var initialized = false

    var top = 0
        set(value) {
            field = value
            initialized = true
        }

    var left = 0
        set(value) {
            field = value
            initialized = true
        }

    var bottom = 0
        set(value) {
            field = value
            initialized = true
        }

    var right = 0
        set(value) {
            field = value
            initialized = true
        }

    override fun build() = if (initialized) Insets.of(top, left, bottom, right) else null
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
