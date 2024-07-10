package org.c0nstexpr.owo.dsl

import io.wispforest.owo.ui.core.Size

class SizeBuilder : OwoBuilder<Size> {
    private var initialized = false

    var width: Int = 0
        set(value) {
            field = value
            initialized = true
        }

    var height: Int = 0
        set(value) {
            field = value
            initialized = true
        }

    override fun build() = if (initialized) Size.of(width, height) else null
}
