package org.c0nstexpr.owo.dsl

@OwoDslMarker
interface OwoBuilder<T> {
    fun build(): T

    val canBuild: Boolean
}

fun <T> invalidBuilder() = object : OwoBuilder<T> {
    override fun build() = throw IllegalStateException("Invalid builder")

    override val canBuild get() = false
}

inline fun <T> builder(crossinline block: () -> T) = object : OwoBuilder<T> {
    override fun build() = block()

    override val canBuild get() = true
}
