package io.layercraft.translator.packets.play.server

import io.ktor.utils.io.core.*
import io.layercraft.translator.data.entity.EntityAnimationType
import io.layercraft.translator.packets.*
import io.layercraft.translator.utils.mc


/**
 * Entity Animation (clientbound) | 0x03 | play | client-bound
 *
 * Sent whenever an entity should change animation.
 * @property entityId VarInt - Player ID.
 * @property animation Unsigned Byte - Animation ID (see [EntityAnimationType]).
 * @see <a href="https://wiki.vg/Protocol#Entity_Animation_.28clientbound.29">Entity Animation (clientbound)</a>
 */
@MinecraftPacket(0x03, PacketState.PLAY, PacketDirection.CLIENTBOUND)
data class EntityAnimation(
    val entityId: Int,
    val animation: EntityAnimationType
) : ClientBoundPacket {
    companion object : PacketSerializer<EntityAnimation> {
        override fun serialize(input: Input): EntityAnimation {
            val entityId = input.mc.readVarInt()
            val animation = EntityAnimationType.values()[input.mc.readUByte().toInt()]

            return EntityAnimation(entityId, animation)
        }

        override fun deserialize(output: Output, value: EntityAnimation) {
            output.mc.writeVarInt(value.entityId)
            output.mc.writeUByte(value.animation.id.toUByte())
        }
    }
}
