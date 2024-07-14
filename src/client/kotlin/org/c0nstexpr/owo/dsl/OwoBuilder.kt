package org.c0nstexpr.owo.dsl

import kotlin.reflect.KClass

@OwoDslMarker
fun interface OwoBuilder<out T> {
    fun build(): T

    val canBuild: Boolean get() = true
}

@PublishedApi
internal val invalidBuilderMap = mutableMapOf<KClass<*>, OwoBuilder<*>>()

@Suppress("UNCHECKED_CAST")
inline fun <reified T> invalidBuilder() = invalidBuilderMap.getOrPut(T::class) {
    object : OwoBuilder<T> {
        override fun build() = throw IllegalStateException("Invalid builder")

        override val canBuild get() = false
    }
} as OwoBuilder<T>

inline fun <T> OwoBuilder<T>.applyBuild(crossinline block: (T) -> Unit) {
    if (canBuild) block(build())
}
