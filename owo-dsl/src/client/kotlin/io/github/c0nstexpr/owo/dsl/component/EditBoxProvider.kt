package io.github.c0nstexpr.owo.dsl.component

import io.github.c0nstexpr.owo.dsl.DslBuilder
import io.github.c0nstexpr.owo.dsl.DslBuilder.Companion.built
import io.github.c0nstexpr.owo.dsl.nullBuilder
import io.github.c0nstexpr.owo.dsl.textRenderer
import net.minecraft.client.gui.widget.EditBoxWidget
import net.minecraft.text.Text

open class EditBoxProvider(
    var placeholder: DslBuilder<Text> = nullBuilder(),
    var maxLength: Int? = null,
    var text: String? = null,
    val width: Int? = null,
    val height: Int? = null
) : ScrollableWidgetProvider() {
    override fun provide(): EditBoxWidget? {
        return EditBoxWidget(
            textRenderer,
            x ?: 0,
            y ?: 0,
            width ?: 0,
            height ?: 0,
            placeholder.built ?: Text.empty(),
            message.built ?: return null
        ).also(::applyTo)
    }

    protected fun applyTo(component: EditBoxWidget) {
        super.applyTo(component)
        maxLength?.let(component::setMaxLength)
        text?.let(component::setText)
    }
}
