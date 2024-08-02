package io.github.c0nstexpr.owo.dsl

import io.wispforest.owo.ui.base.BaseOwoScreen
import io.wispforest.owo.ui.core.OwoUIAdapter
import io.wispforest.owo.ui.core.ParentComponent
import net.minecraft.client.gui.screen.Screen

open class DslScreen<Layout : ParentComponent>(
    val parent: Screen,
    private val layoutBlock: DslBuilder<Layout>
) : BaseOwoScreen<Layout>() {
    override fun createAdapter() = OwoUIAdapter.create(this) { h, v ->
        requireNotNull(layoutBlock.value).apply {
            horizontalSizing(h)
            verticalSizing(v)
        }
    }!!

    override fun build(rootComponent: Layout) {
    }

    override fun clearChildren() {
        layoutBlock.clear()
        super.clearChildren()
    }

    override fun close() {
        client?.setScreen(parent)
    }
}
