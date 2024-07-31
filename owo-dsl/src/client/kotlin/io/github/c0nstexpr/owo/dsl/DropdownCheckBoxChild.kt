package io.github.c0nstexpr.owo.dsl

import io.wispforest.owo.ui.component.DropdownComponent
import net.minecraft.text.Text

open class DropdownCheckBoxChild(
    var txt: Text,
    var state: Boolean,
    var onClick: (Boolean) -> Unit
) : DropdownChild {
    override fun applyTo(component: DropdownComponent) {
        component.checkbox(txt, state, onClick)
    }
}
