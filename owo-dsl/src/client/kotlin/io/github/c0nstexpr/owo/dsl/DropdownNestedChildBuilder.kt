package io.github.c0nstexpr.owo.dsl

import io.github.c0nstexpr.owo.dsl.DslBuilder.Companion.built
import io.wispforest.owo.ui.component.DropdownComponent
import io.wispforest.owo.ui.core.Sizing
import net.minecraft.text.Text

open class DropdownNestedChildBuilder(
    var txt: DslBuilder<Text> = nullBuilder(),
    var horizontalSizing: DslBuilder<Sizing> = nullBuilder(),
    var builder: (DropdownComponent) -> Unit = {}
) : DslBuilder<DropdownNestedChild> by dslBuilder({
        DropdownNestedChild(
            txt.built ?: return@dslBuilder null,
            horizontalSizing.built ?: return@dslBuilder null,
            builder
        )
    })
