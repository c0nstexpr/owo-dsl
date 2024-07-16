package org.c0nstexpr.owo.dsl

open class InvalidBuilderException : IllegalStateException("Invalid builder")

object InvalidBuilder : OwoBuilder<Nothing> {
    override fun build() = throw InvalidBuilderException()

    override val canBuild get() = false
}

fun <T> invalidBuilder(): OwoBuilder<T> = InvalidBuilder
