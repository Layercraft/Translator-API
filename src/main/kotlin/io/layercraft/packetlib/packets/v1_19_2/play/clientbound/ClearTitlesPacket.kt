package io.layercraft.packetlib.packets.v1_19_2.play.clientbound

import io.layercraft.packetlib.packets.*
import io.layercraft.packetlib.serialization.MinecraftProtocolDeserializeInterface
import io.layercraft.packetlib.serialization.MinecraftProtocolSerializeInterface

/**
 * Clear Titles | 0x0d | play | clientbound
 *
 * @param reset reset
 * @see <a href="https://wiki.vg/index.php?title=Protocol&oldid=17873#Clear_Titles">https://wiki.vg/Protocol#Clear_Titles</a>
 */

@MinecraftPacket(id = 0x0d, state = PacketState.PLAY, direction = PacketDirection.CLIENTBOUND)
data class ClearTitlesPacket(
    val reset: Boolean,
) : ClientBoundPacket {
    companion object : PacketSerializer<ClearTitlesPacket> {
        override fun deserialize(input: MinecraftProtocolDeserializeInterface<*>): ClearTitlesPacket {
            val reset = input.readBoolean()

            return ClearTitlesPacket(reset)
        }

        override fun serialize(output: MinecraftProtocolSerializeInterface<*>, value: ClearTitlesPacket) {
            output.writeBoolean(value.reset)
        }
    }
}