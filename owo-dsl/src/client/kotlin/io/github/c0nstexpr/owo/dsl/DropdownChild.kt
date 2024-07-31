package io.github.c0nstexpr.owo.dsl

import io.wispforest.owo.ui.component.DropdownComponent

interface DropdownChild {
    fun applyTo(component: DropdownComponent)
}
