package org.c0nstexpr.owo.dsl

import net.minecraft.util.Identifier

abstract class IdentifierBuilder : OwoBuilder<Identifier>

fun identifier(block: OwoBuilder<Identifier> = invalidBuilder()) = object : IdentifierBuilder() {
    override fun build() = block.build()

    override val canBuild get() = block.canBuild
}
