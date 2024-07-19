package io.github.c0nstexpr.owo.dsl

import net.minecraft.util.Identifier

const val VANILLA_NAMESPACE = "minecraft"

open class IdentifierStringBuilder : IdentifierBuilder() {
    var namespace = invalidBuilder<String>()
    var path = invalidBuilder<String>()

    override fun build() = Identifier.of(namespace.build(), path.build())!!

    override val canBuild
        get() = namespace.canBuild &&
            path.canBuild &&
            Identifier.isNamespaceValid(namespace.build()) &&
            Identifier.isPathValid(path.build())
}

inline fun identifierString(crossinline block: IdentifierStringBuilder.() -> Unit) =
    IdentifierStringBuilder().apply(block)

fun IdentifierStringBuilder.vanilla(p: DslBuilder<String> = invalidBuilder()) {
    namespace = DslBuilder { VANILLA_NAMESPACE }
    path = p
}
