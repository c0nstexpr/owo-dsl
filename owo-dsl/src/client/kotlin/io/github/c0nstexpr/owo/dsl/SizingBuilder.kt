package io.github.c0nstexpr.owo.dsl

import io.github.c0nstexpr.owo.dsl.DslBuilder.Companion.built
import io.wispforest.owo.ui.core.Sizing

abstract class SizingBuilder : DslBuilder<Sizing> {
    class Method(
        var size: DslBuilder<Int> = nullBuilder(),
        var method: DslBuilder<Sizing.Method> = nullBuilder()
    ) : SizingBuilder(),
        DslBuilder<Sizing> by dslBuilder({
            val s = size.built ?: return@dslBuilder null

            when (method.built ?: return@dslBuilder null) {
                Sizing.Method.FIXED -> Sizing.fixed(s)
                Sizing.Method.CONTENT -> Sizing.content(s)
                Sizing.Method.FILL -> Sizing.fill(s)
                Sizing.Method.EXPAND -> Sizing.expand(s)
            }
        })
}
