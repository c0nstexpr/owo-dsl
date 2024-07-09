package org.c0nstexpr.owo.dsl

import io.wispforest.owo.ui.core.Sizing

open class SizingBuilder : OwoBuilder<Sizing> {
    var value = 100
    var method: Sizing.Method? = null

    override fun build() = when (method) {
        Sizing.Method.EXPAND -> Sizing.expand(value)
        Sizing.Method.FIXED -> Sizing.fixed(value)
        Sizing.Method.CONTENT -> Sizing.content(value)
        Sizing.Method.FILL -> Sizing.fill(value)
        else -> null
    }
}
