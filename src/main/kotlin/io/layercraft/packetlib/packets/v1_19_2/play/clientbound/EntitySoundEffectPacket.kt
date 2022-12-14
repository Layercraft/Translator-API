package io.layercraft.packetlib.packets.v1_19_2.play.clientbound

import io.layercraft.packetlib.packets.*
import io.layercraft.packetlib.serialization.MinecraftProtocolDeserializeInterface
import io.layercraft.packetlib.serialization.MinecraftProtocolSerializeInterface

/**
 * Entity Sound Effect | 0x5f | play | clientbound
 *
 * @param soundId soundId
 * @param soundCategory soundCategory
 * @param entityId entityId
 * @param volume volume
 * @param pitch pitch
 * @see <a href="https://wiki.vg/index.php?title=Protocol&oldid=17873#Entity_Sound_Effect">https://wiki.vg/Protocol#Entity_Sound_Effect</a>
 */

@MinecraftPacket(id = 0x5f, state = PacketState.PLAY, direction = PacketDirection.CLIENTBOUND)
data class EntitySoundEffectPacket(
    val soundId: Int, // varint
    val soundCategory: Int, // varint
    val entityId: Int, // varint
    val volume: Float,
    val pitch: Float,
) : ClientBoundPacket {
    companion object : PacketSerializer<EntitySoundEffectPacket> {
        override fun deserialize(input: MinecraftProtocolDeserializeInterface<*>): EntitySoundEffectPacket {
            val soundId = input.readVarInt()
            val soundCategory = input.readVarInt()
            val entityId = input.readVarInt()
            val volume = input.readFloat()
            val pitch = input.readFloat()

            return EntitySoundEffectPacket(soundId, soundCategory, entityId, volume, pitch)
        }

        override fun serialize(output: MinecraftProtocolSerializeInterface<*>, value: EntitySoundEffectPacket) {
            output.writeVarInt(value.soundId)
            output.writeVarInt(value.soundCategory)
            output.writeVarInt(value.entityId)
            output.writeFloat(value.volume)
            output.writeFloat(value.pitch)
        }
    }
}