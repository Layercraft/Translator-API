package io.layercraft.packetlib.packets.v1_19_2.play.serverbound

import io.layercraft.packetlib.packets.*
import io.layercraft.packetlib.serialization.MinecraftProtocolDeserializeInterface
import io.layercraft.packetlib.serialization.MinecraftProtocolSerializeInterface

/**
 * Paddle Boat | 0x19 | play | serverbound
 *
 * @property leftPaddle leftPaddle
 * @property rightPaddle rightPaddle
 * @see <a href="https://wiki.vg/Protocol#Paddle_Boat">https://wiki.vg/Protocol#Paddle_Boat</a>
 */

@MinecraftPacket(packetId = 0x19, state = PacketState.PLAY, direction = PacketDirection.SERVERBOUND)
data class SteerBoatPacket(
    val leftPaddle: Boolean,
    val rightPaddle: Boolean,
) : ServerBoundPacket {

    companion object : PacketSerializer<SteerBoatPacket> {
        override fun serialize(input: MinecraftProtocolDeserializeInterface<*>): SteerBoatPacket {
            val leftPaddle = input.readBoolean()
            val rightPaddle = input.readBoolean()

            return SteerBoatPacket(leftPaddle, rightPaddle)
        }

        override fun deserialize(output: MinecraftProtocolSerializeInterface<*>, value: SteerBoatPacket) {
            output.writeBoolean(value.leftPaddle)
            output.writeBoolean(value.rightPaddle)
        }
    }
}