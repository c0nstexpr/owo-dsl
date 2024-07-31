package io.github.c0nstexpr.owo.dsl

import io.wispforest.owo.ui.component.DropdownComponent
import io.wispforest.owo.ui.core.Sizing
import net.minecraft.text.Text

open class DropdownNestedChild(
    var txt: Text,
    var horizontalSizing: Sizing,
    var builder: (DropdownComponent) -> Unit
) : DropdownChild {
    override fun applyTo(component: DropdownComponent) {
        component.nested(txt, horizontalSizing, builder)
    }
}
