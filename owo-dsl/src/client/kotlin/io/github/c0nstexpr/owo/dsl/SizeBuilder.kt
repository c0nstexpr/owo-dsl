package io.github.c0nstexpr.owo.dsl

import io.wispforest.owo.ui.core.Size

open class SizeBuilder(var width: Int = 0, var height: Int = 0) :
    DslBuilder<Size> by dslBuilder({ Size.of(width, height) })
