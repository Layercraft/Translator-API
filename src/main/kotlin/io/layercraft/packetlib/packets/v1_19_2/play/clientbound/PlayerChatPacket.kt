package io.layercraft.packetlib.packets.v1_19_2.play.clientbound

import io.layercraft.packetlib.packets.*
import io.layercraft.packetlib.serialization.MinecraftProtocolDeserializeInterface
import io.layercraft.packetlib.serialization.MinecraftProtocolSerializeInterface
import java.util.UUID
/**
 * Player Chat Message | 0x33 | play | clientbound
 *
 * @param senderUuid senderUuid
 * @param headerSignature headerSignature
 * @param plainMessage plainMessage
 * @param hasFormattedMessage formattedMessage is present
 * @param formattedMessage formattedMessage
 * @param timestamp timestamp
 * @param salt salt
 * @param hasUnsignedContent unsignedContent is present
 * @param unsignedContent unsignedContent
 * @param filterType filterType
 * @param filterTypeMask filterTypeMask
 * @param type type
 * @param networkName networkName
 * @param hasNetworkTargetName networkTargetName is present
 * @param networkTargetName networkTargetName
 * @see <a href="https://wiki.vg/index.php?title=Protocol&oldid=17873#Player_Chat_Message">https://wiki.vg/Protocol#Player_Chat_Message</a>
 */

@MinecraftPacket(id = 0x33, state = PacketState.PLAY, direction = PacketDirection.CLIENTBOUND)
data class PlayerChatPacket(
    val senderUuid: UUID,
    val headerSignature: List<UByte>, // varint array
    val plainMessage: String,
    val hasFormattedMessage: Boolean,
    val formattedMessage: String?,
    val timestamp: Long,
    val salt: Long,
    val hasUnsignedContent: Boolean,
    val unsignedContent: String?,
    val filterType: Int, // varint
    val filterTypeMask: List<Long>?,
    val type: Int, // varint
    val networkName: String,
    val hasNetworkTargetName: Boolean,
    val networkTargetName: String?,
) : ClientBoundPacket {
    companion object : PacketSerializer<PlayerChatPacket> {
        override fun deserialize(input: MinecraftProtocolDeserializeInterface<*>): PlayerChatPacket {
            val senderUuid = input.readUUID()
            val headerSignature = input.readVarIntArray { arrayInput -> arrayInput.readUByte() }
            val plainMessage = input.readString()
            val hasFormattedMessage = input.readBoolean()
            val formattedMessage = if (hasFormattedMessage) input.readString() else null
            val timestamp = input.readLong()
            val salt = input.readLong()
            val hasUnsignedContent = input.readBoolean()
            val unsignedContent = if (hasUnsignedContent) input.readString() else null
            val filterType = input.readVarInt()
            val filterTypeMask = when (filterType) {
                2 -> input.readVarIntArray { arrayInput -> arrayInput.readLong() }
                else -> null
            }
            val type = input.readVarInt()
            val networkName = input.readString()
            val hasNetworkTargetName = input.readBoolean()
            val networkTargetName = if (hasNetworkTargetName) input.readString() else null

            return PlayerChatPacket(senderUuid, headerSignature, plainMessage, hasFormattedMessage, formattedMessage, timestamp, salt, hasUnsignedContent, unsignedContent, filterType, filterTypeMask, type, networkName, hasNetworkTargetName, networkTargetName)
        }

        override fun serialize(output: MinecraftProtocolSerializeInterface<*>, value: PlayerChatPacket) {
            output.writeUUID(value.senderUuid)
            output.writeVarIntArray(value.headerSignature) { arrayValue, arrayOutput -> arrayOutput.writeUByte(arrayValue) }
            output.writeString(value.plainMessage)
            output.writeBoolean(value.hasFormattedMessage)
            if (value.hasFormattedMessage) output.writeString(value.formattedMessage!!)
            output.writeLong(value.timestamp)
            output.writeLong(value.salt)
            output.writeBoolean(value.hasUnsignedContent)
            if (value.hasUnsignedContent) output.writeString(value.unsignedContent!!)
            output.writeVarInt(value.filterType)
            when (value.filterType) {
                2 -> output.writeVarIntArray(value.filterTypeMask!!) { arrayValue, arrayOutput -> arrayOutput.writeLong(arrayValue) }
                else -> {}
            }
            output.writeVarInt(value.type)
            output.writeString(value.networkName)
            output.writeBoolean(value.hasNetworkTargetName)
            if (value.hasNetworkTargetName) output.writeString(value.networkTargetName!!)
        }
    }
}