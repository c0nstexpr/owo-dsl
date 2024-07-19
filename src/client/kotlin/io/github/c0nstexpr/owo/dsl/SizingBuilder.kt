package io.github.c0nstexpr.owo.dsl

import io.wispforest.owo.ui.core.Sizing

abstract class SizingBuilder : DslBuilder<Sizing>

fun sizing(block: DslBuilder<Sizing> = invalidBuilder()) = object : SizingBuilder() {
    override fun build() = block.build()

    override val canBuild get() = block.canBuild
}
