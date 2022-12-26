package io.layercraft.packetlib.packets.v1_19.play.clientbound

import io.layercraft.packetlib.packets.*
import io.layercraft.packetlib.serialization.MinecraftProtocolDeserializeInterface
import io.layercraft.packetlib.serialization.MinecraftProtocolSerializeInterface

/**
 * Set Border Center | 0x41 | play | clientbound
 *
 * @property x x
 * @property z z
 * @see <a href="https://wiki.vg/Protocol#Set_Border_Center">https://wiki.vg/Protocol#Set_Border_Center</a>
 */

@MinecraftPacket(packetId = 0x41, state = PacketState.PLAY, direction = PacketDirection.CLIENTBOUND)
data class WorldBorderCenterPacket(
    val x: Double,
    val z: Double,
) : ClientBoundPacket {

    companion object : PacketSerializer<WorldBorderCenterPacket> {
        override fun serialize(input: MinecraftProtocolDeserializeInterface<*>): WorldBorderCenterPacket {
            val x = input.readDouble()
            val z = input.readDouble()

            return WorldBorderCenterPacket(x, z)
        }

        override fun deserialize(output: MinecraftProtocolSerializeInterface<*>, value: WorldBorderCenterPacket) {
            output.writeDouble(value.x)
            output.writeDouble(value.z)
        }
    }
}