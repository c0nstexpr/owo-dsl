package io.github.c0nstexpr.owo.dsl

import io.wispforest.owo.ui.core.Sizing

open class SizingBuilder(var size: Int = 0, var method: Sizing.Method? = null) :
    DslBuilder<Sizing> by dslBuilder({
        when (method ?: return@dslBuilder null) {
            Sizing.Method.FIXED -> Sizing.fixed(size)
            Sizing.Method.CONTENT -> Sizing.content(size)
            Sizing.Method.FILL -> Sizing.fill(size)
            Sizing.Method.EXPAND -> Sizing.expand(size)
        }
    })
