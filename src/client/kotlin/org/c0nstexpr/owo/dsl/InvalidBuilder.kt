package org.c0nstexpr.owo.dsl

import kotlin.reflect.KClass

@PublishedApi
internal val invalidBuilderMap = mutableMapOf<KClass<*>, OwoBuilder<*>>()

open class InvalidBuilderException : IllegalStateException("Invalid builder")

@Suppress("UNCHECKED_CAST")
inline fun <reified T> invalidBuilder() = invalidBuilderMap.getOrPut(T::class) {
    object : OwoBuilder<T> {
        override fun build() = throw InvalidBuilderException()

        override val canBuild get() = false
    }
} as OwoBuilder<T>
