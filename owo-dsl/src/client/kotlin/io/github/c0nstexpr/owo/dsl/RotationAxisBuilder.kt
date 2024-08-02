package io.github.c0nstexpr.owo.dsl

import net.minecraft.util.math.RotationAxis
import org.joml.Vector3f

interface RotationAxisBuilder : DslBuilder<RotationAxis> {
    companion object {
        fun DslBuilder<Vector3f>.toRotationAxis() = object :
            DslBuilder<RotationAxis> by dslBuilder({ value?.let(RotationAxis::of) }) {}
    }
}
