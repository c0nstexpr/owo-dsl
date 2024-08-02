package io.github.c0nstexpr.owo.dsl.component

import io.github.c0nstexpr.owo.dsl.DslBuilder
import io.github.c0nstexpr.owo.dsl.DslBuilder.Companion.map
import io.github.c0nstexpr.owo.dsl.GridChild
import io.github.c0nstexpr.owo.dsl.nullBuilder
import kotlin.properties.PropertyDelegateProvider
import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

interface GridChildrenBuilder : ComponentBuilder {
    var children: List<DslBuilder<GridChild>>

    var rows: Int

    var columns: Int

    class ChildProperty : ReadWriteProperty<GridChildrenBuilder, DslBuilder<GridChild>> {
        private var child: DslBuilder<GridChild>? = null

        override fun getValue(thisRef: GridChildrenBuilder, property: KProperty<*>) = child.let {
            if (it == null) {
                val default = object : DslBuilder<GridChild> by nullBuilder() {}
                setValue(thisRef, property, default)
                default
            } else it
        }

        override fun setValue(
            thisRef: GridChildrenBuilder,
            property: KProperty<*>,
            value: DslBuilder<GridChild>
        ) {
            thisRef.children = thisRef.children.toMutableList().apply {
                removeIf { it == child }

                var b = value

                (b as? ComponentBuilder).also {
                    if (it == null) b = b.map { it.apply { child.id(property.name) } }
                    else it.apply { if (id == null) id = property.name }
                }

                child = b
                add(b)
            }
        }
    }

    companion object {
        fun DslBuilder<GridChild>.child() =
            PropertyDelegateProvider { ref: GridChildrenBuilder, prop ->
                ChildProperty(ref, prop, this@child)
            }
    }
}

fun gridChildrenBuilder(): GridChildrenBuilder =
    object : GridChildrenBuilder, ComponentBuilder by componentBuilder() {
        override var children = listOf<DslBuilder<GridChild>>()

        override var rows = 0

        override var columns = 0
    }
