package io.github.c0nstexpr.owo.dsl

object NullBuilder : DslBuilder<Nothing> {
    override val cached get() = null
}

fun <T : Any> nullBuilder(): DslBuilder<T> = NullBuilder
