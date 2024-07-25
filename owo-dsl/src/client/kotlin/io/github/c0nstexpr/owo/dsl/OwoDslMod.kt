package io.github.c0nstexpr.owo.dsl

import net.minecraft.client.MinecraftClient
import net.minecraft.client.font.TextRenderer

fun init() = Unit

val mcClient = MinecraftClient.getInstance()!!

val textRenderer: TextRenderer get() = mcClient.textRenderer

val atlasManager = mcClient.guiAtlasManager!!
