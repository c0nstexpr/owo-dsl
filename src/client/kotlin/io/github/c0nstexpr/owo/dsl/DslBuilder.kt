package io.github.c0nstexpr.owo.dsl

@OwoDslMarker
@FunctionalInterface
fun interface DslBuilder<out T : Any> {
    fun build(): T

    val canBuild: Boolean get() = true
}

inline fun <T : Any> DslBuilder<T>.applyBuild(crossinline block: (T) -> Unit) {
    if (canBuild) block(build())
}

inline fun <T : Any> dslBuilder(
    crossinline canBuildBlock: () -> Boolean = { true },
    crossinline buildBlock: () -> T
) = object : DslBuilder<T> {
    override fun build() = buildBlock()

    override val canBuild get() = canBuildBlock()
}

inline val <T : Any> T.owoValue get() = dslBuilder { this }
