package io.github.c0nstexpr.owo.dsl

import io.wispforest.owo.ui.core.Insets

open class DefaultInsetsBuilder(
    var top: DslBuilder<Int> = invalidBuilder(),
    var bottom: DslBuilder<Int> = invalidBuilder(),
    var left: DslBuilder<Int> = invalidBuilder(),
    var right: DslBuilder<Int> = invalidBuilder()
) : InsetsBuilder(),
    DslBuilder<Insets> by insets(
        {
            top.applyBuilt { top ->
                bottom.applyBuilt { bottom ->
                    left.applyBuilt { left ->
                        right.applyBuilt { Insets.of(top, left, bottom, it) }
                    }
                }
            }
        }
    ) {
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

    fun none() = of(dslBuilder { 0 })
}

inline fun defaultInsets(crossinline block: DefaultInsetsBuilder.() -> Unit) =
    DefaultInsetsBuilder().apply(block)
