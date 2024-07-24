package io.github.c0nstexpr.owo.dsl.component

import io.github.c0nstexpr.owo.dsl.DslBuilder
import io.github.c0nstexpr.owo.dsl.built
import io.github.c0nstexpr.owo.dsl.dslBuilder
import io.github.c0nstexpr.owo.dsl.invalidBuilder
import io.github.c0nstexpr.owo.dsl.sizing
import io.github.c0nstexpr.owo.dsl.text
import io.wispforest.owo.ui.component.Components
import io.wispforest.owo.ui.component.DropdownComponent
import net.minecraft.text.Text

open class DropdownBuilder : FlowLayoutBuilder() {
    open class CheckBox(text: DslBuilder<Text> = text()) : TextElement() {
        var state = invalidBuilder<Boolean>()

        var onClick = invalidBuilder<(Boolean) -> Unit>()

        override fun addTo(dropdown: DropdownComponent) {
            dropdown.checkbox(this.text.build(), this.state.build(), this.onClick.build())
        }

        override val canAdd
            get() = text.canBuild && state.canBuild && onClick.canBuild
    }

    open class Nested : TextElement() {
        var horizontalSizing = sizing()

        var builder = invalidBuilder<(DropdownComponent) -> Unit>()

        override fun addTo(dropdown: DropdownComponent) {
            dropdown.nested(this.text.build(), this.horizontalSizing.build(), this.builder.build())
        }

        override val canAdd
            get() = text.canBuild && horizontalSizing.canBuild && builder.canBuild
    }

    var elements = invalidBuilder<List<DropdownComponent.() -> Unit>>()

    var closeWhenNotHovered = invalidBuilder<Boolean>()

    override fun build() = horizontalSizing.built?.let(Components::dropdown)?.apply(::applyTo)
}

class DropdownListBuilder : ListBuilder<DropdownComponent.() -> Unit>() {
    fun divider() = add { dslBuilder { { divider() } } }

    fun text(txt: (Int) -> DslBuilder<Text>) =
        add { i -> dslBuilder { txt(i).built?.let { { text(it) } } } }

    class Button(
        var txt: (Int) -> DslBuilder<Text>,
        var onClick: DslBuilder<(DropdownComponent) -> Unit>
    ) : DslBuilder<DropdownComponent.() -> Unit> by dslBuilder({
            txt(i).built?.let {
                {
                    val click = onClick.built
                    if (click == null) button(it) {}
                    else button(it, click)
                }
            }
        })

    fun button(txt: (Int) -> DslBuilder<Text>, onClick: DslBuilder<(DropdownComponent) -> Unit>) =
        add { i ->
            dslBuilder {
            }
        }
}

fun DropdownBuilder.applyTo(component: DropdownComponent) {
    (this as FlowLayoutBuilder).applyTo(component)

    elements.built?.forEach { component.it() }
    closeWhenNotHovered.built?.let(component::closeWhenNotHovered)
}

fun DropdownBuilder.divider() = elements.add(DropdownBuilder.Divider())

fun DropdownBuilder.text(block: DropdownBuilder.TextElement.() -> Unit) =
    elements.add(DropdownBuilder.TextElement().apply(block))

fun DropdownBuilder.button(block: DropdownBuilder.Button.() -> Unit) =
    elements.add(DropdownBuilder.Button().apply(block))

fun DropdownBuilder.checkbox(block: DropdownBuilder.CheckBox.() -> Unit) =
    elements.add(DropdownBuilder.CheckBox().apply(block))

fun DropdownBuilder.nested(block: DropdownBuilder.Nested.() -> Unit) =
    elements.add(DropdownBuilder.Nested().apply(block))
