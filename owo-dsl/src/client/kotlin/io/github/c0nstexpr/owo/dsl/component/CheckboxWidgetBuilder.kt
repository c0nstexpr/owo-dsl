package io.github.c0nstexpr.owo.dsl.component

import io.github.c0nstexpr.owo.dsl.built
import io.github.c0nstexpr.owo.dsl.invalidBuilder
import net.minecraft.client.MinecraftClient
import net.minecraft.client.gui.widget.CheckboxWidget

open class CheckboxWidgetBuilder : PressableWidgetBuilder() {
    var maxWidth = invalidBuilder<Int>()

    var callback = invalidBuilder<CheckboxWidget.Callback>()

    var checked = invalidBuilder<Boolean>()

    override fun build() = message.built?.let {
        CheckboxWidget.builder(it, MinecraftClient.getInstance().textRenderer)
            .apply {
                pos(x.built ?: 0, y.built ?: 0)
                maxWidth.built?.let(::maxWidth)
                callback.built?.let(::callback)
                checked.built?.let(::checked)
            }.build()!!.apply(::applyTo)
    }
}
