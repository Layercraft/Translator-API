package io.layercraft.packetlib.packets.v1_19_2.play.serverbound

import io.layercraft.packetlib.packets.*
import io.layercraft.packetlib.serialization.MinecraftProtocolDeserializeInterface
import io.layercraft.packetlib.serialization.MinecraftProtocolSerializeInterface

/**
 * Set Player Position and Rotation | 0x15 | play | serverbound
 *
 * @param x x
 * @param y y
 * @param z z
 * @param yaw yaw
 * @param pitch pitch
 * @param onGround onGround
 * @see <a href="https://wiki.vg/index.php?title=Protocol&oldid=17873#Set_Player_Position_and_Rotation">https://wiki.vg/Protocol#Set_Player_Position_and_Rotation</a>
 */

@MinecraftPacket(id = 0x15, state = PacketState.PLAY, direction = PacketDirection.SERVERBOUND)
data class PositionLookPacket(
    val x: Double,
    val y: Double,
    val z: Double,
    val yaw: Float,
    val pitch: Float,
    val onGround: Boolean,
) : ServerBoundPacket {
    companion object : PacketSerializer<PositionLookPacket> {
        override fun deserialize(input: MinecraftProtocolDeserializeInterface<*>): PositionLookPacket {
            val x = input.readDouble()
            val y = input.readDouble()
            val z = input.readDouble()
            val yaw = input.readFloat()
            val pitch = input.readFloat()
            val onGround = input.readBoolean()

            return PositionLookPacket(x, y, z, yaw, pitch, onGround)
        }

        override fun serialize(output: MinecraftProtocolSerializeInterface<*>, value: PositionLookPacket) {
            output.writeDouble(value.x)
            output.writeDouble(value.y)
            output.writeDouble(value.z)
            output.writeFloat(value.yaw)
            output.writeFloat(value.pitch)
            output.writeBoolean(value.onGround)
        }
    }
}