package io.layercraft.packetlib.packets.v1_19_2.play.clientbound

import io.layercraft.packetlib.packets.*
import io.layercraft.packetlib.serialization.MinecraftProtocolDeserializeInterface
import io.layercraft.packetlib.serialization.MinecraftProtocolSerializeInterface

/**
 * Set Cooldown | 0x14 | play | clientbound
 *
 * @param itemID itemID
 * @param cooldownTicks cooldownTicks
 * @see <a href="https://wiki.vg/index.php?title=Protocol&oldid=17873#Set_Cooldown">https://wiki.vg/Protocol#Set_Cooldown</a>
 */

@MinecraftPacket(id = 0x14, state = PacketState.PLAY, direction = PacketDirection.CLIENTBOUND)
data class SetCooldownPacket(
    val itemID: Int, // varint
    val cooldownTicks: Int, // varint
) : ClientBoundPacket {
    companion object : PacketSerializer<SetCooldownPacket> {
        override fun deserialize(input: MinecraftProtocolDeserializeInterface<*>): SetCooldownPacket {
            val itemID = input.readVarInt()
            val cooldownTicks = input.readVarInt()

            return SetCooldownPacket(itemID, cooldownTicks)
        }

        override fun serialize(output: MinecraftProtocolSerializeInterface<*>, value: SetCooldownPacket) {
            output.writeVarInt(value.itemID)
            output.writeVarInt(value.cooldownTicks)
        }
    }
}