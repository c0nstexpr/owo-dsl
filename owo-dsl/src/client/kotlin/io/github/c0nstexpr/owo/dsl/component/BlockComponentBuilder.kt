package io.github.c0nstexpr.owo.dsl.component

import io.github.c0nstexpr.owo.dsl.DslBuilder.Companion.built
import io.github.c0nstexpr.owo.dsl.nullBuilder
import io.wispforest.owo.ui.component.Components
import net.minecraft.command.argument.BlockArgumentParser.BlockResult

open class BlockComponentBuilder : BaseComponentBuilder() {
    var blockResult = nullBuilder<BlockResult>()

    override fun build() =
        blockResult.built?.run { Components.block(blockState(), nbt()) }?.also(::applyTo)
}
