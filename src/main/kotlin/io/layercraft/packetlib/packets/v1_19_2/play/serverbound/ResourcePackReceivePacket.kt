package io.layercraft.packetlib.packets.v1_19_2.play.serverbound

import io.layercraft.packetlib.packets.*
import io.layercraft.packetlib.serialization.MinecraftProtocolDeserializeInterface
import io.layercraft.packetlib.serialization.MinecraftProtocolSerializeInterface

/**
 * Resource Pack (serverbound) | 0x24 | play | serverbound
 *
 * @param result result
 * @see <a href="https://wiki.vg/index.php?title=Protocol&oldid=17873#Resource_Pack_.28serverbound.29">https://wiki.vg/Protocol#Resource_Pack_.28serverbound.29</a>
 */

@MinecraftPacket(id = 0x24, state = PacketState.PLAY, direction = PacketDirection.SERVERBOUND)
data class ResourcePackReceivePacket(
    val result: Int, // varint
) : ServerBoundPacket {
    companion object : PacketSerializer<ResourcePackReceivePacket> {
        override fun deserialize(input: MinecraftProtocolDeserializeInterface<*>): ResourcePackReceivePacket {
            val result = input.readVarInt()

            return ResourcePackReceivePacket(result)
        }

        override fun serialize(output: MinecraftProtocolSerializeInterface<*>, value: ResourcePackReceivePacket) {
            output.writeVarInt(value.result)
        }
    }
}