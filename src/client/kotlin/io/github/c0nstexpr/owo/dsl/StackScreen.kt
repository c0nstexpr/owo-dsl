package io.github.c0nstexpr.owo.dsl

import io.github.c0nstexpr.owo.dsl.component.StackLayoutBuilder
import io.wispforest.owo.ui.container.StackLayout
import io.wispforest.owo.ui.core.Component
import net.minecraft.client.gui.screen.Screen

open class StackScreen(
    parent: Screen,
    layoutBlock: StackLayoutBuilder,
    contentBlock: OwoBuilder<Component>
) : DslScreen<StackLayout>(
        parent,
        { h, v ->
            layoutBlock.horizontalSizing = sizing { h }
            layoutBlock.verticalSizing = sizing { v }
            layoutBlock.build()
        },
        { layout, component -> layout.child(component) },
        contentBlock
    )
