package io.github.c0nstexpr.owo.dsl

import net.minecraft.util.Identifier

const val VANILLA_NAMESPACE = "minecraft"

open class DefaultIdentifierBuilder : IdentifierBuilder() {
    var namespace = invalidBuilder<String>()
    var path = invalidBuilder<String>()

    override fun build() = Identifier.of(namespace.build(), path.build())!!

    override val canBuild
        get() = namespace.canBuild &&
            path.canBuild &&
            Identifier.isNamespaceValid(namespace.build()) &&
            Identifier.isPathValid(path.build())
}

inline fun defaultIdentifier(crossinline block: DefaultIdentifierBuilder.() -> Unit) =
    DefaultIdentifierBuilder().apply(block)

fun DefaultIdentifierBuilder.vanilla(p: DslBuilder<String> = invalidBuilder()) {
    namespace = dslBuilder { VANILLA_NAMESPACE }
    path = p
}
