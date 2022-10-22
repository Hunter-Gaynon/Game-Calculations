package boxes;

import com.sun.jdi.PathSearchingVirtualMachine;

public class Main {

    // box objects stored in memory for quick referencing
    public static final Box MYSTERY_BOX;
    public static final Box PVM_BOX;
    public static final Box PVM_BOX_T2;
    public static final Box PROGRESSIVE_REWARD_BOX;
    public static final Box SUPER_MYSTERY_BOX;
    public static final Box EXTREME_MYSTERY_BOX;
    public static final Box GRAND_MYSTERY_BOX;
    public static final Box VOTE_MYSTERY_BOX;
    public static final Box OP_CHEST;
    public static final Box DRAGONBALL_SAGA_BOX;
    public static final Box LAUNCH_CHEST;


    // since no public database exists with this data, it has been manually input here
    // feel free to minimize this static field
    static {
        MYSTERY_BOX = new Box(
                // common
                new Items[]{Items.UPGRADE_TOKEN, Items.DRAGON_MED_HELM, Items.DRAGON_SPEAR, Items.DRAGON_HALBERD,
                        Items.DRAGON_LONGSWORD, Items.DRAGON_DAGGER, Items.DRAGON_BATTLEAXE, Items.DRAGON_MACE,
                        Items.DRAGON_2H_SWORD, Items.CRYSTAL_KEY, Items.DRAGON_BONES},
                // uncommon
                new Items[]{Items.DRAGON_HATCHET, Items.BANDOS_BOOTS, Items.DRAGON_PICKAXE, Items.FIRE_CAPE,
                        Items.RUNNER_HAT_I, Items.BARROWS_GLOVES_I, Items.AMONITE_AXE, Items.LEAFY_LONGBOW,
                        Items.SORCERY_STAFF},
                // rare
                new Items[]{Items.TORMENTED_TENTACLE, Items.GILDED_HELMET, Items.GILDED_CHAINBODY,
                        Items.GILDED_PLATESKIRT, Items.KREEARA_CROSSBOW, Items.KREEARA_HELMET, Items.KREEARA_CHESTPLATE,
                        Items.KREEARA_CHAINSKIRT, Items.SKOLL_STAFF, Items.MAGEBEAST_HELM, Items.MAGEBEAST_BODY,
                        Items.MAGEBEAST_LEGS, Items.DEMONIC_SWORD, Items.NATURE_BOW, Items.ICEY_STAFF_OF_FESTIVE});
        PVM_BOX = new Box(
                new Items[]{Items.DHAROKS_HELM, Items.DHAROKS_PLATEBODY, Items.DHAROKS_PLATELEGS, Items.DHAROKS_GREATAXE,
                        Items.AHRIMS_HOOD, Items.AHRIMS_ROBE_TOP, Items.AHRIMS_ROBE_SKIRT, Items.AHRIMS_STAFF,
                        Items.KARILS_CROSSBOW, Items.KARILS_COIF, Items.KARILS_TOP, Items.KARILS_SKIRT,
                        Items.VERACS_HELM, Items.VERACS_BRASSARD, Items.VERACS_PLATESKIRT, Items.VERACS_FLAIL,
                        Items.TORAGS_HELM, Items.TORAGS_PLATEBODY, Items.TORAGS_PLATELEGS, Items.TORAGS_HAMMERS,
                        Items.LOOT_BOX},
                new Items[]{Items.KARILS_SET, Items.TORAGS_SET, Items.VERACS_SET, Items.AHRIMS_SET, Items.DHAROKS_SET,
                        Items.GUTHANS_SET},
                new Items[]{Items.ABYSSAL_WHIP, Items.DARK_BOW, Items.STAFF_OF_LIGHT, Items.DRAGON_DEFENDER,
                        Items.CHAOTIC_MAUL, Items.DRAGON_BOOTS, Items.AMULET_OF_FURY, Items.BERSERKER_RING,
                        Items.BARROWS_GLOVES}
        );
        PVM_BOX_T2 = new Box(
                PVM_BOX.getUncommonLoot(),
                PVM_BOX.getRareLoot(),
                new Items[]{Items.TORMENTED_TENTACLE, Items.GILDED_HELMET, Items.GILDED_CHAINBODY,
                        Items.GILDED_PLATESKIRT, Items.KREEARA_CROSSBOW, Items.KREEARA_HELMET, Items.KREEARA_CHESTPLATE,
                        Items.KREEARA_CHAINSKIRT, Items.SKOLL_STAFF, Items.MAGEBEAST_HELM, Items.MAGEBEAST_BODY,
                        Items.MAGEBEAST_LEGS}
        );
        PROGRESSIVE_REWARD_BOX = new Box(
                new Items[]{Items.IMP_HANDCANNON, Items.IMPSPAWN_WINGS, Items.COIF_IMP, Items.LEATHER_BODY_IMP,
                        Items.CHAPS_IMP, Items.IMP_GLOVES, Items.IMP_BOOTS, Items.LORD_HELMET, Items.LORD_BODY,
                        Items.LORD_LEGS, Items.STARLIGHT_SWORD, Items.INFERIOR_HELM, Items.INFERIOR_BODY,
                        Items.INFERIOR_LEGS, Items.DEMON_HOOD, Items.DEMON_TOP, Items.DEMON_BOTTOM, Items.DEMON_MAUL,
                        Items.FRACTITE_WINGS, Items.NUETRON_DAGGER, Items.NUETRON_BOOTS, Items.NUETRON_GAUNTLETS,
                        Items.INDROVOX_FULL_HELMET, Items.INDROVOX_PLATEBODY, Items.INDROVOX_PLATELEGS,
                        Items.INDROVOX_KITESHIELD, Items.JOYXOX_SWORD, Items.SKOLL_STAFF, Items.MAGEBEAST_HELM,
                        Items.MAGEBEAST_BODY, Items.MAGEBEAST_LEGS, Items.MALEFICENT_HELM, Items.MALEFICENT_BODY,
                        Items.MALEFICENT_LEGS, Items.TITAN_CELESTIAL_STAFF, Items.AVATAR_TITAN_CAPE},
                new Items[]{Items.LUCIEN_AXE, Items.LUCIEN_CRYPT_WINGS, Items.LUCIEN_HELM, Items.LUCIEN_PLATEBODY,
                        Items.LUCIEN_LEGS, Items.LUCIEN_WHIP, Items.LUCIEN_DEFENDER, Items.LUCIEN_CRYPT_GLOVES,
                        Items.LUCIEN_BOOTS, Items.GANOPURP_STAFF, Items.GANOPURP_VISOR, Items.GANOPURP_PONCHO,
                        Items.GANOPURP_LEGGINGS, Items.SCYTHE_OF_HERCULES, Items.HERCULES_FULL_HELM,
                        Items.HERCULES_FIGHTERBODY, Items.HERCULES_FIGHTERLEGS, Items.HERCULES_KITESHIELD,
                        Items.HERCULES_CAPE, Items.HERCULES_GLOVES, Items.HERCULES_BOOTS, Items.SHIKRUU_KATANA,
                        Items.SHIKRUU_HELM, Items.SHIKRUU_BODY, Items.SHIKRUU_LEGS, Items.ANGELS_FLAMETHROWER,
                        Items.ANGELIC_HELM, Items.ANGELIC_BOOTS, Items.ANGELIC_PLATELEGS, Items.ANGELIC_AMULET,
                        Items.ANGELIC_WINGS, Items.ANGELIC_GLOVES, Items.ANGELIC_BOOTS, Items.SORROW_BOW,
                        Items.SORROW_HORN_COIF, Items.SORROW_BODY, Items.SORROW_CHAPS, Items.SHADOW_GLOVES},
                new Items[]{Items.SATANIC_HELLBLADE, Items.SATANIC_FULL_HELM, Items.SATANIC_HELL_BODY,
                        Items.SATANIC_HELL_LEGS, Items.SATANIC_TOKHAAR_KAL, Items.ROYAL_AMULET,
                        Items.SATANIC_ANTI_HELLSHIELD, Items.RING_OF_SAURON_HELL, Items.SATANIC_GLOVES,
                        Items.SATANIC_BOOTS, Items.ZEUS_FULL_HELM, Items.ZEUS_BODY, Items.ZEUS_LEGS, Items.ZEUS_HAMMER,
                        Items.ZEUS_SHIELD, Items.ZEUS_FLAGCAPE, Items.ELECTRIC_GLOVES, Items.ELECTRIC_BOOTS,
                        Items.HADES_FULL_HELM, Items.HADES_BODY, Items.HADES_LEGS, Items.HADES_HAMMER,
                        Items.HADES_SHIELD, Items.GROUDON_FLAME_STAFF, Items.GROUDON_FLAME_POWER,
                        Items.GROUDON_FLAME_HELM, Items.GROUDON_FLAME_BODY, Items.GROUDON_FLAME_LEGS,
                        Items.GROUDON_FLAME_SHIELD, Items.GROUDON_FLAME_BOOTS, Items.LAVA_RING}
        );
        SUPER_MYSTERY_BOX = new Box(
                new Items[]{Items.UPGRADE_TOKEN, Items.CRYSTAL_KEY, Items.AMONITE_AXE, Items.LEAFY_LONGBOW,
                        Items.SORCERY_STAFF, Items.STATIUS_WARHAMMER, Items.VESTAS_LONGSWORD, Items.SARADOMIN_SWORD},
                new Items[]{Items.FROST_FULL_HELM, Items.FROST_PLATEBODY, Items.FROST_PLATELEGS, Items.LIME_COIF,
                        Items.LIME_LEATHER_BODY, Items.LIME_LEATHER_CHAPS, Items.PINK_HOOD, Items.PINK_ROBE_TOP,
                        Items.PINK_ROBE_BOTTOM, Items.DEMONIC_SWORD, Items.NATURE_BOW, Items.ICEY_STAFF_OF_FESTIVE},
                new Items[]{Items.FROST_FULL_HELM, Items.FROST_PLATEBODY, Items.FROST_PLATELEGS, Items.LIME_COIF,
                        Items.LIME_LEATHER_BODY, Items.LIME_LEATHER_CHAPS, Items.PINK_HOOD, Items.PINK_ROBE_TOP,
                        Items.PINK_ROBE_BOTTOM, Items.DEMONIC_SWORD, Items.NATURE_BOW, Items.ICEY_STAFF_OF_FESTIVE}
        );
        EXTREME_MYSTERY_BOX = new Box(
                new Items[]{Items.ABYSSAL_WHIP_COLORED, Items.ABYSSAL_WHIP_COLORED, Items.ABYSSAL_WHIP_COLORED,
                        Items.CHAOTIC_LONGSWORD, Items.CHAOTIC_RAPIER, Items.CHAOTIC_MAUL, Items.CHARMING_IMP,
                        Items.DIVINE_SPIRIT_SHIELD},
                new Items[]{Items.BRUTAL_TENTACLE, Items.BRUTAL_MINIGUN, Items.BRUTAL_STAFF, Items.DEMON_TOP,
                        Items.DEMON_HOOD, Items.DEMON_BOTTOM},
                new Items[]{Items.SHIKRUU_HELM, Items.SHIKRUU_BODY, Items.SHIKRUU_LEGS, Items.SHIKRUU_KATANA,
                        Items.SORROW_HORN_COIF, Items.SORROW_BODY, Items.SORROW_CHAPS, Items.SORROW_BOW,
                        Items.GANOPURP_VISOR, Items.GANOPURP_PONCHO, Items.GANOPURP_LEGGINGS, Items.GANOPURP_STAFF,
                        Items.$1_SCROLL}
        );
        GRAND_MYSTERY_BOX = new Box(
                new Items[]{Items.DIVINE_SPIRIT_SHIELD, Items.UPGRADE_TOKEN_PACK_5K},
                new Items[]{Items.SHIKRUU_KATANA, Items.SORROW_BOW, Items.GANOPURP_STAFF, Items.PREDATOR_REAPER,
                        Items.PREDATOR_OFFHAND, Items.PREDATOR_HELM, Items.PREDATOR_BODY, Items.PREDATOR_LEGS,
                        Items.PREDATOR_BOOTS, Items.BARROWS_GLOVES_I, Items.ICE_FURY},
                new Items[]{Items.T5_MELEE_HELM, Items.T5_MELEE_BODY, Items.T5_MELEE_LEGS, Items.TRINITY_HAMMERS,
                        Items.T5_RANGE_HELM, Items.T5_RANGE_BODY, Items.T5_RANGE_LEGS, Items.BLAST_BOW,
                        Items.T5_MAGIC_HELM, Items.T5_MAGIC_BODY, Items.T5_MAGIC_LEGS, Items.ARTS_STAFF, Items.$1_SCROLL,
                        Items.$5_BOND, Items.$10_BOND}
        );
        VOTE_MYSTERY_BOX = new Box(
                new Items[]{Items.SKELETAL_ARMOUR_SET, Items.DHAROKS_SET, Items.GUTHANS_SET, Items.KARILS_SET,
                        Items.TORAGS_SET, Items.VERACS_SET, Items.TORMENTED_TENTACLE, Items.KREEARA_CROSSBOW,
                        Items.SKOLL_STAFF, Items.PROGRESSIVE_REWARD_BOX},
                new Items[]{Items.SUPER_MYSTERY_BOX, Items.INVENTION_XP_LAMP, Items.LUCIEN_AXE, Items.LUCIEN_CRYPT_WINGS,
                        Items.LUCIEN_HELM, Items.LUCIEN_PLATEBODY, Items.LUCIEN_LEGS, Items.LUCIEN_WHIP,
                        Items.LUCIEN_DEFENDER, Items.LUCIEN_CRYPT_GLOVES},
                new Items[]{Items.SHIKRUU_BODY, Items.SHIKRUU_LEGS, Items.SORROW_HORN_COIF, Items.SORROW_BODY,
                        Items.SORROW_CHAPS, Items.GANOPURP_VISOR, Items.GANOPURP_PONCHO, Items.GANOPURP_LEGGINGS,
                        Items.ZARAS_XP_LAMP, Items.$1_SCROLL, Items.$5_BOND, Items.LAUNCH_CHEST}
        );
        OP_CHEST = new Box(
                new Items[]{Items.SHIKRUU_HELM, Items.SHIKRUU_BODY, Items.SHIKRUU_LEGS, Items.SHIKRUU_KATANA,
                        Items.SORROW_HORN_COIF, Items.SORROW_BODY, Items.SORROW_CHAPS, Items.SORROW_BOW,
                        Items.GANOPURP_VISOR, Items.GANOPURP_PONCHO, Items.GANOPURP_LEGGINGS, Items.GANOPURP_STAFF},
                new Items[]{Items.$1_SCROLL, Items.$1_SCROLL, Items.T5_MELEE_HELM, Items.T5_MELEE_BODY,
                        Items.T5_MELEE_LEGS, Items.TRINITY_HAMMERS, Items.T5_RANGE_HELM, Items.T5_RANGE_BODY,
                        Items.T5_RANGE_LEGS, Items.BLAST_BOW, Items.T5_MAGIC_HELM, Items.T5_MAGIC_BODY,
                        Items.T5_MAGIC_LEGS, Items.ARTS_STAFF},
                new Items[]{Items.CORRUPT_MAXIBLOOD_HELM, Items.CORRUPT_MAXIBLOOD_PLATEBODY,
                        Items.CORRUPT_MAXIBLOOD_LEGS, Items.CORRUPT_MAXIBLOOD_SPEAR, Items.CORRUPT_ARCHIE_HELM,
                        Items.CORRUPT_ARCHIE_BODY, Items.CORRUPT_ARCHIE_CHAPS, Items.CORRUPT_ARCHIE_BOW,
                        Items.CORRUPT_MOONLIGHT_HOOD, Items.CORRUPT_MOONLIGHT_ROBETOP, Items.CORRUPT_MOONLIGHT_ROBEBOTTOM,
                        Items.CORRUPT_MOONLIGHT_STAFF, Items.COLLECTOR_NECKLACE, Items.COLLECTOR_RING}
        );
        DRAGONBALL_SAGA_BOX = new Box(
                new Items[]{Items.DRAGONBALLZ_BONES, Items.MYSTERY_BOX, Items.TORMENTED_TENTACLE, Items.KREEARA_CROSSBOW,
                        Items.SKOLL_STAFF, Items.UPGRADE_TOKEN_PACK_5K, Items.PVM_BOX, Items._1B_BAG},
                new Items[]{Items.AMERICAN_PERNIX_HOOD, Items.AMERICAN_PERNIX_BODY, Items.AMERICAN_PERNIX_LEGS,
                        Items.SLAYER_DUALSABER, Items.SHADOW_NECKLACE, Items.$1_SCROLL, Items.CHRISTMAS_CRACKER,
                        Items.SUPER_MYSTERY_BOX, Items.ICE_FURY, Items.NATURESPAWN_NECKLACE, Items.BARROWS_GLOVES_I,
                        Items.BRUTAL_MINIGUN, Items.PIRATES_ANCOR},
                new Items[]{Items.UPGRADE_TOKEN_PACK_25K, Items.$5_BOND, Items.FREZIA_HELM, Items.FREZIA_BODY,
                        Items.FREZIA_LEGS, Items.PERFECT_CELL_HELM, Items.PERFECT_CELL_BODY, Items.PERFECT_CELL_LEGS,
                        Items.SUPER_BUU_HELM, Items.SUPER_BUU_BODY, Items.SUPER_BUU_LEGS}
        );
        LAUNCH_CHEST = new Box(
                new Items[]{Items.T5_MELEE_HELM, Items.T5_MELEE_BODY, Items.T5_MELEE_LEGS, Items.TRINITY_HAMMERS,
                        Items.T5_RANGE_HELM, Items.T5_RANGE_BODY, Items.T5_RANGE_LEGS, Items.BLAST_BOW,
                        Items.T5_MAGIC_HELM, Items.T5_MAGIC_BODY, Items.T5_MAGIC_LEGS, Items.ARTS_STAFF, Items.$1_SCROLL,
                        Items.$10_BOND, Items.UPGRADE_TOKEN_PACK_100K},
                new Items[]{Items.CORRUPT_MAXIBLOOD_HELM, Items.CORRUPT_MAXIBLOOD_PLATEBODY,
                        Items.CORRUPT_MAXIBLOOD_LEGS, Items.CORRUPT_MAXIBLOOD_SPEAR, Items.CORRUPT_ARCHIE_HELM,
                        Items.CORRUPT_ARCHIE_BODY, Items.CORRUPT_ARCHIE_CHAPS, Items.CORRUPT_ARCHIE_BOW,
                        Items.CORRUPT_MOONLIGHT_HOOD, Items.CORRUPT_MOONLIGHT_ROBETOP, Items.CORRUPT_MOONLIGHT_ROBEBOTTOM,
                        Items.CORRUPT_MOONLIGHT_STAFF, Items.COLLECTOR_RING, Items.$5_BOND, Items.$10_BOND},
                new Items[]{Items.BRUTAL_MINIGUN, Items.COLLECTOR_NECKLACE, Items.DRAGON_RIDER_LANCE,
                        Items.JUDICATOR_CROSSBOW, Items.PURIFIER_STAFF, Items.SUPREME_ATTACHMENT, Items.SS_AURA,
                        Items.$25_BOND, Items.OWNER_CAPE_GOODIE_BAG}
        );
    }

    public static void main(String[] args) {
        System.out.println("Mystery Box is worth: " + MYSTERY_BOX.getAverageLoot() + " each.");
        System.out.println("PVM Box is worth: " + PVM_BOX.getAverageLoot() + " each.");
        System.out.println("PVM Box T2 is worth: " + PVM_BOX_T2.getAverageLoot() + " each.");
        System.out.println("Progressive Reward Box is worth: " + PROGRESSIVE_REWARD_BOX.getAverageLoot() + " each.");
        System.out.println("Super Mystery Box is worth: " + SUPER_MYSTERY_BOX.getAverageLoot() + " each.");
        System.out.println("Extreme Mystery Box is worth: " + EXTREME_MYSTERY_BOX.getAverageLoot() + " each.");
        System.out.println("Grand Mystery Box is worth: " + GRAND_MYSTERY_BOX.getAverageLoot() + " each.");
        System.out.println("Vote Mystery Box is worth: " + VOTE_MYSTERY_BOX.getAverageLoot() + " each.");
        System.out.println("OP Chest is worth: " + OP_CHEST.getAverageLoot() + " each.");
        System.out.println("Dragonball Saga Box is worth: " + DRAGONBALL_SAGA_BOX.getAverageLoot() + " each.");
        System.out.println("Launch Chest is worth: " + LAUNCH_CHEST.getAverageLoot() + " each.");
    }

}