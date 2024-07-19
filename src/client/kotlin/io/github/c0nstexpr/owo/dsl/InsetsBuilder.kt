package io.github.c0nstexpr.owo.dsl

import io.wispforest.owo.ui.core.Insets

abstract class InsetsBuilder : DslBuilder<Insets>

fun insets(block: DslBuilder<Insets> = invalidBuilder()) = object : InsetsBuilder() {
    override fun build() = block.build()

    override val canBuild get() = block.canBuild
}
