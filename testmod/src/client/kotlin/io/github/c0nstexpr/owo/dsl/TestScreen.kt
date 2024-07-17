package io.github.c0nstexpr.owo.dsl

import io.github.c0nstexpr.owo.dsl.component.flowLayout
import net.minecraft.client.gui.screen.Screen

fun buildUI() = flowLayout {
}

class TestScreen(parent: Screen) : FlowScreen(parent, flowLayout { }, buildUI())
