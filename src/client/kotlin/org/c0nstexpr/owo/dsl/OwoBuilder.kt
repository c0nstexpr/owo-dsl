package org.c0nstexpr.owo.dsl

@OwoDslMarker
fun interface OwoBuilder<T> {
    fun build(): T

    val canBuild: Boolean get() = true
}

fun <T> invalidBuilder() = object : OwoBuilder<T> {
    override fun build() = throw IllegalStateException("Invalid builder")

    override val canBuild get() = false
}
