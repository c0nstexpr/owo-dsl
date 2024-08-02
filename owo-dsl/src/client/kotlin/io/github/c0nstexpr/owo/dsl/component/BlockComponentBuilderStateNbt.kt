package io.github.c0nstexpr.owo.dsl.component

import io.github.c0nstexpr.owo.dsl.DslBuilder
import io.github.c0nstexpr.owo.dsl.dslBuilder
import io.github.c0nstexpr.owo.dsl.nullBuilder
import io.wispforest.owo.ui.component.BlockComponent
import io.wispforest.owo.ui.component.Components
import net.minecraft.block.BlockState
import net.minecraft.command.argument.BlockArgumentParser
import net.minecraft.nbt.NbtCompound

open class BlockComponentBuilderStateNbt(
    var state: DslBuilder<BlockState> = nullBuilder(),
    var nbt: DslBuilder<NbtCompound> = nullBuilder()
) : BlockComponentBuilderBase() {
    fun blockResult(block: DslBuilder<BlockArgumentParser.BlockResult>) {
        state = dslBuilder { block.value?.blockState }
        nbt = dslBuilder { block.value?.nbt }
    }

    override var value: BlockComponent? = null
        get() {
            if (field == null) field =
                Components.block(state.value ?: return null, nbt.value).apply(::configure)

            return field
        }
        protected set
}
