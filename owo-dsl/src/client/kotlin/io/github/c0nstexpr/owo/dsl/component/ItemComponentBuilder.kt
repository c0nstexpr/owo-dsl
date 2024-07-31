package io.github.c0nstexpr.owo.dsl.component

import io.github.c0nstexpr.owo.dsl.DslBuilder
import io.github.c0nstexpr.owo.dsl.DslBuilder.Companion.built
import io.github.c0nstexpr.owo.dsl.nullBuilder
import io.wispforest.owo.ui.component.Components
import io.wispforest.owo.ui.component.ItemComponent
import net.minecraft.item.ItemStack

open class ItemComponentBuilder(
    var stack: DslBuilder<ItemStack> = nullBuilder(),
    var showOverlay: Boolean? = null,
    var setTooltipFromStack: Boolean? = null
) : BaseComponentBuilder() {
    override fun buildComponent() = stack.built?.let(Components::item)?.also(::applyTo)

    protected fun applyTo(component: ItemComponent) {
        super.applyTo(component)

        showOverlay?.let(component::showOverlay)
        setTooltipFromStack?.let(component::setTooltipFromStack)
    }
}
