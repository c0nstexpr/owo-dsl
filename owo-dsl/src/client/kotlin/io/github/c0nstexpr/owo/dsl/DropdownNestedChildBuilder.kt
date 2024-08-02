package io.github.c0nstexpr.owo.dsl

import io.wispforest.owo.ui.component.DropdownComponent
import io.wispforest.owo.ui.core.Sizing
import net.minecraft.text.Text

open class DropdownNestedChildBuilder(
    var txt: DslBuilder<Text> = nullBuilder(),
    var horizontalSizing: DslBuilder<Sizing> = nullBuilder(),
    var builder: (DropdownComponent) -> Unit = {}
) : DslBuilder<DropdownNestedChild> by dslBuilder({
        DropdownNestedChild(
            txt.value ?: return@dslBuilder null,
            horizontalSizing.value ?: return@dslBuilder null,
            builder
        )
    })
