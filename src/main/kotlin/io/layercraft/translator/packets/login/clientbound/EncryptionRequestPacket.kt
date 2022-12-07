package io.layercraft.translator.packets.login.clientbound

import io.layercraft.translator.packets.*
import io.layercraft.translator.serialization.MinecraftProtocolDeserializeInterface
import io.layercraft.translator.serialization.MinecraftProtocolSerializeInterface

/**
 * Encryption request | 0x01 | login | client-bound
 *
 * @property serverId Appears to be empty.
 * @property publicKey The server's public key, in bytes. Length before as a VarInt.
 * @property verifyToken A sequence of random bytes generated by the server. Length before as a VarInt.
 * @see <a href="https://wiki.vg/Protocol#Encryption_Request">https://wiki.vg/Protocol#Encryption_Request</a>
 */

@MinecraftPacket(packetId = 0x01, state = PacketState.LOGIN, direction = PacketDirection.CLIENTBOUND)
data class EncryptionRequestPacket(
    val serverId: String, // string(20)
    val publicKey: ByteArray, // varint byte array
    val verifyToken: ByteArray, // varint byte array
) : ClientBoundPacket {
    companion object : PacketSerializer<EncryptionRequestPacket> {

        override fun serialize(input: MinecraftProtocolDeserializeInterface<*>): EncryptionRequestPacket {
            val serverId = input.readString(20)
            val publicKey = input.readVarIntByteArray()
            val verifyToken = input.readVarIntByteArray()

            return EncryptionRequestPacket(serverId, publicKey, verifyToken)
        }

        override fun deserialize(output: MinecraftProtocolSerializeInterface<*>, value: EncryptionRequestPacket) {
            output.writeString(value.serverId, 20)
            output.writeVarIntByteArray(value.publicKey)
            output.writeVarIntByteArray(value.verifyToken)
        }
    }
}