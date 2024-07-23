package io.github.c0nstexpr.owo.dsl.component

import io.github.c0nstexpr.owo.dsl.applyBuilt
import io.github.c0nstexpr.owo.dsl.canBuild
import io.github.c0nstexpr.owo.dsl.invalidBuilder
import net.minecraft.client.MinecraftClient
import net.minecraft.client.gui.widget.CheckboxWidget

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

        maxWidth.applyBuilt(::maxWidth)
        callback.applyBuilt(::callback)
        checked.applyBuilt(::checked)
    }.build()!!.apply(::applyTo)

    override val canBuild get() = message.canBuild
}
