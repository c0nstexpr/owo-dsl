package io.github.c0nstexpr.owo.dsl

import io.github.c0nstexpr.owo.dsl.DslBuilder.Companion.built
import io.wispforest.owo.ui.core.Sizing

abstract class SizingBuilder : DslBuilder<Sizing> {
    class Method(
        var size: DslBuilder<Int> = nullBuilder(),
        var method: DslBuilder<Sizing.Method> = nullBuilder()
    ) : SizingBuilder(),
        DslBuilder<Sizing> by dslBuilder({
            when (method.built ?: return@dslBuilder null) {
                Sizing.Method.FIXED -> Sizing.fixed(size.built ?: return@dslBuilder null)
                Sizing.Method.CONTENT -> Sizing.content(size.built ?: return@dslBuilder null)
                Sizing.Method.FILL -> Sizing.fill(size.built ?: return@dslBuilder null)
                Sizing.Method.EXPAND -> Sizing.expand(size.built ?: return@dslBuilder null)
            }
        })
}
