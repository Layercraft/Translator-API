package io.layercraft.packetlib.packets.v1_19_2.play.clientbound

import io.layercraft.packetlib.packets.*
import io.layercraft.packetlib.serialization.MinecraftProtocolDeserializeInterface
import io.layercraft.packetlib.serialization.MinecraftProtocolSerializeInterface

/**
 * Set Entity Velocity | 0x52 | play | clientbound
 *
 * @property entityId entityId
 * @property velocityX velocityX
 * @property velocityY velocityY
 * @property velocityZ velocityZ
 * @see <a href="https://wiki.vg/Protocol#Set_Entity_Velocity">https://wiki.vg/Protocol#Set_Entity_Velocity</a>
 */

@MinecraftPacket(packetId = 0x52, state = PacketState.PLAY, direction = PacketDirection.CLIENTBOUND)
data class EntityVelocityPacket(
    val entityId: Int, // varint
    val velocityX: Short,
    val velocityY: Short,
    val velocityZ: Short,
) : ClientBoundPacket {

    companion object : PacketSerializer<EntityVelocityPacket> {
        override fun serialize(input: MinecraftProtocolDeserializeInterface<*>): EntityVelocityPacket {
            val entityId = input.readVarInt()
            val velocityX = input.readShort()
            val velocityY = input.readShort()
            val velocityZ = input.readShort()

            return EntityVelocityPacket(entityId, velocityX, velocityY, velocityZ)
        }

        override fun deserialize(output: MinecraftProtocolSerializeInterface<*>, value: EntityVelocityPacket) {
            output.writeVarInt(value.entityId)
            output.writeShort(value.velocityX)
            output.writeShort(value.velocityY)
            output.writeShort(value.velocityZ)
        }
    }
}