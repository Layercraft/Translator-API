package io.layercraft.packetlib.packets.v1_19_2.play.serverbound

import io.layercraft.packetlib.packets.*
import io.layercraft.packetlib.serialization.MinecraftProtocolDeserializeInterface
import io.layercraft.packetlib.serialization.MinecraftProtocolSerializeInterface
import java.util.UUID
/**
 * Chat Command | 0x04 | play | serverbound
 *
 * @property command command
 * @property timestamp timestamp
 * @property salt salt
 * @property argumentSignatures argumentSignatures
 * @property signedPreview signedPreview
 * @property hasLastMessage lastMessage is present
 * @property sender sender
 * @see <a href="https://wiki.vg/index.php?title=Protocol&oldid=17873#Chat_Command">https://wiki.vg/Protocol#Chat_Command</a>
 */

@MinecraftPacket(id = 0x04, state = PacketState.PLAY, direction = PacketDirection.SERVERBOUND)
data class ChatCommandPacket(
    val command: String,
    val timestamp: Long,
    val salt: Long,
    val argumentSignatures: List<ChatCommandPacketArgumentSignatures>, // varint array
    val signedPreview: Boolean,
    val hasLastMessage: Boolean,
    val sender: UUID?,
) : ServerBoundPacket {
    companion object : PacketSerializer<ChatCommandPacket> {
        override fun deserialize(input: MinecraftProtocolDeserializeInterface<*>): ChatCommandPacket {
            val command = input.readString()
            val timestamp = input.readLong()
            val salt = input.readLong()
            val argumentSignatures = input.readVarIntArray { arrayInput ->
                val argumentName = arrayInput.readString()

                return@readVarIntArray ChatCommandPacketArgumentSignatures(argumentName)
            }
            val signedPreview = input.readBoolean()
            val hasLastMessage = input.readBoolean()
            val sender = if (hasLastMessage) input.readUUID() else null

            return ChatCommandPacket(command, timestamp, salt, argumentSignatures, signedPreview, hasLastMessage, sender)
        }

        override fun serialize(output: MinecraftProtocolSerializeInterface<*>, value: ChatCommandPacket) {
            output.writeString(value.command)
            output.writeLong(value.timestamp)
            output.writeLong(value.salt)
            output.writeVarIntArray(value.argumentSignatures) { arrayValue, arrayOutput ->
                arrayOutput.writeString(arrayValue.argumentName)
            }
            output.writeBoolean(value.signedPreview)
            output.writeBoolean(value.hasLastMessage)
            if (value.hasLastMessage) output.writeUUID(value.sender!!)
        }
    }
}

/**
 * ChatCommandPacketArgumentSignatures | argumentSignatures
 *
 * @property argumentName argumentName
*/
data class ChatCommandPacketArgumentSignatures(
    val argumentName: String,
)