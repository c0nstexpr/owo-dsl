package io.github.c0nstexpr.owo.dsl.component

import io.github.c0nstexpr.owo.dsl.nullBuilder
import io.wispforest.owo.ui.base.BaseComponent
import io.wispforest.owo.ui.core.Size

abstract class BaseComponentBuilder : ComponentBuilder by componentBuilder() {
    var space = nullBuilder<Size>()

    protected fun configure(component: BaseComponent) {
        super.configure(component)
        space.value?.let(component::inflate)
    }
}
