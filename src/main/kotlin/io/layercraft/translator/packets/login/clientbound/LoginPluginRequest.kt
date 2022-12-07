package io.layercraft.translator.packets.login.clientbound

import io.layercraft.translator.packets.*
import io.layercraft.translator.serialization.MinecraftProtocolDeserializeInterface
import io.layercraft.translator.serialization.MinecraftProtocolSerializeInterface

/**
 * Login plugin request | 0x04 | login | client-bound
 *
 * @property messageId Generated by the server - should be unique to the connection.
 * @property channel Name of the plugin channel used to send the data.
 * @property data Any data, depending on the channel. The length of this array must be inferred from the packet length.
 * @see <a href="http://wiki.vg/Protocol#Login_Plugin_Request">https://wiki.vg/Protocol#Login_Plugin_Request</a>
 */
@MinecraftPacket(packetId = 0x04, state = PacketState.LOGIN, direction = PacketDirection.CLIENTBOUND)
data class LoginPluginRequest(
    val messageId: Int, // varint
    val channel: String, // identifier
    val data: ByteArray, // byte array remaining
) : ClientBoundPacket {
    companion object : PacketSerializer<LoginPluginRequest> {

        override fun serialize(input: MinecraftProtocolDeserializeInterface<*>): LoginPluginRequest {
            val messageId = input.readVarInt()
            val channel = input.readIdentifier()
            val data = input.readRemainingByteArray()

            return LoginPluginRequest(messageId, channel, data)
        }

        override fun deserialize(output: MinecraftProtocolSerializeInterface<*>, value: LoginPluginRequest) {
            output.writeVarInt(value.messageId)
            output.writeIdentifier(value.channel)
            output.writeRemainingByteArray(value.data)
        }
    }
}