package io.layercraft.packetlib.packets.v1_19_2.play.serverbound

import io.layercraft.packetlib.packets.*
import io.layercraft.packetlib.serialization.MinecraftProtocolDeserializeInterface
import io.layercraft.packetlib.serialization.MinecraftProtocolSerializeInterface

/**
 * Select Trade | 0x26 | play | serverbound
 *
 * @property slot slot
 * @see <a href="https://wiki.vg/Protocol#Select_Trade">https://wiki.vg/Protocol#Select_Trade</a>
 */

@MinecraftPacket(packetId = 0x26, state = PacketState.PLAY, direction = PacketDirection.SERVERBOUND)
data class SelectTradePacket(
    val slot: Int, // varint
) : ServerBoundPacket {

    companion object : PacketSerializer<SelectTradePacket> {
        override fun serialize(input: MinecraftProtocolDeserializeInterface<*>): SelectTradePacket {
            val slot = input.readVarInt()

            return SelectTradePacket(slot)
        }

        override fun deserialize(output: MinecraftProtocolSerializeInterface<*>, value: SelectTradePacket) {
            output.writeVarInt(value.slot)
        }
    }
}