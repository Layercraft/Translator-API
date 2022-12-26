package io.layercraft.packetlib.packets.v1_19.play.clientbound

import io.layercraft.packetlib.packets.*
import io.layercraft.packetlib.serialization.MinecraftProtocolDeserializeInterface
import io.layercraft.packetlib.serialization.MinecraftProtocolSerializeInterface

/**
 * Set Experience | 0x51 | play | clientbound
 *
 * @property experienceBar experienceBar
 * @property level level
 * @property totalExperience totalExperience
 * @see <a href="https://wiki.vg/Protocol#Set_Experience">https://wiki.vg/Protocol#Set_Experience</a>
 */

@MinecraftPacket(packetId = 0x51, state = PacketState.PLAY, direction = PacketDirection.CLIENTBOUND)
data class ExperiencePacket(
    val experienceBar: Float,
    val level: Int, // varint
    val totalExperience: Int, // varint
) : ClientBoundPacket {

    companion object : PacketSerializer<ExperiencePacket> {
        override fun serialize(input: MinecraftProtocolDeserializeInterface<*>): ExperiencePacket {
            val experienceBar = input.readFloat()
            val level = input.readVarInt()
            val totalExperience = input.readVarInt()

            return ExperiencePacket(experienceBar, level, totalExperience)
        }

        override fun deserialize(output: MinecraftProtocolSerializeInterface<*>, value: ExperiencePacket) {
            output.writeFloat(value.experienceBar)
            output.writeVarInt(value.level)
            output.writeVarInt(value.totalExperience)
        }
    }
}