package io.github.c0nstexpr.owo.dsl.component

import io.github.c0nstexpr.owo.dsl.DslBuilder
import io.github.c0nstexpr.owo.dsl.DslBuilder.Companion.built
import io.github.c0nstexpr.owo.dsl.nullBuilder
import io.wispforest.owo.ui.component.Components
import net.minecraft.command.argument.BlockArgumentParser

open class BlockComponentBuilder(
    var blockResult: DslBuilder<BlockArgumentParser.BlockResult> = nullBuilder()
) : BlockComponentProvider({ blockResult.built?.run { Components.block(blockState(), nbt()) } })
