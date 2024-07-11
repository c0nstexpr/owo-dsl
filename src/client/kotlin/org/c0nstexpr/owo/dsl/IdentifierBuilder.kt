package org.c0nstexpr.owo.dsl

import net.minecraft.util.Identifier

const val VANILLA_NAMESPACE = "minecraft"

open class IdentifierBuilder : OwoBuilder<Identifier> {
    var namespace = invalidBuilder<String>()
    var path = invalidBuilder<String>()

    override fun build() = Identifier.of(namespace.build(), path.build())!!

    override val canBuild get() = namespace.canBuild && path.canBuild
}

fun IdentifierBuilder.vanilla(p: OwoBuilder<String>) {
    namespace = OwoBuilder { VANILLA_NAMESPACE }
    path = p
}

fun IdentifierBuilder.split(id: String, delimiter: Char = ':') {
    if (id.isEmpty()) return

    when (val index = id.indexOf(delimiter)) {
        -1 -> {
            namespace = OwoBuilder { VANILLA_NAMESPACE }
            path = OwoBuilder { id }
        }

        0 -> {
            namespace = OwoBuilder { VANILLA_NAMESPACE }
            path = OwoBuilder { id.substring(1) }
        }

        in 1..<id.length - 1 -> {
            namespace = OwoBuilder { id.substring(0, index) }
            path = OwoBuilder { id.substring(index + 1) }
        }
    }
}
