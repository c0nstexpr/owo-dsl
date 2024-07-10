package org.c0nstexpr.owo.dsl

import net.minecraft.util.Identifier

class IdentifierBuilder : OwoBuilder<Identifier> {
    var namespace: String? = null
    var path: String? = null

    override fun build() = Identifier.of(namespace!!, path!!)!!

    override val canBuild get() = namespace != null && path != null
}

inline fun identifier(crossinline block: IdentifierBuilder.() -> Unit) =
    IdentifierBuilder().apply(block)
