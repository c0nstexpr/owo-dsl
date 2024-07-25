package io.github.c0nstexpr.owo.dsl.component

import io.github.c0nstexpr.owo.dsl.DslBuilder.Companion.built
import io.github.c0nstexpr.owo.dsl.nullBuilder
import io.wispforest.owo.ui.component.Components
import io.wispforest.owo.ui.component.ItemComponent
import net.minecraft.item.ItemStack

open class ItemComponentBuilder : BaseComponentBuilder() {
    var stack = nullBuilder<ItemStack>()

    var showOverlay = nullBuilder<Boolean>()

    var setTooltipFromStack = nullBuilder<Boolean>()

    override fun build() = stack.built?.let(Components::item)?.also(::applyTo)
}

fun ItemComponentBuilder.applyTo(component: ItemComponent) {
    (this as BaseComponentBuilder).applyTo(component)

    showOverlay.built?.let(component::showOverlay)
    setTooltipFromStack.built?.let(component::setTooltipFromStack)
}
