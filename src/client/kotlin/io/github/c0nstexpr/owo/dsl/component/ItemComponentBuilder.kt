package io.github.c0nstexpr.owo.dsl.component

import io.github.c0nstexpr.owo.dsl.applyBuild
import io.github.c0nstexpr.owo.dsl.invalidBuilder
import io.wispforest.owo.ui.component.Components
import io.wispforest.owo.ui.component.ItemComponent
import net.minecraft.item.ItemStack

open class ItemComponentBuilder : BaseComponentBuilder() {
    var stack = invalidBuilder<ItemStack>()

    var showOverlay = invalidBuilder<Boolean>()

    var setTooltipFromStack = invalidBuilder<Boolean>()

    override val canBuild get() = stack.canBuild

    override fun build() = Components.item(stack.build())!!.apply(::applyTo)
}

fun ItemComponentBuilder.applyTo(component: ItemComponent) {
    (this as BaseComponentBuilder).applyTo(component)

    showOverlay.applyBuild(component::showOverlay)
    setTooltipFromStack.applyBuild(component::setTooltipFromStack)
}

inline fun itemComponent(crossinline block: ItemComponentBuilder.() -> Unit) =
    ItemComponentBuilder().apply(block)
