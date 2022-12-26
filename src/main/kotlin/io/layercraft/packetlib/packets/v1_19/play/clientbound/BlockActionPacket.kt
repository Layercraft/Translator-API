package io.layercraft.packetlib.packets.v1_19.play.clientbound

import io.layercraft.packetlib.packets.*
import io.layercraft.packetlib.serialization.MinecraftProtocolDeserializeInterface
import io.layercraft.packetlib.serialization.MinecraftProtocolSerializeInterface
import io.layercraft.packetlib.types.Position

/**
 * Block Action | 0x08 | play | clientbound
 *
 * @property location location
 * @property byte1 byte1
 * @property byte2 byte2
 * @property blockId blockId
 * @see <a href="https://wiki.vg/Protocol#Block_Action">https://wiki.vg/Protocol#Block_Action</a>
 */

@MinecraftPacket(packetId = 0x08, state = PacketState.PLAY, direction = PacketDirection.CLIENTBOUND)
data class BlockActionPacket(
    val location: Position,
    val byte1: UByte,
    val byte2: UByte,
    val blockId: Int, // varint
) : ClientBoundPacket {

    companion object : PacketSerializer<BlockActionPacket> {
        override fun serialize(input: MinecraftProtocolDeserializeInterface<*>): BlockActionPacket {
            val location = input.readPosition()
            val byte1 = input.readUByte()
            val byte2 = input.readUByte()
            val blockId = input.readVarInt()

            return BlockActionPacket(location, byte1, byte2, blockId)
        }

        override fun deserialize(output: MinecraftProtocolSerializeInterface<*>, value: BlockActionPacket) {
            output.writePosition(value.location)
            output.writeUByte(value.byte1)
            output.writeUByte(value.byte2)
            output.writeVarInt(value.blockId)
        }
    }
}