package io.layercraft.packetlib.packets.v1_19_2.play.serverbound

import io.layercraft.packetlib.packets.*
import io.layercraft.packetlib.serialization.MinecraftProtocolDeserializeInterface
import io.layercraft.packetlib.serialization.MinecraftProtocolSerializeInterface

/**
 * Use Item | 0x32 | play | serverbound
 *
 * @property hand hand
 * @property sequence sequence
 * @see <a href="https://wiki.vg/Protocol#Use_Item">https://wiki.vg/Protocol#Use_Item</a>
 */

@MinecraftPacket(packetId = 0x32, state = PacketState.PLAY, direction = PacketDirection.SERVERBOUND)
data class UseItemPacket(
    val hand: Int, // varint
    val sequence: Int, // varint
) : ServerBoundPacket {

    companion object : PacketSerializer<UseItemPacket> {
        override fun serialize(input: MinecraftProtocolDeserializeInterface<*>): UseItemPacket {
            val hand = input.readVarInt()
            val sequence = input.readVarInt()

            return UseItemPacket(hand, sequence)
        }

        override fun deserialize(output: MinecraftProtocolSerializeInterface<*>, value: UseItemPacket) {
            output.writeVarInt(value.hand)
            output.writeVarInt(value.sequence)
        }
    }
}