package io.layercraft.packetlib.packets.v1_19_2.play.clientbound

import io.layercraft.packetlib.packets.*
import io.layercraft.packetlib.serialization.MinecraftProtocolDeserializeInterface
import io.layercraft.packetlib.serialization.MinecraftProtocolSerializeInterface

/**
 * Entity Animation (clientbound) | 0x03 | play | clientbound
 *
 * @param entityId entityId
 * @param animation animation
 * @see <a href="https://wiki.vg/index.php?title=Protocol&oldid=17873#Entity_Animation_.28clientbound.29">https://wiki.vg/Protocol#Entity_Animation_.28clientbound.29</a>
 */

@MinecraftPacket(id = 0x03, state = PacketState.PLAY, direction = PacketDirection.CLIENTBOUND)
data class AnimationPacket(
    val entityId: Int, // varint
    val animation: UByte,
) : ClientBoundPacket {
    companion object : PacketSerializer<AnimationPacket> {
        override fun deserialize(input: MinecraftProtocolDeserializeInterface<*>): AnimationPacket {
            val entityId = input.readVarInt()
            val animation = input.readUByte()

            return AnimationPacket(entityId, animation)
        }

        override fun serialize(output: MinecraftProtocolSerializeInterface<*>, value: AnimationPacket) {
            output.writeVarInt(value.entityId)
            output.writeUByte(value.animation)
        }
    }
}