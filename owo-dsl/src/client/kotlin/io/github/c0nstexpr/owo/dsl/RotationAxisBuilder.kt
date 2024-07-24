package io.github.c0nstexpr.owo.dsl

import net.minecraft.util.math.RotationAxis

interface RotationAxisBuilder : DslBuilder<RotationAxis>

fun rotationAxis() = invalidBuilder<RotationAxis>()

fun rotationAxis(block: DslBuilder<RotationAxis>): RotationAxisBuilder =
    object : RotationAxisBuilder, DslBuilder<RotationAxis> by block {}

fun rotationAxis(block: () -> RotationAxis?) = rotationAxis(dslBuilder { block() })
