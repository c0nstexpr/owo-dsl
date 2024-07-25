package io.github.c0nstexpr.owo.dsl

import io.github.c0nstexpr.owo.dsl.DslBuilder.Companion.built
import net.minecraft.util.Identifier

abstract class IdentifierBuilder : DslBuilder<Identifier> {
    companion object {
        fun DslBuilder<String>.toIdentifier() = SplitOn(this)
    }

    class Of(
        var namespace: DslBuilder<String> = nullBuilder(),
        var path: DslBuilder<String> = nullBuilder()
    ) : IdentifierBuilder(),
        DslBuilder<Identifier> by dslBuilder({
            Identifier.tryParse(
                namespace.built ?: return@dslBuilder null,
                path.built ?: return@dslBuilder null
            )
        })

    class OfVanilla(var path: DslBuilder<String> = nullBuilder()) :
        IdentifierBuilder(),
        DslBuilder<Identifier> by dslBuilder({
            Identifier.ofVanilla(path.built ?: return@dslBuilder null)
        })

    class SplitOn(
        var id: DslBuilder<String> = nullBuilder(),
        var delimiter: DslBuilder<Char> = nullBuilder()
    ) : IdentifierBuilder(),
        DslBuilder<Identifier> by dslBuilder({

            id.built?.let {
                val d = delimiter.built ?: return@dslBuilder Identifier.tryParse(it)

                Identifier.trySplitOn(it, d)
            }
        })
}
