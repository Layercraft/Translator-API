package io.layercraft.packetlib.data.entity

@Suppress("unused", "SpellCheckingInspection")
enum class EntityType(
    val type: Int,
    val entityName: String,
    val indentifier: String,
) {
    ALLAY(0, "Allay", "minecraft:allay"),
    AREA_EFFECT_CLOUD(1, "Area Effect Cloud", "minecraft:area_effect_cloud"),
    ARMOR_STAND(2, "Armor Stand", "minecraft:armor_stand"),
    ARROW(3, "Arrow", "minecraft:arrow"),
    AXOLOTL(4, "Axolotl", "minecraft:axolotl"),
    BAT(5, "Bat", "minecraft:bat"),
    BEE(6, "Bee", "minecraft:bee"),
    BLAZE(7, "Blaze", "minecraft:blaze"),
    BOAT(8, "Boat", "minecraft:boat"),
    CHEST_BOAT(9, "Chest Boat", "minecraft:chest_boat"),
    CAT(10, "Cat", "minecraft:cat"),
    CAVE_SPIDER(11, "Cave Spider", "minecraft:cave_spider"),
    CHICKEN(12, "Chicken", "minecraft:chicken"),
    COD(13, "Cod", "minecraft:cod"),
    COW(14, "Cow", "minecraft:cow"),
    CREEPER(15, "Creeper", "minecraft:creeper"),
    DOLPHIN(16, "Dolphin", "minecraft:dolphin"),
    DONKEY(17, "Donkey", "minecraft:donkey"),
    DRAGON_FIREBALL(18, "Dragon Fireball", "minecraft:dragon_fireball"),
    DROWNED(19, "Drowned", "minecraft:drowned"),
    ELDER_GUARDIAN(20, "Elder Guardian", "minecraft:elder_guardian"),
    ENDER_CRYSTAL(21, "Ender Crystal", "minecraft:ender_crystal"),
    ENDER_DRAGON(22, "Ender Dragon", "minecraft:ender_dragon"),
    ENDERMAN(23, "Enderman", "minecraft:enderman"),
    ENDERMITE(24, "Endermite", "minecraft:endermite"),
    EVOKER(25, "Evoker", "minecraft:evoker"),
    EVOKER_FANGS(26, "Evoker Fangs", "minecraft:evoker_fangs"),
    EXPERIENCE_ORB(27, "Experience Orb", "minecraft:experience_orb"),
    EYE_OF_ENDER(28, "Eye of Ender", "minecraft:eye_of_ender"),
    FALLING_BLOCK(29, "Falling Block", "minecraft:falling_block"),
    FIREWORK_ROCKET(30, "Firework Rocket", "minecraft:firework_rocket"),
    FOX(31, "Fox", "minecraft:fox"),
    FROG(32, "Frog", "minecraft:frog"),
    GHAST(33, "Ghast", "minecraft:ghast"),
    GIANT(34, "Giant", "minecraft:giant"),
    GLOW_ITEM_FRAME(35, "Glow Item Frame", "minecraft:glow_item_frame"),
    GLOW_SQUID(36, "Glow Squid", "minecraft:glow_squid"),
    GOAT(37, "Goat", "minecraft:goat"),
    GUARDIAN(38, "Guardian", "minecraft:guardian"),
    HOGLIN(39, "Hoglin", "minecraft:hoglin"),
    HORSE(40, "Horse", "minecraft:horse"),
    HUSK(41, "Husk", "minecraft:husk"),
    ILLUSIONER(42, "Illusioner", "minecraft:illusioner"),
    IRON_GOLEM(43, "Iron Golem", "minecraft:iron_golem"),
    ITEM(44, "Item", "minecraft:item"),
    ITEM_FRAME(45, "Item Frame", "minecraft:item_frame"),
    FIREBALL(46, "Fireball", "minecraft:fireball"),
    LEASH_KNOT(47, "Leash Knot", "minecraft:leash_knot"),
    LIGHTNING_BOLT(48, "Lightning Bolt", "minecraft:lightning_bolt"),
    LLAMA(49, "Llama", "minecraft:llama"),
    LLAMA_SPIT(50, "Llama Spit", "minecraft:llama_spit"),
    MAGMA_CUBE(51, "Magma Cube", "minecraft:magma_cube"),
    MARKER(52, "Marker", "minecraft:marker"),
    MINECART(53, "Minecart", "minecraft:minecart"),
    CHEST_MINECART(54, "Minecart Chest", "minecraft:chest_minecart"),
    COMMAND_BLOCK_MINECART(55, "Minecart Command Block", "minecraft:command_block_minecart"),
    FURNACE_MINECART(56, "Minecart Furnace", "minecraft:furnace_minecart"),
    HOPPER_MINECART(57, "Minecart Hopper", "minecraft:hopper_minecart"),
    SPAWNER_MINECART(58, "Minecart Spawner", "minecraft:spawner_minecart"),
    TNT_MINECART(59, "Minecart TNT", "minecraft:tnt_minecart"),
    MULE(60, "Mule", "minecraft:mule"),
    MOOSHROOM(61, "Mooshroom", "minecraft:mooshroom"),
    OCELOT(62, "Ocelot", "minecraft:ocelot"),
    PAINTING(63, "Painting", "minecraft:painting"),
    PANDA(64, "Panda", "minecraft:panda"),
    PARROT(65, "Parrot", "minecraft:parrot"),
    PHANTOM(66, "Phantom", "minecraft:phantom"),
    PIG(67, "Pig", "minecraft:pig"),
    PIGLIN(68, "Piglin", "minecraft:piglin"),
    PIGLIN_BRUTE(69, "Piglin Brute", "minecraft:piglin_brute"),
    PILLAGER(70, "Pillager", "minecraft:pillager"),
    POLAR_BEAR(71, "Polar Bear", "minecraft:polar_bear"),
    PRIMED_TNT(72, "Primed TNT", "minecraft:tnt"),
    PUFFERFISH(73, "Pufferfish", "minecraft:pufferfish"),
    RABBIT(74, "Rabbit", "minecraft:rabbit"),
    RAVAGER(75, "Ravager", "minecraft:ravager"),
    SALMON(76, "Salmon", "minecraft:salmon"),
    SHEEP(77, "Sheep", "minecraft:sheep"),
    SHULKER(78, "Shulker", "minecraft:shulker"),
    SHULKER_BULLET(79, "Shulker Bullet", "minecraft:shulker_bullet"),
    SILVERFISH(80, "Silverfish", "minecraft:silverfish"),
    SKELETON(81, "Skeleton", "minecraft:skeleton"),
    SKELETON_HORSE(82, "Skeleton Horse", "minecraft:skeleton_horse"),
    SLIME(83, "Slime", "minecraft:slime"),
    SMALL_FIREBALL(84, "Small Fireball", "minecraft:small_fireball"),
    SNOW_GOLEM(85, "Snow Golem", "minecraft:snow_golem"),
    SNOWBALL(86, "Snowball", "minecraft:snowball"),
    SPECTRAL_ARROW(87, "Spectral Arrow", "minecraft:spectral_arrow"),
    SPIDER(88, "Spider", "minecraft:spider"),
    SQUID(89, "Squid", "minecraft:squid"),
    STRAY(90, "Stray", "minecraft:stray"),
    STRIDER(91, "Strider", "minecraft:strider"),
    TADPOLE(92, "Tadpole", "minecraft:tadpole"),
    EGG(93, "Thrown Egg", "minecraft:egg"),
    ENDER_PEARL(94, "Thrown Enderpearl", "minecraft:ender_pearl"),
    XP_BOTTLE(95, "Thrown Experience Bottle", "minecraft:xp_bottle"),
    POTION(96, "Thrown Potion", "minecraft:potion"),
    TRIDENT(97, "Thrown Trident", "minecraft:trident"),
    TRADER_LLAMA(98, "Trader Llama", "minecraft:trader_llama"),
    TROPICAL_FISH(99, "Tropical Fish", "minecraft:tropical_fish"),
    TURTLE(100, "Turtle", "minecraft:turtle"),
    VEX(101, "Vex", "minecraft:vex"),
    VILLAGER(102, "Villager", "minecraft:villager"),
    VINDICATOR(103, "Vindicator", "minecraft:vindicator"),
    WANDERING_TRADER(104, "Wandering Trader", "minecraft:wandering_trader"),
    WARDEN(105, "Warden", "minecraft:warden"),
    WITCH(106, "Witch", "minecraft:witch"),
    WITHER(107, "Wither", "minecraft:wither"),
    WITHER_SKELETON(108, "Wither Skeleton", "minecraft:wither_skeleton"),
    WITHER_SKULL(109, "Wither Skull", "minecraft:wither_skull"),
    WOLF(110, "Wolf", "minecraft:wolf"),
    ZOGLIN(111, "Zoglin", "minecraft:zoglin"),
    ZOMBIE(112, "Zombie", "minecraft:zombie"),
    ZOMBIE_HORSE(113, "Zombie Horse", "minecraft:zombie_horse"),
    ZOMBIE_VILLAGER(114, "Zombie Villager", "minecraft:zombie_villager"),
    ZOMBIFIED_PIGLIN(115, "Zombified Piglin", "minecraft:zombified_piglin"),
    PLAYER(116, "Player", "minecraft:player"),
    FISHING_BOBBER(117, "Fishing Bobber", "minecraft:fishing_bobber"),
    ;

    companion object {
        private val BY_TYPE = values().associateBy(EntityType::type)
        private val BY_NAME = values().associateBy(EntityType::entityName)
        private val BY_INDENTFIER = values().associateBy(EntityType::indentifier)

        fun byType(id: Int) = BY_TYPE[id] ?: throw IllegalArgumentException("Unknown entity type id $id")
        fun byEntityName(name: String) = BY_NAME[name] ?: throw IllegalArgumentException("Unknown entity type name $name")
        fun byIndentifier(key: String) = BY_INDENTFIER[key] ?: throw IllegalArgumentException("Unknown entity type indentifier $key")
    }
}