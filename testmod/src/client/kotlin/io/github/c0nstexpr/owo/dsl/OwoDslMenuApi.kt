package io.github.c0nstexpr.owo.dsl

import com.terraformersmc.modmenu.api.ConfigScreenFactory
import com.terraformersmc.modmenu.api.ModMenuApi

class OwoDslMenuApi : ModMenuApi {
    override fun getModConfigScreenFactory() = ConfigScreenFactory { parent -> TestScreen(parent) }
}
