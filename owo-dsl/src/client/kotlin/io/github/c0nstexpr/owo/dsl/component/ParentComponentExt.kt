package io.github.c0nstexpr.owo.dsl.component

import io.wispforest.owo.ui.core.Component
import io.wispforest.owo.ui.core.ParentComponent

inline fun <reified T : Component> ParentComponent.getChild(id: String): T? =
    childById(T::class.java, id)
