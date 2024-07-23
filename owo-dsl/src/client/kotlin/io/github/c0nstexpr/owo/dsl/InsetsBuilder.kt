package io.github.c0nstexpr.owo.dsl

import io.wispforest.owo.ui.core.Insets

abstract class InsetsBuilder : DslBuilder<Insets> {
    open class Entrance :
        InsetsBuilder(),
        DslBuilder<Insets> by invalidBuilder() {
        fun by(block: DslBuilder<Insets>): InsetsBuilder =
            object : InsetsBuilder(), DslBuilder<Insets> by block {}

        fun by(block: () -> Insets?) = by(dslBuilder { block() })

        fun with(value: Insets) = by { value }

        fun of(
            top: DslBuilder<Int>,
            left: DslBuilder<Int>,
            bottom: DslBuilder<Int>,
            right: DslBuilder<Int>
        ) = by {
            val t = top.built ?: return@by null
            val l = left.built ?: return@by null
            val b = bottom.built ?: return@by null
            val r = right.built ?: return@by null

            Insets.of(t, l, b, r)
        }
    }
}

fun insets(block: InsetsBuilder.Entrance.() -> Insets) = InsetsBuilder.Entrance().block()
