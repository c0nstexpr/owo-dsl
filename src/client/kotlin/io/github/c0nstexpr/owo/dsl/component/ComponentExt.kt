package io.github.c0nstexpr.owo.dsl.component

import io.wispforest.owo.ui.container.FlowLayout
import io.wispforest.owo.ui.container.GridLayout
import io.wispforest.owo.ui.container.StackLayout
import io.wispforest.owo.ui.core.Component

inline fun <reified T : Component> FlowLayout.getChild(id: String): T? =
    childById(T::class.java, id)

inline fun <reified T : Component> GridLayout.getChild(id: String): T? =
    childById(T::class.java, id)

inline fun <reified T : Component> StackLayout.getChild(id: String): T? =
    childById(T::class.java, id)
