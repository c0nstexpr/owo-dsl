package io.github.c0nstexpr.owo.dsl

import io.wispforest.owo.ui.component.DropdownComponent
import net.minecraft.text.Text

open class DropdownTextChild(var txt: Text) : DropdownChild {
    override fun applyTo(component: DropdownComponent) {
        component.text(txt)
    }
}
