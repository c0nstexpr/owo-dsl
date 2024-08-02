package io.github.c0nstexpr.owo.dsl

import net.minecraft.text.Text

open class DropdownCheckBoxChildBuilder(
    var txt: DslBuilder<Text> = nullBuilder(),
    var state: Boolean? = null,
    var onClick: (Boolean) -> Unit = {}
) : DslBuilder<DropdownCheckBoxChild> by dslBuilder({
        DropdownCheckBoxChild(
            txt.value ?: return@dslBuilder null,
            state ?: return@dslBuilder null,
            onClick
        )
    })
