package io.github.c0nstexpr.owo.dsl.component

import io.github.c0nstexpr.owo.dsl.DslBuilder.Companion.built
import io.github.c0nstexpr.owo.dsl.nullBuilder
import io.github.c0nstexpr.owo.dsl.textRenderer
import net.minecraft.client.gui.widget.EditBoxWidget
import net.minecraft.text.Text

open class EditBoxBuilder : ScrollableWidgetBuilder() {
    var placeholder = nullBuilder<Text>()

    var maxLength = nullBuilder<Int>()

    var text = nullBuilder<String>()

    val width = nullBuilder<Int>()

    val height = nullBuilder<Int>()

    override fun build(): EditBoxWidget? {
        return EditBoxWidget(
            textRenderer,
            x.built ?: 0,
            y.built ?: 0,
            width.built ?: 0,
            height.built ?: 0,
            placeholder.built ?: Text.empty(),
            message.built ?: return null
        ).also(::applyTo)
    }
}

fun EditBoxBuilder.applyTo(component: EditBoxWidget) {
    (this as ScrollableWidgetBuilder).applyTo(component)

    maxLength.built?.let(component::setMaxLength)
    text.built?.let(component::setText)
}
