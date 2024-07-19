package io.github.c0nstexpr.owo.dsl

import net.minecraft.util.math.RotationAxis

@FunctionalInterface
fun interface RotationAxisBuilder : DslBuilder<RotationAxis>

fun rotationAxis(block: DslBuilder<RotationAxis>) = object : RotationAxisBuilder {
    override fun build() = block.build()

    override val canBuild get() = block.canBuild
}
