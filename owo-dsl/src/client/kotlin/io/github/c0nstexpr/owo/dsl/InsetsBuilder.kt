package io.github.c0nstexpr.owo.dsl

import io.wispforest.owo.ui.core.Insets

abstract class InsetsBuilder : DslBuilder<Insets>

fun insets(block: DslBuilder<Insets> = invalidBuilder()): InsetsBuilder =
    object : InsetsBuilder(), DslBuilder<Insets> by block {}

inline fun insets(crossinline block: () -> Insets?) = insets(dslBuilder { block() })
