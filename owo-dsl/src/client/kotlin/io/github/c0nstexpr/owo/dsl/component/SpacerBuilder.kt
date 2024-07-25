package io.github.c0nstexpr.owo.dsl.component

import io.github.c0nstexpr.owo.dsl.DslBuilder.Companion.built
import io.github.c0nstexpr.owo.dsl.nullBuilder
import io.wispforest.owo.ui.component.Components
import io.wispforest.owo.ui.component.SpriteComponent
import io.wispforest.owo.ui.core.Sizing

open class SpacerBuilder : BaseComponentBuilder() {
    var percent = nullBuilder<Int>()

    override fun build() = Components.spacer()!!.also(::applyTo)
}

fun SpacerBuilder.applyTo(component: SpriteComponent) {
    (this as BaseComponentBuilder).applyTo(component)

    percent.built?.let { component.sizing(Sizing.expand(it)) }
}
