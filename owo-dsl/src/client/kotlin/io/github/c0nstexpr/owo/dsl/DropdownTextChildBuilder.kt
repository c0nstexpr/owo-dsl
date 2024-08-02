package io.github.c0nstexpr.owo.dsl

import net.minecraft.text.Text

open class DropdownTextChildBuilder(var txt: DslBuilder<Text> = nullBuilder()) :
    DslBuilder<DropdownTextChild> by
    dslBuilder({ DropdownTextChild(txt.value ?: return@dslBuilder null) })
