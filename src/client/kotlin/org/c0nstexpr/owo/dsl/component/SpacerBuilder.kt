package org.c0nstexpr.owo.dsl.component

import io.wispforest.owo.ui.component.Components
import io.wispforest.owo.ui.component.SpriteComponent
import io.wispforest.owo.ui.core.Sizing
import org.c0nstexpr.owo.dsl.applyBuild
import org.c0nstexpr.owo.dsl.invalidBuilder

open class SpacerBuilder : BaseComponentBuilder() {
    var percent = invalidBuilder<Int>()

    override fun build() = Components.spacer()!!.apply(::applyTo)
}

fun SpacerBuilder.applyTo(component: SpriteComponent) {
    (this as BaseComponentBuilder).applyTo(component)

    percent.applyBuild { component.sizing(Sizing.expand(it)) }
}

inline fun spacer(crossinline block: SpacerBuilder.() -> Unit) = SpacerBuilder().apply(block)
