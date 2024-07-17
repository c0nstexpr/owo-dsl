package io.github.c0nstexpr.owo.dsl

import io.wispforest.owo.ui.base.BaseOwoScreen
import io.wispforest.owo.ui.core.Component
import io.wispforest.owo.ui.core.OwoUIAdapter
import io.wispforest.owo.ui.core.ParentComponent
import io.wispforest.owo.ui.core.Sizing
import net.minecraft.client.gui.screen.Screen

open class DslScreen<Layout : ParentComponent>(
    val parent: Screen,
    private val layoutBlock: (Sizing, Sizing) -> Layout,
    private val addChild: (Layout, Component) -> Unit,
    private val contentBlock: OwoBuilder<Component>
) : BaseOwoScreen<Layout>() {
    override fun createAdapter() = OwoUIAdapter.create(this, layoutBlock)!!

    override fun build(rootComponent: Layout) {
        addChild(rootComponent, contentBlock.build())
    }

    override fun close() {
        client?.setScreen(parent)
    }
}
