package org.c0nstexpr.owo.dsl

class DelegateBuilder<T>(var builder: OwoBuilder<T>) : OwoBuilder<T> {
    override fun build(): T? = builder.build()
}

typealias IntBuilder = DelegateBuilder<Int>
typealias StringBuilder = DelegateBuilder<String>
