package io.github.c0nstexpr.owo.dsl

@OwoDslMarker
interface DslBuilder<out T : Any> : Lazy<T?> {
    fun clear() = Unit

    override fun isInitialized() = value != null

    companion object {
        inline val <T : Any> T?.owoValue: DslBuilder<T>
            get() = if (this == null) nullBuilder() else object : DslBuilder<T> {
                override val value get() = this@owoValue
            }

        inline val <T : Any> DslBuilder<T>.rebuilt: T?
            get() {
                clear()
                return value
            }

        fun <T : Any, R : Any> DslBuilder<T>.map(block: (T) -> R) = object : DslBuilder<R> {
            override var value: R? = null
                get() {
                    if (field == null) field = this@map.value?.let(block)
                    return field
                }

            override fun clear() {
                this@map.clear()
                value = null
            }
        }
    }
}

fun <T : Any> dslBuilder(buildBlock: () -> T?) = object : DslBuilder<T> {
    override var value: T? = null
        get() {
            if (field == null) field = buildBlock()
            return field
        }

    override fun clear() {
        value = null
    }
}
