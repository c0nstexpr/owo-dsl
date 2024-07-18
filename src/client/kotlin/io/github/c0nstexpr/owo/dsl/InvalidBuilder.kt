package io.github.c0nstexpr.owo.dsl

open class InvalidBuilderException : IllegalStateException("Invalid builder")

object InvalidBuilder : OwoBuilder<Nothing> {
    override fun build() = throw InvalidBuilderException()

    override val canBuild get() = false
}

fun <T : Any> invalidBuilder(): OwoBuilder<T> = InvalidBuilder
