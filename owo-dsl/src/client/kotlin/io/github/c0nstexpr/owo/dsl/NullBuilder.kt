package io.github.c0nstexpr.owo.dsl

object NullBuilder : DslBuilder<Nothing> {
    override val cached get() = null

    override fun build() = Unit
}

fun <T : Any> nullBuilder(): DslBuilder<T> = NullBuilder
