package io.github.c0nstexpr.owo.dsl

import io.github.c0nstexpr.owo.dsl.DslBuilder.Companion.built
import net.minecraft.block.Block
import net.minecraft.client.util.math.Vector2f
import net.minecraft.entity.Entity
import net.minecraft.entity.EntityAttachmentType
import net.minecraft.entity.EntityType
import net.minecraft.entity.SpawnGroup
import net.minecraft.registry.Registries
import net.minecraft.resource.featuretoggle.FeatureFlag
import net.minecraft.util.math.Vec3d
import net.minecraft.world.World

open class EntityTypeBuilder(
    var factory: (EntityType<*>, World) -> Entity? = { _, _ -> null },
    var spawn: SpawnGroup? = null,
    var dimensions: DslBuilder<Vector2f> = nullBuilder(),
    var spawnBoxScale: Float? = null,
    var eyeHeight: Float? = null,
    var attachments: Map<EntityAttachmentType, DslBuilder<Vec3d>> = mapOf(),
    var disableSummon: Boolean = false,
    var disableSaving: Boolean = false,
    var makeFireImmune: Boolean = false,
    var allowSpawningInside: Set<DslBuilder<Block>> = setOf(),
    var spawnableFarFromPlayer: Boolean = false,
    var maxTrackingRange: Int? = 0,
    var trackingTickInterval: Int? = 0,
    var features: List<DslBuilder<FeatureFlag>> = listOf()
) : DslBuilder<EntityType<*>> by dslBuilder({
        EntityType.Builder.create(
            { t, w -> factory(t, w) },
            spawn ?: return@dslBuilder null
        ).run {
            dimensions.built?.let { dimensions(it.x, it.y) }
            spawnBoxScale?.let(::spawnBoxScale)
            eyeHeight?.let(::eyeHeight)

            attachments.run inner@{
                mapValues { it.value.built ?: return@inner }.toMap()
                    .forEach { (type, vec) -> attachment(type, vec) }
            }

            if (disableSummon) disableSummon()
            if (disableSaving) disableSaving()
            if (makeFireImmune) makeFireImmune()

            allowSpawningInside.run inner@{
                allowSpawningInside(*map { it.built ?: return@inner }.toTypedArray())
            }

            if (spawnableFarFromPlayer) spawnableFarFromPlayer()
            maxTrackingRange?.let(::maxTrackingRange)
            trackingTickInterval?.let(::trackingTickInterval)

            features.run inner@{
                requires(*map { it.built ?: return@inner }.toTypedArray())
            }

            build()
        }
    }) {
    companion object {
        fun DslBuilder<Id>.toEntityType() = object :
            DslBuilder<EntityType<*>> by dslBuilder({ Registries.ENTITY_TYPE.get(built) }) {}
    }
}
