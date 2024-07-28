package io.github.c0nstexpr.owo.dsl

import io.github.c0nstexpr.owo.dsl.DslBuilder.Companion.built
import net.minecraft.util.math.RotationAxis
import org.joml.Vector3f

interface RotationAxisBuilder : DslBuilder<RotationAxis> {
    companion object {
        fun DslBuilder<Vector3f>.toRotationAxis(): RotationAxisBuilder = object :
            RotationAxisBuilder,
            DslBuilder<RotationAxis> by dslBuilder({ built?.let(RotationAxis::of) }) {}
    }
}
