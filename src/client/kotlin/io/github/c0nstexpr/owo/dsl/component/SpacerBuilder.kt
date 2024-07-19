package io.github.c0nstexpr.owo.dsl.component

import io.github.c0nstexpr.owo.dsl.applyBuild
import io.github.c0nstexpr.owo.dsl.invalidBuilder
import io.wispforest.owo.ui.component.Components
import io.wispforest.owo.ui.component.SpriteComponent
import io.wispforest.owo.ui.core.Sizing

open class SpacerBuilder : BaseComponentBuilder() {
    var percent = invalidBuilder<Int>()

    override fun build() = Components.spacer()!!.apply(::applyTo)

    override val canBuild get() = true
}

fun SpacerBuilder.applyTo(component: SpriteComponent) {
    (this as BaseComponentBuilder).applyTo(component)

    percent.applyBuild { component.sizing(Sizing.expand(it)) }
}
