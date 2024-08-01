package io.github.c0nstexpr.owo.dsl.component

import io.github.c0nstexpr.owo.dsl.DslBuilder
import io.github.c0nstexpr.owo.dsl.nullBuilder
import io.wispforest.owo.ui.base.BaseParentComponent
import io.wispforest.owo.ui.core.HorizontalAlignment
import io.wispforest.owo.ui.core.Insets
import io.wispforest.owo.ui.core.Surface
import io.wispforest.owo.ui.core.VerticalAlignment

abstract class BaseParentComponentProvider :
    BaseComponentProvider(),
    ParentComponentProvider {
    override var verticalAlignment: VerticalAlignment? = null

    override var horizontalAlignment: HorizontalAlignment? = null

    override var padding: DslBuilder<Insets> = nullBuilder()

    override var allowOverflow: Boolean? = null

    override var surface: DslBuilder<Surface> = nullBuilder()

    override fun provide(): BaseParentComponent? = null

    protected fun applyTo(component: BaseParentComponent) {
        super<BaseComponentProvider>.applyTo(component)
        super<ParentComponentProvider>.applyTo(component)
    }
}
