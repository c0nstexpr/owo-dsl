package io.github.c0nstexpr.owo.dsl

import com.google.devtools.ksp.processing.SymbolProcessorEnvironment
import com.google.devtools.ksp.processing.SymbolProcessorProvider

class ProcessorProvider : SymbolProcessorProvider {
    override fun create(environment: SymbolProcessorEnvironment) = environment.run {
        Processor(codeGenerator, logger, options)
    }
}
