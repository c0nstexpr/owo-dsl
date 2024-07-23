package io.github.c0nstexpr.owo.dsl

import io.wispforest.owo.ui.core.Positioning

open class DefaultPositioningBuilder(
    var x: DslBuilder<Int> = invalidBuilder(),
    var y: DslBuilder<Int> = invalidBuilder(),
    var type: DslBuilder<Positioning.Type> = invalidBuilder()
) : PositioningBuilder(),
    DslBuilder<Positioning> by positioning(
        {
            x.applyBuilt { x ->
                y.applyBuilt { y ->
                    type.applyBuilt {
                        when (it) {
                            Positioning.Type.LAYOUT -> Positioning.layout().withX(x).withY(y)
                            Positioning.Type.ABSOLUTE -> Positioning.absolute(x, y)
                            Positioning.Type.RELATIVE -> Positioning.relative(x, y)
                            Positioning.Type.ACROSS -> Positioning.across(x, y)
                        }
                    }
                }
            }
        }
    )

inline fun defaultPositioning(crossinline block: DefaultPositioningBuilder.() -> Unit) =
    DefaultPositioningBuilder().apply(block)
