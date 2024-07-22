package io.github.c0nstexpr.owo.dsl

@OwoDslMarker
interface DslBuilder<out T : Any> {
    val value: T?

    fun build()
}

fun <T : Any> dslBuilder(buildBlock: () -> T?): DslBuilder<T> = object : DslBuilder<T> {
    private var _value: T? = null

    override val value get() = _value

    override fun build() {
        _value = buildBlock()
    }
}

inline fun <T : Any, R> DslBuilder<T>.applyBuild(crossinline block: (T) -> R): R? {
    build()
    return value?.let(block)
}

inline val <T : Any> T.owoValue get() = dslBuilder { this }
