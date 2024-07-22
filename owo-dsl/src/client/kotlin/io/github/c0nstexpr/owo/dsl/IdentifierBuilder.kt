package io.github.c0nstexpr.owo.dsl

import net.minecraft.util.Identifier

abstract class IdentifierBuilder : DslBuilder<Identifier>

fun identifier(block: DslBuilder<Identifier> = invalidBuilder()) = object : IdentifierBuilder() {
    override fun build() = block.build()

    override val canBuild get() = block.canBuild
}

inline fun identifier(crossinline block: () -> Identifier) = identifier(dslBuilder { block() })
