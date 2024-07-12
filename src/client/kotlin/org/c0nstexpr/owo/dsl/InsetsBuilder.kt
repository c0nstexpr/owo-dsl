package org.c0nstexpr.owo.dsl

import io.wispforest.owo.ui.core.Insets

abstract class InsetsBuilder : OwoBuilder<Insets>

fun insets(block: OwoBuilder<Insets> = invalidBuilder()) = object : InsetsBuilder() {
    override fun build() = block.build()

    override val canBuild get() = block.canBuild
}
