package io.github.c0nstexpr.owo.dsl

import io.github.c0nstexpr.owo.dsl.DslBuilder.Companion.built
import io.wispforest.owo.ui.component.DropdownComponent
import net.minecraft.text.Text

open class DropdownButtonChildBuilder(
    var txt: DslBuilder<Text> = nullBuilder(),
    var onClick: (DropdownComponent) -> Unit = {}
) : DslBuilder<DropdownButtonChild> by
    dslBuilder({ DropdownButtonChild(txt.built ?: return@dslBuilder null, onClick) })
