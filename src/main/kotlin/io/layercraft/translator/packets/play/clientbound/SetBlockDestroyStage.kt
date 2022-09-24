package io.layercraft.translator.packets.play.clientbound

import io.ktor.utils.io.core.*
import io.layercraft.translator.packets.*
import io.layercraft.translator.types.Position
import io.layercraft.translator.utils.mc

/**
 * Set block destroy stage | 0x06 | play | client-bound
 * 0–9 are the displayable destroy stages and each other number means that there is no animation on this coordinate.
 *
 * Block break animations can still be applied on air; the animation will remain visible although there is no block being broken. However, if this is applied to a transparent block, odd graphical effects may happen, including water losing its transparency. (An effect similar to this can be seen in normal gameplay when breaking ice blocks)
 *
 * If you need to display several break animations at the same time you have to give each of them a unique Entity ID. The entity ID does not need to correspond to an actual entity on the client. It is valid to use a randomly generated number.
 *
 * @property entityId The ID of the entity breaking the block.
 * @property location Block Position.
 * @property destroyStage 0–9 to set it, any other value to remove it.
 * @see <a href="https://wiki.vg/Protocol#Set_Block_Destroy_Stage">https://wiki.vg/Protocol#Set_Block_Destroy_Stage</a>
 */
@MinecraftPacket(0x06, PacketState.PLAY, PacketDirection.CLIENTBOUND)
data class SetBlockDestroyStage(
    val entityId: Int,
    val location: Position,
    val destroyStage: Byte
): ClientBoundPacket {
    companion object: PacketSerializer<SetBlockDestroyStage> {
        override fun serialize(input: Input): SetBlockDestroyStage {
            val entityId = input.mc.readVarInt()
            val location = input.mc.readPosition()
            val destroyStage = input.mc.readByte()

            return SetBlockDestroyStage(entityId, location, destroyStage)
        }

        override fun deserialize(output: Output, value: SetBlockDestroyStage) {
            output.mc.writeVarInt(value.entityId)
            output.mc.writePosition(value.location)
            output.mc.writeByte(value.destroyStage)
        }
    }
}