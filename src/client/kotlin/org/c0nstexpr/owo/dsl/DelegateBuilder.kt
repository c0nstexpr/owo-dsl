package org.c0nstexpr.owo.dsl

interface DelegateBuilder<T> : OwoBuilder<T> {
    var value: OwoBuilder<T>

    override fun build() = value.build()

    override val canBuild get() = value.canBuild
}

fun delegateBuilder(value: OwoBuilder<String>) = object : DelegateBuilder<String> {
    override var value = value
}
