package io.github.c0nstexpr.owo.dsl.component

import io.github.c0nstexpr.owo.dsl.DslBuilder
import io.github.c0nstexpr.owo.dsl.DslBuilder.Companion.built
import io.github.c0nstexpr.owo.dsl.OwoDslMarker
import io.github.c0nstexpr.owo.dsl.nullBuilder
import io.wispforest.owo.ui.component.DropdownComponent
import io.wispforest.owo.ui.core.Sizing
import net.minecraft.text.Text as McText

@OwoDslMarker
open class DropdownListBuilder protected constructor() {
    val list = mutableListOf<DropdownComponent.() -> Unit>()

    @OwoDslMarker
    fun add(block: DropdownComponent.() -> Unit) = list.add(block)

    @OwoDslMarker
    fun divider() = add { divider() }

    @OwoDslMarker
    class Text private constructor(var txt: DslBuilder<McText> = nullBuilder()) {
        companion object {
            @OwoDslMarker
            fun DropdownListBuilder.text(block: Text.() -> Unit) = Text().run {
                block()
                this@text.add { txt.built?.let(::text) }
            }
        }
    }

    @OwoDslMarker
    open class Button protected constructor(
        var txt: DslBuilder<McText> = nullBuilder(),
        var onClick: (DropdownComponent) -> Unit = {}
    ) {
        companion object {
            @OwoDslMarker
            fun DropdownListBuilder.button(block: Button.() -> Unit) = Button().run {
                block()
                this@button.add { button(txt.built ?: return@add, onClick) }
            }
        }
    }

    @OwoDslMarker
    open class CheckBox protected constructor(
        var txt: DslBuilder<McText> = nullBuilder(),
        var state: DslBuilder<Boolean> = nullBuilder(),
        var onClick: (Boolean) -> Unit = {}
    ) {
        companion object {
            @OwoDslMarker
            fun DropdownListBuilder.checkbox(block: CheckBox.() -> Unit) = CheckBox().run {
                block()
                this@checkbox.add {
                    checkbox(
                        txt.built ?: return@add,
                        state.built ?: false,
                        onClick
                    )
                }
            }
        }
    }

    @OwoDslMarker
    open class Nested protected constructor(
        var txt: DslBuilder<McText> = nullBuilder(),
        var horizontalSizing: DslBuilder<Sizing> = nullBuilder(),
        var builder: (DropdownComponent) -> Unit = {}
    ) {
        companion object {
            @OwoDslMarker
            fun DropdownListBuilder.nested(block: Nested.() -> Unit) = Nested().run {
                block()
                this@nested.add {
                    nested(
                        txt.built ?: return@add,
                        horizontalSizing.built ?: return@add,
                        builder
                    )
                }
            }
        }
    }
}
