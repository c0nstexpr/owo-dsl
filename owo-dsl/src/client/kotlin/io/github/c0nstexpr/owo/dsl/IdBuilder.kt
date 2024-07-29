package io.github.c0nstexpr.owo.dsl

import net.minecraft.util.Identifier

typealias Id = Identifier

open class IdBuilder(var namespace: String? = null, var path: String? = null) :
    DslBuilder<Id> by dslBuilder({
        Id.tryParse(
            namespace ?: return@dslBuilder Id.tryParse(path),
            path ?: return@dslBuilder null
        )
    }) {
    companion object {
        fun String?.toIdentifier() = IdParseBuilder(this)
    }
}
