package io.github.c0nstexpr.owo.dsl

import io.github.c0nstexpr.owo.dsl.component.GridIndex

data class GridChild<out T : Any>(val index: GridIndex, val child: T)
