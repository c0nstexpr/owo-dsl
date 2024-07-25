package io.github.c0nstexpr.owo.dsl

import io.github.c0nstexpr.owo.dsl.DslBuilder.Companion.built
import io.wispforest.owo.ui.core.Insets

abstract class InsetsBuilder : DslBuilder<Insets> {
    class Of(
        var top: DslBuilder<Int> = nullBuilder(),
        var bottom: DslBuilder<Int> = nullBuilder(),
        var left: DslBuilder<Int> = nullBuilder(),
        var right: DslBuilder<Int> = nullBuilder()
    ) : InsetsBuilder(),
        DslBuilder<Insets> by dslBuilder({
            Insets.of(
                top.built ?: return@dslBuilder null,
                bottom.built ?: return@dslBuilder null,
                left.built ?: return@dslBuilder null,
                right.built ?: return@dslBuilder null
            )
        }) {
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
}
