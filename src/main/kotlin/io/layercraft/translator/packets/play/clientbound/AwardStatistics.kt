package io.layercraft.translator.packets.play.clientbound

import io.layercraft.translator.packets.*
import io.layercraft.translator.packets.play.data.statistic.AwardStatistic
import io.layercraft.translator.packets.play.data.statistic.StatisticCategories
import io.layercraft.translator.serialization.MinecraftProtocolDeserializeInterface
import io.layercraft.translator.serialization.MinecraftProtocolSerializeInterface

/**
 * Award statistics | 0x04 | play | client-bound
 *
 * Sent as a response to Client Command (id 1). Will only send the changed values if previously requested.
 *
 * @property statistics Array of [AwardStatistic]
 * @see <a href="https://wiki.vg/Protocol#Award_Statistics">https://wiki.vg/Protocol#Award_Statistics</a>
 */
@MinecraftPacket(0x04, PacketState.PLAY, PacketDirection.CLIENTBOUND)
data class AwardStatistics(
    val statistics: List<AwardStatistic>,
) : ClientBoundPacket {
    companion object : PacketSerializer<AwardStatistics> {
        override fun serialize(input: MinecraftProtocolDeserializeInterface<*>): AwardStatistics {
            val statistics = input.readVarIntArray { AwardStatistic(StatisticCategories.fromId(it.readVarInt()), it.readVarInt(), it.readVarInt()) }

            return AwardStatistics(statistics)
        }

        override fun deserialize(output: MinecraftProtocolSerializeInterface<*>, value: AwardStatistics) {
            output.writeVarIntArray(value.statistics) { it, arrayOutput ->
                arrayOutput.writeVarInt(it.categoryId.id)
                arrayOutput.writeVarInt(it.statisticId)
                arrayOutput.writeVarInt(it.value)
            }
        }
    }
}