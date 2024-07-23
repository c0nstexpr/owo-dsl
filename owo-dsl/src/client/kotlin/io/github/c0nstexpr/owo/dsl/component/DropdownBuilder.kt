package io.github.c0nstexpr.owo.dsl.component

import io.github.c0nstexpr.owo.dsl.applyBuilt
import io.github.c0nstexpr.owo.dsl.canBuild
import io.github.c0nstexpr.owo.dsl.invalidBuilder
import io.github.c0nstexpr.owo.dsl.sizing
import io.github.c0nstexpr.owo.dsl.text
import io.wispforest.owo.ui.component.Components
import io.wispforest.owo.ui.component.DropdownComponent

open class DropdownBuilder : FlowLayoutBuilder() {
    interface Child {
        fun addTo(dropdown: DropdownComponent)

        val canAdd: Boolean
    }

    open class Divider : Child {
        override fun addTo(dropdown: DropdownComponent) {
            dropdown.divider()
        }

        override val canAdd get() = true
    }

    open class Text : Child {
        var text = text()

        override fun addTo(dropdown: DropdownComponent) {
            dropdown.text(this.text.build())
        }

        override val canAdd get() = text.canBuild
    }

    open class Button : Text() {
        var onClick = invalidBuilder<(DropdownComponent) -> Unit>()

        override fun addTo(dropdown: DropdownComponent) {
            dropdown.button(this.text.build(), this.onClick.build())
        }

        override val canAdd get() = text.canBuild && onClick.canBuild
    }

    open class CheckBox : Text() {
        var state = invalidBuilder<Boolean>()

        var onClick = invalidBuilder<(Boolean) -> Unit>()

        override fun addTo(dropdown: DropdownComponent) {
            dropdown.checkbox(this.text.build(), this.state.build(), this.onClick.build())
        }

        override val canAdd
            get() = text.canBuild && state.canBuild && onClick.canBuild
    }

    open class Nested : Text() {
        var horizontalSizing = sizing()

        var builder = invalidBuilder<(DropdownComponent) -> Unit>()

        override fun addTo(dropdown: DropdownComponent) {
            dropdown.nested(this.text.build(), this.horizontalSizing.build(), this.builder.build())
        }

        override val canAdd
            get() = text.canBuild && horizontalSizing.canBuild && builder.canBuild
    }

    var dropdownChildren = mutableListOf<Child>()

    var closeWhenNotHovered = invalidBuilder<Boolean>()

    override fun build() = Components.dropdown(horizontalSizing.build())!!.apply(::applyTo)

    override val canBuild get() = horizontalSizing.canBuild
}

fun DropdownBuilder.applyTo(component: DropdownComponent) {
    (this as FlowLayoutBuilder).applyTo(component)

    if (dropdownChildren.all { it.canAdd }) dropdownChildren.forEach { it.addTo(component) }

    closeWhenNotHovered.applyBuilt(component::closeWhenNotHovered)
}

fun DropdownBuilder.divider() = dropdownChildren.add(DropdownBuilder.Divider())

fun DropdownBuilder.text(block: DropdownBuilder.Text.() -> Unit) =
    dropdownChildren.add(DropdownBuilder.Text().apply(block))

fun DropdownBuilder.button(block: DropdownBuilder.Button.() -> Unit) =
    dropdownChildren.add(DropdownBuilder.Button().apply(block))

fun DropdownBuilder.checkbox(block: DropdownBuilder.CheckBox.() -> Unit) =
    dropdownChildren.add(DropdownBuilder.CheckBox().apply(block))

fun DropdownBuilder.nested(block: DropdownBuilder.Nested.() -> Unit) =
    dropdownChildren.add(DropdownBuilder.Nested().apply(block))
