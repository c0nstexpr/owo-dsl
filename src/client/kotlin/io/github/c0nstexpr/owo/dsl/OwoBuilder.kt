package io.github.c0nstexpr.owo.dsl

@OwoDslMarker
@FunctionalInterface
fun interface OwoBuilder<out T : Any> {
    fun build(): T

    val canBuild: Boolean get() = true
}

inline fun <T : Any> OwoBuilder<T>.applyBuild(crossinline block: (T) -> Unit) {
    if (canBuild) block(build())
}

inline val <T : Any> T.owoValue get() = OwoBuilder { this }
