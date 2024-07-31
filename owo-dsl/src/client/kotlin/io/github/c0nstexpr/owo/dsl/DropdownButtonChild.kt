package io.github.c0nstexpr.owo.dsl

import io.wispforest.owo.ui.component.DropdownComponent
import net.minecraft.text.Text

open class DropdownButtonChild(var txt: Text, var onClick: (DropdownComponent) -> Unit) :
    DropdownChild {
    override fun applyTo(component: DropdownComponent) {
        component.button(txt, onClick)
    }
}
