package io.github.c0nstexpr.owo.dsl

import com.google.devtools.ksp.processing.CodeGenerator
import com.google.devtools.ksp.processing.KSPLogger
import com.google.devtools.ksp.processing.Resolver
import com.google.devtools.ksp.processing.SymbolProcessor
import com.google.devtools.ksp.symbol.KSAnnotated
import com.google.devtools.ksp.symbol.KSClassDeclaration

class Processor(
    private val env: CodeGenerator,
    private val logger: KSPLogger,
    private val options: Map<String, String>
) : SymbolProcessor {
    override fun process(resolver: Resolver): List<KSAnnotated> {
        val classes = resolver
            .getSymbolsWithAnnotation(OwoDslMarker::class.java.name)
            .filterIsInstance<KSClassDeclaration>()

        logger.info("Found ${classes.count()} classes with @OwoDslMarker annotation")

//        for (clazz in classes) {
//             val className = aclass.simpleName.asString()
//             val methods = aclass.getDeclaredFunctions()
//             ...
//        }
        return emptyList()
    }
}
