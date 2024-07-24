package io.github.c0nstexpr.owo.dsl

import io.github.c0nstexpr.owo.dsl.SizeBuilder.Companion.Of
import io.wispforest.owo.ui.core.Size

abstract class SizeBuilder : DslBuilder<Size> {
    companion object {
        class Of(
            var width: DslBuilder<Int> = invalidBuilder(),
            var height: DslBuilder<Int> = invalidBuilder()
        ) : SizeBuilder(),
            DslBuilder<Size> by dslBuilder({
                Size.of(
                    width.built ?: return@dslBuilder null,
                    height.built ?: return@dslBuilder null
                )
            })
    }
}

fun size() = invalidBuilder<Size>()

fun size(block: DslBuilder<Size>): SizeBuilder =
    object : SizeBuilder(), DslBuilder<Size> by block {}

fun size(block: () -> Size) = size(dslBuilder { block() })

inline fun sizeOf(crossinline block: Of.() -> Unit) = Of().apply(block)
