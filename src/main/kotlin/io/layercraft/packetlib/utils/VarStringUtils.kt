package io.layercraft.packetlib.utils

import io.layercraft.packetlib.exceptions.MinecraftProtocolDecodingException
import io.layercraft.packetlib.exceptions.MinecraftProtocolEncodingException
import io.layercraft.packetlib.serialization.MinecraftProtocolDeserializeInterface
import io.layercraft.packetlib.serialization.MinecraftProtocolSerializeInterface
import java.io.EOFException
import kotlin.text.toByteArray

const val MINECRAFT_MAX_STRING_LENGTH = 32767
const val MINECRAFT_MAX_CHAT_LENGTH = 262144
const val MINECRAFT_MAX_IDENTIFIER_LENGTH = 32767

object MinecraftStringUtils {

    fun readString(maxLength: Int = MINECRAFT_MAX_STRING_LENGTH, input: MinecraftProtocolDeserializeInterface<*>): String {
        if (input.remaining <= 0) throw EOFException("Premature end of stream")

        val length: Int = input.readVarInt()

        if (length > maxLength * 4) throw MinecraftProtocolDecodingException("The received encoded string buffer length is longer than maximum allowed ($length > ${maxLength * 4})")
        if (length < 0) throw MinecraftProtocolDecodingException("The received encoded string buffer length is less than zero! Weird string!")

        val string: String = input.readBytes(length).toString(Charsets.UTF_8)

        if (string.length > maxLength) throw MinecraftProtocolDecodingException("The received string length is longer than maximum allowed (${string.length} > $maxLength)")

        return string
    }

    fun writeString(maxLength: Int = MINECRAFT_MAX_STRING_LENGTH, string: String, output: MinecraftProtocolSerializeInterface<*>) {
        val bytes = string.toByteArray(Charsets.UTF_8)
        if (bytes.size > MINECRAFT_MAX_STRING_LENGTH) throw MinecraftProtocolEncodingException("String too big (was ${bytes.size} bytes encoded, max $MINECRAFT_MAX_STRING_LENGTH)")
        if (string.length > maxLength) throw MinecraftProtocolEncodingException("String too big (was ${string.length} characters, max $maxLength)")
        output.writeVarInt(bytes.size)
        output.writeBytes(bytes)
    }
}