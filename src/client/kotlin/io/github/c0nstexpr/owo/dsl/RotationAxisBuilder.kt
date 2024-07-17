package io.github.c0nstexpr.owo.dsl

import net.minecraft.util.math.RotationAxis

@FunctionalInterface
fun interface RotationAxisBuilder : OwoBuilder<RotationAxis>

fun rotationAxis(block: OwoBuilder<RotationAxis>) = object : RotationAxisBuilder {
    override fun build() = block.build()

    override val canBuild get() = block.canBuild
}
