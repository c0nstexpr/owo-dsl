package io.github.c0nstexpr.owo.dsl

import io.github.c0nstexpr.owo.dsl.DslBuilder.Companion.built
import net.minecraft.text.Text

open class DropdownTextChildBuilder(var txt: DslBuilder<Text> = nullBuilder()) :
    DslBuilder<DropdownTextChild> by
    dslBuilder({ DropdownTextChild(txt.built ?: return@dslBuilder null) })
