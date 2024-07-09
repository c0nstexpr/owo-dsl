package org.c0nstexpr.owo.dsl

import io.wispforest.owo.ui.base.BaseParentComponent

fun interface BaseParentComponentBuilder<T : BaseParentComponent> : OwoBuilder<T> {
    val horizontalSizing get() = SizingBuilder()
    val verticalSizing get() = SizingBuilder()
}
