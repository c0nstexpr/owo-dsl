package org.c0nstexpr.owo.dsl.component

import io.wispforest.owo.ui.component.Components
import io.wispforest.owo.ui.component.ItemComponent
import net.minecraft.item.ItemStack
import org.c0nstexpr.owo.dsl.OwoBuilder
import org.c0nstexpr.owo.dsl.invalidBuilder

abstract class ItemComponentBuilder<T : ItemComponent> : BaseComponentBuilder<T>() {
    var stackBuilder = invalidBuilder<ItemStack>()

    var showOverlay: Boolean? = null

    var setTooltipFromStack: Boolean? = null

    override val canBuild get() = stackBuilder.canBuild

    override fun applyTo(component: T) {
        super.applyTo(component)
        showOverlay?.let(component::showOverlay)
        setTooltipFromStack?.let(component::setTooltipFromStack)
    }
}

inline fun itemComponent(crossinline block: ItemComponentBuilder<ItemComponent>.() -> Unit) =
    object : ItemComponentBuilder<ItemComponent>() {
        override fun build() = Components.item(stackBuilder.build())
    }.apply(block)

inline val ItemComponentBuilder<*>.stack get() = stackBuilder

inline fun ItemComponentBuilder<*>.stack(crossinline block: OwoBuilder<ItemStack>.() -> Unit) =
    block(stackBuilder)
