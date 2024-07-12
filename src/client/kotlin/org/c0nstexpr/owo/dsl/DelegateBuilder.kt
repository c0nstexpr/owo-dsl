package org.c0nstexpr.owo.dsl

interface DelegateBuilder<T> : OwoBuilder<T> {
    val value: OwoBuilder<T>

    override fun build() = value.build()

    override val canBuild get() = value.canBuild
}

fun <T> delegateBuilder(value: OwoBuilder<T> = invalidBuilder()) = object : DelegateBuilder<T> {
    override val value = value
}
