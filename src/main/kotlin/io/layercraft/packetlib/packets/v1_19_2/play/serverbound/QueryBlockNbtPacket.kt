package io.layercraft.packetlib.packets.v1_19_2.play.serverbound

import io.layercraft.packetlib.packets.*
import io.layercraft.packetlib.serialization.MinecraftProtocolDeserializeInterface
import io.layercraft.packetlib.serialization.MinecraftProtocolSerializeInterface
import io.layercraft.packetlib.types.Position

/**
 * Query Block Entity Tag | 0x01 | play | serverbound
 *
 * @property transactionId transactionId
 * @property location location
 * @see <a href="https://wiki.vg/Protocol#Query_Block_Entity_Tag">https://wiki.vg/Protocol#Query_Block_Entity_Tag</a>
 */

@MinecraftPacket(packetId = 0x01, state = PacketState.PLAY, direction = PacketDirection.SERVERBOUND)
data class QueryBlockNbtPacket(
    val transactionId: Int, // varint
    val location: Position,
) : ServerBoundPacket {

    companion object : PacketSerializer<QueryBlockNbtPacket> {
        override fun serialize(input: MinecraftProtocolDeserializeInterface<*>): QueryBlockNbtPacket {
            val transactionId = input.readVarInt()
            val location = input.readPosition()

            return QueryBlockNbtPacket(transactionId, location)
        }

        override fun deserialize(output: MinecraftProtocolSerializeInterface<*>, value: QueryBlockNbtPacket) {
            output.writeVarInt(value.transactionId)
            output.writePosition(value.location)
        }
    }
}