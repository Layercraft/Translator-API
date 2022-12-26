package io.layercraft.packetlib.packets.v1_19_2.play.clientbound

import io.layercraft.packetlib.packets.*
import io.layercraft.packetlib.serialization.MinecraftProtocolDeserializeInterface
import io.layercraft.packetlib.serialization.MinecraftProtocolSerializeInterface

/**
 * Set Border Warning Delay | 0x47 | play | clientbound
 *
 * @property warningTime warningTime
 * @see <a href="https://wiki.vg/Protocol#Set_Border_Warning_Delay">https://wiki.vg/Protocol#Set_Border_Warning_Delay</a>
 */

@MinecraftPacket(packetId = 0x47, state = PacketState.PLAY, direction = PacketDirection.CLIENTBOUND)
data class WorldBorderWarningDelayPacket(
    val warningTime: Int, // varint
) : ClientBoundPacket {

    companion object : PacketSerializer<WorldBorderWarningDelayPacket> {
        override fun serialize(input: MinecraftProtocolDeserializeInterface<*>): WorldBorderWarningDelayPacket {
            val warningTime = input.readVarInt()

            return WorldBorderWarningDelayPacket(warningTime)
        }

        override fun deserialize(output: MinecraftProtocolSerializeInterface<*>, value: WorldBorderWarningDelayPacket) {
            output.writeVarInt(value.warningTime)
        }
    }
}