package io.layercraft.translator.serialization

import io.ktor.utils.io.core.*
import io.layercraft.translator.types.Position
import io.layercraft.translator.utils.MINECRAFT_MAX_CHAT_LENGTH
import java.util.*

/**
 * Minecraft protocol serialize interface
 *
 * @constructor Create empty Minecraft protocol serialize interface
 * @see <a href="https://wiki.vg/Protocol#Data_types">https://wiki.vg/Protocol#Data_types</a>
 */
interface MinecraftProtocolDeserializeInterface<I> {

    val input: I

    fun readBoolean(): Boolean
    fun readByte(): Byte
    fun readUByte(): UByte

    fun readShort(): Short
    fun readUShort(): UShort

    fun readInt(): Int
    fun readVarInt(): Int

    fun readLong(): Long
    fun readVarLong(): Long

    fun readFloat(): Float
    fun readDouble(): Double

    fun readString(n: Int = MINECRAFT_MAX_CHAT_LENGTH): String
    fun readChat(): String
    fun readIdentifier(): String

    fun readVarIntByteArray(): ByteArray
    fun <T> readVarIntArray(decoder: (input: MinecraftProtocolDeserializeInterface<I>) -> T): List<T>

    fun readRemainingByteArray(): ByteArray
    fun <T> readRemainingArray(decoder: (input: MinecraftProtocolDeserializeInterface<I>) -> T): List<T>

    fun readPosition(): Position
    fun readUUID(): UUID
    fun readAngle(): Float
}
