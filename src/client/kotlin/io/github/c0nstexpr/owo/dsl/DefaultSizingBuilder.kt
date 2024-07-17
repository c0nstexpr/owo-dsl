package io.github.c0nstexpr.owo.dsl

import io.wispforest.owo.ui.core.Sizing

open class DefaultSizingBuilder : SizingBuilder() {
    var value = invalidBuilder<Int>()

    var method = invalidBuilder<Sizing.Method>()

    override fun build(): Sizing {
        val v = value.build()

        return when (method.build()) {
            Sizing.Method.EXPAND -> Sizing.expand(v)
            Sizing.Method.FIXED -> Sizing.fixed(v)
            Sizing.Method.CONTENT -> Sizing.content(v)
            Sizing.Method.FILL -> Sizing.fill(v)
        }
    }

    override val canBuild get() = value.canBuild && method.canBuild
}

inline fun defaultSizingBuilder(crossinline block: DefaultSizingBuilder.() -> Unit) =
    DefaultSizingBuilder().apply(block)
