package io.github.c0nstexpr.owo.dsl

import io.github.c0nstexpr.owo.dsl.DslBuilder.Companion.built
import io.github.c0nstexpr.owo.dsl.component.GridIndex

open class GridChildrenBuilder<T : Any>(
    var index: GridIndex = GridIndex(0, 0),
    var child: DslBuilder<T> = nullBuilder()
) : DslBuilder<GridChild<T>> by dslBuilder({ child.built?.let { GridChild(index, it) } })
