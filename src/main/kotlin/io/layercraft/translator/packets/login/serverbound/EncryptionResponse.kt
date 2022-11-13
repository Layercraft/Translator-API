package io.layercraft.translator.packets.login.serverbound

import io.layercraft.translator.packets.*
import io.layercraft.translator.serialization.MinecraftProtocolDeserializeInterface
import io.layercraft.translator.serialization.MinecraftProtocolSerializeInterface

/**
 * Encryption response | 0x01 | login | server-bound
 *
 * @property sharedSecret Shared Secret value, encrypted with the server's public key.
 * @property hasVerifyToken Whether the Verify Token should be sent. If not, then the salt and signature will be sent.
 * @property verifyToken Verify Token value, encrypted with the same public key as the shared secret. Optional and only sent if Has Verified Token is true.
 * @property salt Cryptography, used for validating the message signature. Optional and only sent if Has Verified Token is false.
 * @property messageSignature The bytes of the public key signature the client received from Mojang. Optional and only sent if Has Verified Token is false.
 * @see <a href="https://wiki.vg/Protocol#Encryption_Response">https://wiki.vg/Protocol#Encryption_Response</a>
 */

@MinecraftPacket(packetId = 0x01, state = PacketState.LOGIN, direction = PacketDirection.SERVERBOUND)
data class EncryptionResponse(
    val sharedSecret: ByteArray, //varint byte array
    val hasVerifyToken: Boolean,
    val verifyToken: ByteArray?, //optional, varint byte array
    val salt: Long?, //optional
    val messageSignature: ByteArray?, //optional
) : ServerBoundPacket {
    companion object: PacketSerializer<EncryptionResponse> {

        override fun serialize(input: MinecraftProtocolDeserializeInterface<*>): EncryptionResponse {
            val sharedSecret = input.readVarIntByteArray()
            val hasVerifyToken = input.readBoolean()
            return if (hasVerifyToken) {
                val verifyToken = input.readVarIntByteArray()
                EncryptionResponse(sharedSecret, true, verifyToken, null, null)
            } else {
                val salt = input.readLong()
                val messageSignature = input.readVarIntByteArray()
                EncryptionResponse(sharedSecret, false, null, salt, messageSignature)
            }
        }

        override fun deserialize(output: MinecraftProtocolSerializeInterface<*>, value: EncryptionResponse) {
            output.writeVarIntByteArray(value.sharedSecret)
            output.writeBoolean(value.hasVerifyToken)
            if (value.hasVerifyToken) {
                output.writeVarIntByteArray(value.verifyToken!!)
            }
            if (!value.hasVerifyToken) {
                output.writeLong(value.salt!!)
                output.writeVarIntByteArray(value.messageSignature!!)
            }
        }
    }
}
