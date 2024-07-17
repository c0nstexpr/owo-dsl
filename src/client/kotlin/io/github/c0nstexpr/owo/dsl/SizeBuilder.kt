package io.github.c0nstexpr.owo.dsl

import io.wispforest.owo.ui.core.Size

abstract class SizeBuilder : OwoBuilder<Size>

fun size(block: OwoBuilder<Size> = invalidBuilder()) = object : SizeBuilder() {
    override fun build() = block.build()

    override val canBuild get() = block.canBuild
}
