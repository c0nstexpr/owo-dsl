package io.github.c0nstexpr.owo.dsl.component

import io.github.c0nstexpr.owo.dsl.DslBuilder
import io.github.c0nstexpr.owo.dsl.DslBuilder.Companion.built
import io.github.c0nstexpr.owo.dsl.nullBuilder
import io.wispforest.owo.ui.container.CollapsibleContainer
import io.wispforest.owo.ui.container.Containers
import net.minecraft.text.Text

open class CollapsibleBuilder(
    var title: DslBuilder<Text> = nullBuilder(),
    var expended: Boolean? = null
) : FlowLayoutBuilder() {
    override fun buildComponent(): CollapsibleContainer? {
        return Containers.collapsible(
            horizontalSizing.built ?: return null,
            verticalSizing.built ?: return null,
            title.built ?: return null,
            expended ?: return null
        ).also(::applyTo)
    }
}
