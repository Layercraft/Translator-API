package io.layercraft.packetlib.packets.v1_19_2.play.serverbound

import io.layercraft.packetlib.packets.*
import io.layercraft.packetlib.serialization.MinecraftProtocolDeserializeInterface
import io.layercraft.packetlib.serialization.MinecraftProtocolSerializeInterface

/**
 * Use Item | 0x0c | play | serverbound
 *
 * @property windowId windowId
 * @see <a href="https://wiki.vg/Protocol#Use_Item">https://wiki.vg/Protocol#Use_Item</a>
 */

@MinecraftPacket(packetId = 0x0c, state = PacketState.PLAY, direction = PacketDirection.SERVERBOUND)
data class CloseWindowPacket(
    val windowId: UByte,
) : ServerBoundPacket {

    companion object : PacketSerializer<CloseWindowPacket> {
        override fun serialize(input: MinecraftProtocolDeserializeInterface<*>): CloseWindowPacket {
            val windowId = input.readUByte()

            return CloseWindowPacket(windowId)
        }

        override fun deserialize(output: MinecraftProtocolSerializeInterface<*>, value: CloseWindowPacket) {
            output.writeUByte(value.windowId)
        }
    }
}