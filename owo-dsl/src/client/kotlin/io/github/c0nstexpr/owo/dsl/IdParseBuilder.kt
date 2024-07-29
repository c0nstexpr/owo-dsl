package io.github.c0nstexpr.owo.dsl

class IdParseBuilder(var id: String? = null, var delimiter: Char? = null) :
    DslBuilder<Id> by dslBuilder({
        val id0 = id ?: return@dslBuilder null

        Id.trySplitOn(id0, delimiter ?: return@dslBuilder Id.tryParse(id0))
    })
