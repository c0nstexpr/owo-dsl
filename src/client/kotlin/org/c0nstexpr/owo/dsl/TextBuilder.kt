package org.c0nstexpr.owo.dsl

import net.minecraft.text.Text

fun interface TextBuilder : OwoBuilder<Text>

fun textOf(block: () -> String) = TextBuilder { Text.of(block()) }
