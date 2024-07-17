package io.github.c0nstexpr.owo.dsl

import io.github.c0nstexpr.owo.dsl.component.FlowLayoutBuilder
import io.wispforest.owo.ui.container.FlowLayout
import io.wispforest.owo.ui.core.Component
import net.minecraft.client.gui.screen.Screen

open class FlowScreen(
    parent: Screen,
    layoutBlock: FlowLayoutBuilder,
    contentBlock: OwoBuilder<Component>
) : DslScreen<FlowLayout>(
        parent,
        { h, v ->
            layoutBlock.horizontalSizing = sizing { h }
            layoutBlock.verticalSizing = sizing { v }
            layoutBlock.build()
        },
        { layout, component -> layout.child(component) },
        contentBlock
    )
