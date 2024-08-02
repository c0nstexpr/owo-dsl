package io.github.c0nstexpr.owo.dsl.component

import io.github.c0nstexpr.owo.dsl.DslBuilder
import io.github.c0nstexpr.owo.dsl.nullBuilder
import io.wispforest.owo.ui.component.BlockComponent
import io.wispforest.owo.ui.component.Components
import net.minecraft.block.BlockState
import net.minecraft.block.entity.BlockEntity

open class BlockComponentBuilder(
    var state: DslBuilder<BlockState> = nullBuilder(),
    var entity: DslBuilder<BlockEntity> = nullBuilder()
) : BlockComponentBuilderBase() {
    override var value: BlockComponent? = null
        get() {
            if (field == null) field =
                Components.block(state.value ?: return null, entity.value).apply(::configure)

            return field
        }
}
