package io.github.c0nstexpr.owo.dsl

import io.wispforest.owo.ui.base.BaseOwoScreen
import io.wispforest.owo.ui.core.OwoUIAdapter
import io.wispforest.owo.ui.core.ParentComponent
import net.minecraft.client.gui.screen.Screen

open class DslScreen<Layout : ParentComponent>(
    val parent: Screen,
    private val layoutBlock: OwoBuilder<Layout>
) : BaseOwoScreen<Layout>() {
    override fun createAdapter() = OwoUIAdapter.create(this) { h, v ->
        require(layoutBlock.canBuild)

        layoutBlock.build().apply {
            horizontalSizing(h)
            verticalSizing(v)
        }
    }!!

    override fun build(rootComponent: Layout) {
    }

    override fun close() {
        client?.setScreen(parent)
    }
}
