package io.layercraft.packetlib.packets.v1_19_2.play.serverbound

import io.layercraft.packetlib.packets.*
import io.layercraft.packetlib.serialization.MinecraftProtocolDeserializeInterface
import io.layercraft.packetlib.serialization.MinecraftProtocolSerializeInterface

/**
 * Seen Advancements | 0x25 | play | serverbound
 *
 * @property action action
 * @see <a href="https://wiki.vg/Protocol#Seen_Advancements">https://wiki.vg/Protocol#Seen_Advancements</a>
 */

@MinecraftPacket(packetId = 0x25, state = PacketState.PLAY, direction = PacketDirection.SERVERBOUND)
data class AdvancementTabPacket(
    val action: Int, // varint
) : ServerBoundPacket {

    companion object : PacketSerializer<AdvancementTabPacket> {
        override fun serialize(input: MinecraftProtocolDeserializeInterface<*>): AdvancementTabPacket {
            val action = input.readVarInt()

            return AdvancementTabPacket(action)
        }

        override fun deserialize(output: MinecraftProtocolSerializeInterface<*>, value: AdvancementTabPacket) {
            output.writeVarInt(value.action)
        }
    }
}