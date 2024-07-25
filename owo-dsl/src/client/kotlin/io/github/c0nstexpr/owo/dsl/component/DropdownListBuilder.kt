package io.github.c0nstexpr.owo.dsl.component

import io.github.c0nstexpr.owo.dsl.DslBuilder
import io.github.c0nstexpr.owo.dsl.DslBuilder.Companion.built
import io.github.c0nstexpr.owo.dsl.dslBuilder
import io.github.c0nstexpr.owo.dsl.nullBuilder
import io.wispforest.owo.ui.component.DropdownComponent
import io.wispforest.owo.ui.core.Sizing
import net.minecraft.text.Text as McText

open class DropdownListBuilder : ListBuilder<DropdownComponent.() -> Unit> {
    protected constructor() : super()

    fun divider() = add(dslBuilder { { divider() } })

    class Text private constructor(var txt: DslBuilder<McText> = nullBuilder()) :
        DslBuilder<DropdownComponent.() -> Unit> by
        dslBuilder({ txt.built?.let { { text(it) } } }) {
            fun DropdownListBuilder.text(block: Text.() -> Unit) = add(Text().also(block))
        }

    class Button private constructor(
        var txt: DslBuilder<McText> = nullBuilder(),
        var onClick: DslBuilder<(DropdownComponent) -> Unit> = nullBuilder()
    ) : DslBuilder<DropdownComponent.() -> Unit> by dslBuilder({
            txt.built?.let {
                {
                    val click = onClick.built
                    if (click == null) button(it) {}
                    else button(it, click)
                }
            }
        }) {
        fun DropdownListBuilder.button(block: Button.() -> Unit) = add(Button().also(block))
    }

    class CheckBox private constructor(
        var txt: DslBuilder<McText> = nullBuilder(),
        var state: DslBuilder<Boolean> = nullBuilder(),
        var onClick: DslBuilder<(Boolean) -> Unit> = nullBuilder()
    ) : DslBuilder<DropdownComponent.() -> Unit> by dslBuilder({
            val t = txt.built ?: return@dslBuilder null
            val s = state.built ?: return@dslBuilder null

            (onClick.built ?: return@dslBuilder { checkbox(t, s) {} })
                .let { { checkbox(t, s, it) } }
        }) {
        fun DropdownListBuilder.checkbox(block: CheckBox.() -> Unit) = add(CheckBox().also(block))
    }

    class Nested private constructor(
        var txt: DslBuilder<McText> = nullBuilder(),
        var horizontalSizing: DslBuilder<Sizing> = nullBuilder(),
        var builder: DslBuilder<(DropdownComponent) -> Unit> = nullBuilder()
    ) : DslBuilder<DropdownComponent.() -> Unit> by dslBuilder({
            val t = txt.built ?: return@dslBuilder null
            val h = horizontalSizing.built ?: return@dslBuilder null
            val b = builder.built ?: return@dslBuilder { nested(t, h) {} }

            { nested(t, h, b) }
        }) {
        fun DropdownListBuilder.nested(block: Nested.() -> Unit) = add(Nested().also(block))
    }

    fun DropdownBuilder.list(block: DropdownListBuilder.() -> Unit) {
        list = DropdownListBuilder().also(block)
    }
}
