package io.github.c0nstexpr.owo.dsl

open class VanillaIdBuilder(var vanillaPath: String? = null) :
    DslBuilder<Id> by
    dslBuilder({ Id.ofVanilla(vanillaPath ?: return@dslBuilder null) })
