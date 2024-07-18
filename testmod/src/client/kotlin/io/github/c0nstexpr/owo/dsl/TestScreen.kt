package io.github.c0nstexpr.owo.dsl

import io.github.c0nstexpr.owo.dsl.component.button
import io.github.c0nstexpr.owo.dsl.component.flowLayout
import io.github.c0nstexpr.owo.dsl.component.list
import io.wispforest.owo.ui.component.ButtonComponent
import io.wispforest.owo.ui.container.FlowLayout
import io.wispforest.owo.ui.core.Sizing
import net.minecraft.client.gui.screen.Screen
import java.util.function.Consumer

fun buildUI() = flowLayout root@{
    val defaultSurface = flatSurface { color = 0x77000000.owoValue }

    algo = FlowLayout.Algorithm.VERTICAL.owoValue

    children = list {
        // From https://github.com/wisp-forest/owo-lib/blob/1.21/src/testmod/java/io/wispforest/uwu/client/ComponentTestScreen.java

        flowLayout {
            algo = FlowLayout.Algorithm.VERTICAL.owoValue
            horizontalSizing = sizing { Sizing.content() }
            verticalSizing = horizontalSizing
            padding = defaultInsets { of(10.owoValue) }
            surface = defaultSurface

            button {
                message = textString { str = "Dark Background".owoValue }

                onPress = Consumer<ButtonComponent> { this@root.surface = defaultSurface }.owoValue
            }

            button {
                message = textString { str = "No Background".owoValue }

                onPress = Consumer<ButtonComponent> {
                    this@root.surface = blankSurface()
                }.owoValue
            }

            button {
                message = textString { str = "Dirt Background".owoValue }

                onPress = Consumer<ButtonComponent> {
                    this@root.surface = optionsBackgroundSurface()
                }.owoValue
            }
        }
    }
}

class TestScreen(parent: Screen) :
    DslScreen<FlowLayout>(
        parent,
        object : OwoBuilder<FlowLayout> {
            val builder = buildUI()

            override fun build() = builder.build()

            override val canBuild get() = builder.canBuild
        }
    )
