package io.github.c0nstexpr.owo.dsl

import io.github.c0nstexpr.owo.dsl.SizingBuilder.Companion.Method
import io.wispforest.owo.ui.core.Sizing

abstract class SizingBuilder : DslBuilder<Sizing> {
    companion object {
        class Method(
            var size: DslBuilder<Int> = invalidBuilder(),
            var method: DslBuilder<Sizing.Method> = invalidBuilder()
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
}

fun sizing() = invalidBuilder<Sizing>()

fun sizing(block: DslBuilder<Sizing>): SizingBuilder =
    object : SizingBuilder(), DslBuilder<Sizing> by block {}

fun sizing(block: () -> Sizing?) = sizing(dslBuilder { block() })

inline fun sizingMethod(crossinline block: Method.() -> Unit) = Method().apply(block)
