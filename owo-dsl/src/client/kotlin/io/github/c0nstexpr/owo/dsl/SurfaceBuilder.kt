package io.github.c0nstexpr.owo.dsl

import io.wispforest.owo.ui.core.Surface

infix fun DslBuilder<Surface>.and(other: DslBuilder<Surface>) =
    dslBuilder { value?.and(other.value ?: return@dslBuilder null) }
