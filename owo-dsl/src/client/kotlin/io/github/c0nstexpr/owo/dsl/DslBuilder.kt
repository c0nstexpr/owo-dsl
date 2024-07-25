package io.github.c0nstexpr.owo.dsl

@OwoDslMarker
interface DslBuilder<out T : Any> {
    val cached: T?

    fun build() = Unit

    companion object {
        inline val <T : Any> DslBuilder<T>.built: T?
            get() {
                build()
                return cached
            }

        inline val <T : Any> T?.owoValue: DslBuilder<T>
            get() = object : DslBuilder<T> {
                override val cached get() = this@owoValue

                override fun build() = Unit
            }
    }
}

fun <T : Any> dslBuilder(buildBlock: () -> T?): DslBuilder<T> = object : DslBuilder<T> {
    override var cached: T? = null
        private set

    override fun build() {
        if (cached == null) cached = buildBlock()
    }
}
