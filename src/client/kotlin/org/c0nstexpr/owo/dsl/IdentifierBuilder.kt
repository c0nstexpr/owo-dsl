package org.c0nstexpr.owo.dsl

import net.minecraft.util.Identifier

open class IdentifierBuilder : DelegateBuilder<Identifier> {
    var namespace: String? = null
    var path: String? = null

    override fun build() = Identifier.of(namespace!!, path!!)!!

    override val canBuild get() = namespace != null && path != null
}

inline fun identifier(namespace: OwoBuilder<String>, path: OwoBuilder<String>) = builder {
    object : IdentifierBuilder() {
        init {
            this.namespace = namespace.build()
            this.path = path.build()
        }
    }
}
