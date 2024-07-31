package io.github.c0nstexpr.owo.dsl.component

import io.github.c0nstexpr.owo.dsl.DslBuilder.Companion.built
import io.github.c0nstexpr.owo.dsl.nullBuilder
import io.github.c0nstexpr.owo.dsl.textRenderer
import net.minecraft.client.gui.widget.CheckboxWidget

open class CheckboxWidgetBuilder(var maxWidth: Int? = null, var checked: Boolean = false) :
    PressableWidgetBuilder() {
    override fun buildComponent() = message.built?.let {
        CheckboxWidget.builder(it, textRenderer)
            .apply {
                pos(x ?: 0, y ?: 0)
                maxWidth?.let(::maxWidth)
                Companion.callback.built?.let(::callback)
                checked(checked)
            }.build()
    }?.also(::applyTo)

    companion object {
        var callback = nullBuilder<CheckboxWidget.Callback>()
    }
}
