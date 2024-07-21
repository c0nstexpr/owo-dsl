package io.github.c0nstexpr.owo.dsl

import io.github.c0nstexpr.owo.dsl.component.button
import io.github.c0nstexpr.owo.dsl.component.flowLayout
import io.github.c0nstexpr.owo.dsl.component.getChild
import io.github.c0nstexpr.owo.dsl.component.list
import io.wispforest.owo.ui.component.ButtonComponent
import io.wispforest.owo.ui.container.FlowLayout
import io.wispforest.owo.ui.core.HorizontalAlignment
import io.wispforest.owo.ui.core.Sizing
import io.wispforest.owo.ui.core.Surface
import io.wispforest.owo.ui.core.VerticalAlignment
import net.minecraft.client.gui.screen.Screen

private val defaultSurface = Surface.flat(0x77000000)!!

private val darkBackgroundButton = button {
    id = "DarkBackgroundButton".owoValue
    message = textString { str = "Dark Background".owoValue }
}
private val noBackgroundButton = button {
    id = "NoBackgroundButton".owoValue
    message = textString { str = "No Background".owoValue }
}

private val dirtBackgroundButton = button {
    id = "DirtBackgroundButton".owoValue
    message = textString { str = "Dirt Background".owoValue }
}

private val testButton = button {
    id = "TestButton".owoValue
    message = textString { str = "Test Background".owoValue }
}

fun buildUI(): DslBuilder<FlowLayout> = flowLayout {
    algo = FlowLayout.Algorithm.VERTICAL.owoValue
    horizontalSizing = sizing(Sizing.fill().owoValue)
    verticalSizing = horizontalSizing
    horizontalAlignment = HorizontalAlignment.CENTER.owoValue
    verticalAlignment = VerticalAlignment.CENTER.owoValue
    padding = defaultInsets { of(10.owoValue) }
    surface = surface { defaultSurface }

    children = list {
        add { darkBackgroundButton }
        add { noBackgroundButton }
        add { dirtBackgroundButton }
        add { testButton }
    }
}

class TestScreen(parent: Screen) :
    DslScreen<FlowLayout>(
        parent,
        buildUI().run { dslBuilder(::canBuild, ::build) }
    ) {
    override fun build(rootComponent: FlowLayout) {
        super.build(rootComponent)

        rootComponent.apply {
            getChild<ButtonComponent>("DarkBackgroundButton")!!
                .onPress { surface(defaultSurface) }

            getChild<ButtonComponent>("NoBackgroundButton")!!
                .onPress { surface(Surface.BLANK) }

            getChild<ButtonComponent>("DirtBackgroundButton")!!
                .onPress { surface(Surface.BLANK) }

            getChild<ButtonComponent>("TestButton")!!
                .onPress { surface(blankSurface().build()) }
        }
    }
}
