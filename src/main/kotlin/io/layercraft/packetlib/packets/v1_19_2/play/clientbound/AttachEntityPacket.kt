package io.layercraft.packetlib.packets.v1_19_2.play.clientbound

import io.layercraft.packetlib.packets.*
import io.layercraft.packetlib.serialization.MinecraftProtocolDeserializeInterface
import io.layercraft.packetlib.serialization.MinecraftProtocolSerializeInterface

/**
 * Link Entities | 0x51 | play | clientbound
 *
 * @property entityId entityId
 * @property vehicleId vehicleId
 * @see <a href="https://wiki.vg/Protocol#Link_Entities">https://wiki.vg/Protocol#Link_Entities</a>
 */

@MinecraftPacket(packetId = 0x51, state = PacketState.PLAY, direction = PacketDirection.CLIENTBOUND)
data class AttachEntityPacket(
    val entityId: Int,
    val vehicleId: Int,
) : ClientBoundPacket {

    companion object : PacketSerializer<AttachEntityPacket> {
        override fun serialize(input: MinecraftProtocolDeserializeInterface<*>): AttachEntityPacket {
            val entityId = input.readInt()
            val vehicleId = input.readInt()

            return AttachEntityPacket(entityId, vehicleId)
        }

        override fun deserialize(output: MinecraftProtocolSerializeInterface<*>, value: AttachEntityPacket) {
            output.writeInt(value.entityId)
            output.writeInt(value.vehicleId)
        }
    }
}