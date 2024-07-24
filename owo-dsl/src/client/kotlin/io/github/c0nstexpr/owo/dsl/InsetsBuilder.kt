package io.github.c0nstexpr.owo.dsl

import io.github.c0nstexpr.owo.dsl.InsetsBuilder.Companion.Of
import io.wispforest.owo.ui.core.Insets

abstract class InsetsBuilder : DslBuilder<Insets> {
    companion object {
        class Of(
            var top: DslBuilder<Int> = invalidBuilder(),
            var bottom: DslBuilder<Int> = invalidBuilder(),
            var left: DslBuilder<Int> = invalidBuilder(),
            var right: DslBuilder<Int> = invalidBuilder()
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
}

fun insets() = invalidBuilder<Insets>()

fun insets(block: DslBuilder<Insets>): InsetsBuilder =
    object : InsetsBuilder(), DslBuilder<Insets> by block {}

fun insets(block: () -> Insets?) = insets(dslBuilder { block() })

inline fun insetsOf(crossinline block: Of.() -> Unit) = Of().apply(block)
