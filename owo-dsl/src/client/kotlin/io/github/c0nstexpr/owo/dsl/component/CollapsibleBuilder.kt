package io.github.c0nstexpr.owo.dsl.component

import io.github.c0nstexpr.owo.dsl.DslBuilder.Companion.built
import io.github.c0nstexpr.owo.dsl.nullBuilder
import io.wispforest.owo.ui.container.CollapsibleContainer
import io.wispforest.owo.ui.container.Containers
import net.minecraft.text.Text

open class CollapsibleBuilder : FlowLayoutBuilder() {
    var title = nullBuilder<Text>()

    var expended = nullBuilder<Boolean>()

    override fun build(): CollapsibleContainer? {
        return Containers.collapsible(
            horizontalSizing.built ?: return null,
            verticalSizing.built ?: return null,
            title.built ?: return null,
            expended.built ?: return null
        ).also(::applyTo)
    }
}
