package io.github.c0nstexpr.owo.dsl

import io.wispforest.owo.ui.component.DropdownComponent

open class DropdownDividerChild : DropdownChild {
    override fun applyTo(component: DropdownComponent) {
        component.divider()
    }
}
