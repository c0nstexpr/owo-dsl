package org.c0nstexpr.owo.dsl

@OwoDslMarker
@FunctionalInterface
fun interface OwoBuilder<out T> {
    fun build(): T

    val canBuild: Boolean get() = true
}

inline fun <T> OwoBuilder<T>.applyBuild(crossinline block: (T) -> Unit) {
    if (canBuild) block(build())
}

inline val <T> T.owoValue get() = OwoBuilder { this }
