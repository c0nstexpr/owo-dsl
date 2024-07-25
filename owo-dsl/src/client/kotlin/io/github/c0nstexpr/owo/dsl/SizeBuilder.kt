package io.github.c0nstexpr.owo.dsl

import io.github.c0nstexpr.owo.dsl.DslBuilder.Companion.built
import io.wispforest.owo.ui.core.Size

abstract class SizeBuilder : DslBuilder<Size> {
    class Of(
        var width: DslBuilder<Int> = nullBuilder(),
        var height: DslBuilder<Int> = nullBuilder()
    ) : SizeBuilder(),
        DslBuilder<Size> by dslBuilder({
            Size.of(
                width.built ?: return@dslBuilder null,
                height.built ?: return@dslBuilder null
            )
        })
}
