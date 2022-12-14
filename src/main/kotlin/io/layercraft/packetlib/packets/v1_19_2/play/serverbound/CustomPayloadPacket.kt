package io.layercraft.packetlib.packets.v1_19_2.play.serverbound

import io.layercraft.packetlib.packets.*
import io.layercraft.packetlib.serialization.MinecraftProtocolDeserializeInterface
import io.layercraft.packetlib.serialization.MinecraftProtocolSerializeInterface

/**
 * Plugin Message (serverbound) | 0x0d | play | serverbound
 *
 * @param channel channel
 * @param data data
 * @see <a href="https://wiki.vg/index.php?title=Protocol&oldid=17873#Plugin_Message_.28serverbound.29">https://wiki.vg/Protocol#Plugin_Message_.28serverbound.29</a>
 */

@MinecraftPacket(id = 0x0d, state = PacketState.PLAY, direction = PacketDirection.SERVERBOUND)
data class CustomPayloadPacket(
    val channel: String,
    val data: ByteArray,
) : ServerBoundPacket {
    companion object : PacketSerializer<CustomPayloadPacket> {
        override fun deserialize(input: MinecraftProtocolDeserializeInterface<*>): CustomPayloadPacket {
            val channel = input.readString()
            val data = input.readRemainingByteArray()

            return CustomPayloadPacket(channel, data)
        }

        override fun serialize(output: MinecraftProtocolSerializeInterface<*>, value: CustomPayloadPacket) {
            output.writeString(value.channel)
            output.writeRemainingByteArray(value.data)
        }
    }
}