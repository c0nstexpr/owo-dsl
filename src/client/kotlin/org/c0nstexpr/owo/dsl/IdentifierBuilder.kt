package org.c0nstexpr.owo.dsl

import net.minecraft.util.Identifier

open class IdentifierBuilder : OwoBuilder<Identifier> {
    var namespace: String? = null
    var path: String = ""

    override fun build() = if (namespace == null) null else
        Identifier.of(namespace, path)!!
}
