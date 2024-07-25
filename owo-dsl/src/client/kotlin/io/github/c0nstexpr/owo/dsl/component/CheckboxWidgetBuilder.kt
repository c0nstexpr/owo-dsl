package io.github.c0nstexpr.owo.dsl.component

import io.github.c0nstexpr.owo.dsl.DslBuilder.Companion.built
import io.github.c0nstexpr.owo.dsl.nullBuilder
import io.github.c0nstexpr.owo.dsl.textRenderer
import net.minecraft.client.gui.widget.CheckboxWidget

open class CheckboxWidgetBuilder : PressableWidgetBuilder() {
    var maxWidth = nullBuilder<Int>()

    var callback = nullBuilder<CheckboxWidget.Callback>()

    var checked = nullBuilder<Boolean>()

    override fun build() = message.built?.let {
        CheckboxWidget.builder(it, textRenderer)
            .apply {
                pos(x.built ?: 0, y.built ?: 0)
                maxWidth.built?.let(::maxWidth)
                callback.built?.let(::callback)
                checked.built?.let(::checked)
            }.build()
    }?.also(::applyTo)
}
