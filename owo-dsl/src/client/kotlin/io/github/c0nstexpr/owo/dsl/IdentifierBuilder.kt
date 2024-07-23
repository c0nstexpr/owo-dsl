package io.github.c0nstexpr.owo.dsl

import net.minecraft.util.Identifier

abstract class IdentifierBuilder : DslBuilder<Identifier> {
    open class Entrance :
        IdentifierBuilder(),
        DslBuilder<Identifier> by invalidBuilder() {
        fun by(block: DslBuilder<Identifier>): IdentifierBuilder =
            object : IdentifierBuilder(), DslBuilder<Identifier> by block {}

        fun by(block: () -> Identifier?) = by(dslBuilder(block))

        fun of(namespace: DslBuilder<String>, path: DslBuilder<String>) = by {
            namespace.applyBuilt { n -> path.applyBuilt { Identifier.of(n, it) } }
        }

        fun ofVanilla(path: DslBuilder<String>) = by { path.applyBuilt(Identifier::ofVanilla) }
    }
}
