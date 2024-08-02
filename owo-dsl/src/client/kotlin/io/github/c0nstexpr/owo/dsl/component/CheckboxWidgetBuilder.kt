package io.github.c0nstexpr.owo.dsl.component

import io.github.c0nstexpr.owo.dsl.nullBuilder
import io.github.c0nstexpr.owo.dsl.textRenderer
import net.minecraft.client.gui.widget.CheckboxWidget

open class CheckboxWidgetBuilder(var maxWidth: Int? = null, var checked: Boolean = false) :
    PressableWidgetBuilder() {
    override fun provide() = message.value?.let {
        CheckboxWidget.builder(it, textRenderer)
            .apply {
                pos(x ?: 0, y ?: 0)
                maxWidth?.let(::maxWidth)
                Companion.callback.value?.let(::callback)
                checked(checked)
            }.build()
    }?.also(::applyTo)

    companion object {
        var callback = nullBuilder<CheckboxWidget.Callback>()
    }
}
