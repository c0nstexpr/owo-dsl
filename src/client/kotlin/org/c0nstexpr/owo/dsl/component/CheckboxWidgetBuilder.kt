package org.c0nstexpr.owo.dsl.component

import net.minecraft.client.MinecraftClient
import net.minecraft.client.gui.widget.CheckboxWidget
import org.c0nstexpr.owo.dsl.applyBuild
import org.c0nstexpr.owo.dsl.invalidBuilder

open class CheckboxWidgetBuilder : PressableWidgetBuilder() {
    var maxWidth = invalidBuilder<Int>()

    var callback = invalidBuilder<CheckboxWidget.Callback>()

    var checked = invalidBuilder<Boolean>()

    override fun build() = CheckboxWidget.builder(
        message.build(),
        MinecraftClient.getInstance().textRenderer
    ).apply {
        if (x.canBuild) {
            if (y.canBuild) pos(x.build(), y.build())
            else pos(x.build(), 0)
        } else if (y.canBuild) pos(0, y.build())

        maxWidth.applyBuild(::maxWidth)
        callback.applyBuild(::callback)
        checked.applyBuild(::checked)
    }.build()!!.apply(::applyTo)
}

inline fun checkboxWidget(crossinline block: CheckboxWidgetBuilder.() -> Unit) =
    CheckboxWidgetBuilder().apply(block)
