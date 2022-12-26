package io.layercraft.packetlib.packets.v1_19_2.play.clientbound

import io.layercraft.packetlib.packets.*
import io.layercraft.packetlib.serialization.MinecraftProtocolDeserializeInterface
import io.layercraft.packetlib.serialization.MinecraftProtocolSerializeInterface

/**
 * Set Border Warning Distance | 0x48 | play | clientbound
 *
 * @property warningBlocks warningBlocks
 * @see <a href="https://wiki.vg/Protocol#Set_Border_Warning_Distance">https://wiki.vg/Protocol#Set_Border_Warning_Distance</a>
 */

@MinecraftPacket(packetId = 0x48, state = PacketState.PLAY, direction = PacketDirection.CLIENTBOUND)
data class WorldBorderWarningReachPacket(
    val warningBlocks: Int, // varint
) : ClientBoundPacket {

    companion object : PacketSerializer<WorldBorderWarningReachPacket> {
        override fun serialize(input: MinecraftProtocolDeserializeInterface<*>): WorldBorderWarningReachPacket {
            val warningBlocks = input.readVarInt()

            return WorldBorderWarningReachPacket(warningBlocks)
        }

        override fun deserialize(output: MinecraftProtocolSerializeInterface<*>, value: WorldBorderWarningReachPacket) {
            output.writeVarInt(value.warningBlocks)
        }
    }
}