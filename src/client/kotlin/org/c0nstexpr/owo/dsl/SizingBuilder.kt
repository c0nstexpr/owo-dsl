package org.c0nstexpr.owo.dsl

import io.wispforest.owo.ui.core.Sizing

abstract class SizingBuilder : OwoBuilder<Sizing>

fun sizing(block: OwoBuilder<Sizing> = invalidBuilder()) = object : SizingBuilder() {
    override fun build() = block.build()

    override val canBuild get() = block.canBuild
}
