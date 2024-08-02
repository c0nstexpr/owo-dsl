package io.github.c0nstexpr.owo.dsl.component

import io.github.c0nstexpr.owo.dsl.DslBuilder
import io.github.c0nstexpr.owo.dsl.nullBuilder
import io.wispforest.owo.ui.component.BoxComponent
import io.wispforest.owo.ui.component.Components
import io.wispforest.owo.ui.core.Sizing

open class BoxBuilder(
    override var horizontalSizing: DslBuilder<Sizing> = nullBuilder(),
    override var verticalSizing: DslBuilder<Sizing> = nullBuilder()
) : BoxBuilderBase() {
    override val value: BoxComponent?
        get() {
            return Components.box(
                horizontalSizing.value ?: return null,
                verticalSizing.value ?: return null
            ).also(::configure)
        }
}
