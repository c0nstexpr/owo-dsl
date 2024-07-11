package org.c0nstexpr.owo.dsl

interface DelegateBuilder<T> {
    var value: OwoBuilder<T>

    fun build() = value.build()

    fun canBuild() = value.canBuild
}
