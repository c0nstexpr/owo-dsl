package io.github.c0nstexpr.owo.dsl

open class InvalidBuilderException : IllegalStateException("Invalid builder")

object InvalidBuilder : DslBuilder<Nothing> {
    override fun build() = throw InvalidBuilderException()

    override val canBuild get() = false
}

fun <T : Any> invalidBuilder(): DslBuilder<T> = InvalidBuilder
