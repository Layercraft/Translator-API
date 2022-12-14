package io.layercraft.packetlib.packets.v1_19_2.play.clientbound

import io.layercraft.packetlib.packets.*
import io.layercraft.packetlib.serialization.MinecraftProtocolDeserializeInterface
import io.layercraft.packetlib.serialization.MinecraftProtocolSerializeInterface

/**
 * Commands | 0x0f | play | clientbound
 *
 * @param rootIndex rootIndex
 * @see <a href="https://wiki.vg/index.php?title=Protocol&oldid=17873#Commands">https://wiki.vg/Protocol#Commands</a>
 */

@MinecraftPacket(id = 0x0f, state = PacketState.PLAY, direction = PacketDirection.CLIENTBOUND)
data class DeclareCommandsPacket(
    val rootIndex: Int, // varint
) : ClientBoundPacket {
    companion object : PacketSerializer<DeclareCommandsPacket> {
        override fun deserialize(input: MinecraftProtocolDeserializeInterface<*>): DeclareCommandsPacket {
            val rootIndex = input.readVarInt()

            return DeclareCommandsPacket(rootIndex)
        }

        override fun serialize(output: MinecraftProtocolSerializeInterface<*>, value: DeclareCommandsPacket) {
            output.writeVarInt(value.rootIndex)
        }
    }
}