package com.zenesta.morewaterlogged.common.map;

import com.google.common.collect.ImmutableMap;
import com.zenesta.morewaterlogged.common.block.minecraft.*;
import com.zenesta.morewaterlogged.common.block.minecraft.compat.ApothAnvilBlock;
import com.zenesta.morewaterlogged.common.block.minecraft.compat.ApothEnchantBlock;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.BedPart;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;
import net.minecraftforge.common.ForgeHooks;
import net.minecraftforge.fml.loading.LoadingModList;
import net.minecraftforge.fml.loading.moddiscovery.ModInfo;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;

import static net.minecraft.world.level.block.Blocks.*;

import static com.zenesta.morewaterlogged.common.MoreWaterlogged.LOGGER;

public class MinecraftConversionMap extends ConversionMap {
    public static final String MOD_ID = "minecraft";
    public final Map<String, Supplier<Block>> conversionMap = new LinkedHashMap<>();

    private final Map<BlockSetType, Supplier<Block>> mapMaterial = ImmutableMap.of(BlockSetType.OAK, () -> OAK_PLANKS, BlockSetType.SPRUCE, () -> SPRUCE_PLANKS,
            BlockSetType.BIRCH, () -> BIRCH_PLANKS, BlockSetType.JUNGLE, () -> JUNGLE_PLANKS, BlockSetType.ACACIA, () -> ACACIA_PLANKS, BlockSetType.CHERRY, () -> CHERRY_PLANKS,
            BlockSetType.DARK_OAK, () -> DARK_OAK_PLANKS, BlockSetType.MANGROVE, () -> MANGROVE_PLANKS, BlockSetType.BAMBOO, () -> BAMBOO_PLANKS);

    public MinecraftConversionMap() {
        initialize();
    }

    public void initialize() {
        conversionMap.put("white_bed", () -> bed(DyeColor.WHITE));
        conversionMap.put("orange_bed", () -> bed(DyeColor.ORANGE));
        conversionMap.put("magenta_bed", () -> bed(DyeColor.MAGENTA));
        conversionMap.put("light_blue_bed", () -> bed(DyeColor.LIGHT_BLUE));
        conversionMap.put("yellow_bed", () -> bed(DyeColor.YELLOW));
        conversionMap.put("lime_bed", () -> bed(DyeColor.LIME));
        conversionMap.put("pink_bed", () -> bed(DyeColor.PINK));
        conversionMap.put("gray_bed", () -> bed(DyeColor.GRAY));
        conversionMap.put("light_gray_bed", () -> bed(DyeColor.LIGHT_GRAY));
        conversionMap.put("cyan_bed", () -> bed(DyeColor.CYAN));
        conversionMap.put("purple_bed", () -> bed(DyeColor.PURPLE));
        conversionMap.put("blue_bed", () -> bed(DyeColor.BLUE));
        conversionMap.put("brown_bed", () -> bed(DyeColor.BROWN));
        conversionMap.put("green_bed", () -> bed(DyeColor.GREEN));
        conversionMap.put("red_bed", () -> bed(DyeColor.RED));
        conversionMap.put("black_bed", () -> bed(DyeColor.BLACK));
        conversionMap.put("white_banner", () -> banner(DyeColor.WHITE));
        conversionMap.put("orange_banner", () -> banner(DyeColor.ORANGE));
        conversionMap.put("magenta_banner", () -> banner(DyeColor.MAGENTA));
        conversionMap.put("light_blue_banner", () -> banner(DyeColor.LIGHT_BLUE));
        conversionMap.put("yellow_banner", () -> banner(DyeColor.YELLOW));
        conversionMap.put("lime_banner", () -> banner(DyeColor.LIME));
        conversionMap.put("pink_banner", () -> banner(DyeColor.PINK));
        conversionMap.put("gray_banner", () -> banner(DyeColor.GRAY));
        conversionMap.put("light_gray_banner", () -> banner(DyeColor.LIGHT_GRAY));
        conversionMap.put("cyan_banner", () -> banner(DyeColor.CYAN));
        conversionMap.put("purple_banner", () -> banner(DyeColor.PURPLE));
        conversionMap.put("blue_banner", () -> banner(DyeColor.BLUE));
        conversionMap.put("brown_banner", () -> banner(DyeColor.BROWN));
        conversionMap.put("green_banner", () -> banner(DyeColor.GREEN));
        conversionMap.put("red_banner", () -> banner(DyeColor.RED));
        conversionMap.put("black_banner", () -> banner(DyeColor.BLACK));
        conversionMap.put("white_wall_banner", () -> wallBanner(DyeColor.WHITE, WHITE_BANNER));
        conversionMap.put("orange_wall_banner", () -> wallBanner(DyeColor.ORANGE, ORANGE_BANNER));
        conversionMap.put("magenta_wall_banner", () -> wallBanner(DyeColor.MAGENTA, MAGENTA_BANNER));
        conversionMap.put("light_blue_wall_banner", () -> wallBanner(DyeColor.LIGHT_BLUE, LIGHT_BLUE_BANNER));
        conversionMap.put("yellow_wall_banner", () -> wallBanner(DyeColor.YELLOW, YELLOW_BANNER));
        conversionMap.put("lime_wall_banner", () -> wallBanner(DyeColor.LIME, LIME_BANNER));
        conversionMap.put("pink_wall_banner", () -> wallBanner(DyeColor.PINK, PINK_BANNER));
        conversionMap.put("gray_wall_banner", () -> wallBanner(DyeColor.GRAY, GRAY_BANNER));
        conversionMap.put("light_gray_wall_banner", () -> wallBanner(DyeColor.LIGHT_GRAY, LIGHT_GRAY_BANNER));
        conversionMap.put("cyan_wall_banner", () -> wallBanner(DyeColor.CYAN, CYAN_BANNER));
        conversionMap.put("purple_wall_banner", () -> wallBanner(DyeColor.PURPLE, PURPLE_BANNER));
        conversionMap.put("blue_wall_banner", () -> wallBanner(DyeColor.BLUE, BLUE_BANNER));
        conversionMap.put("brown_wall_banner", () -> wallBanner(DyeColor.BROWN, BROWN_BANNER));
        conversionMap.put("green_wall_banner", () -> wallBanner(DyeColor.GREEN, GREEN_BANNER));
        conversionMap.put("red_wall_banner", () -> wallBanner(DyeColor.RED, RED_BANNER));
        conversionMap.put("black_wall_banner", () -> wallBanner(DyeColor.BLACK, BLACK_BANNER));
        conversionMap.put("anvil", this::anvil);
        conversionMap.put("chipped_anvil", this::anvil);
        conversionMap.put("damaged_anvil", this::anvil);
        conversionMap.put("bell", this::bell);
        conversionMap.put("brewing_stand", this::brewingStand);
        conversionMap.put("enchanting_table", this::enchantmentTable);
        conversionMap.put("grindstone", this::grindstone);
        conversionMap.put("hopper", this::hopper);
        conversionMap.put("lectern", this::lectern);
        conversionMap.put("nether_portal", this::netherPortal);
        conversionMap.put("stonecutter", this::stonecutter);
        conversionMap.put("oak_door", () -> door(BlockSetType.OAK));
        conversionMap.put("iron_door", () -> door(BlockSetType.IRON));
        conversionMap.put("spruce_door", () -> door(BlockSetType.SPRUCE));
        conversionMap.put("birch_door", () -> door(BlockSetType.BIRCH));
        conversionMap.put("jungle_door", () -> door(BlockSetType.JUNGLE));
        conversionMap.put("acacia_door", () -> door(BlockSetType.ACACIA));
        conversionMap.put("cherry_door", () -> door(BlockSetType.CHERRY));
        conversionMap.put("dark_oak_door", () -> door(BlockSetType.DARK_OAK));
        conversionMap.put("mangrove_door", () -> door(BlockSetType.MANGROVE));
        conversionMap.put("bamboo_door", () -> door(BlockSetType.BAMBOO));

        applyCompatibility();

        if (!CONFIG_MAP.containsKey(MOD_ID)) {
            CONFIG_MAP.put(MOD_ID, new LinkedHashMap<>());
        }
        for (String key : conversionMap.keySet()) {
            if (!CONFIG_MAP.get(MOD_ID).containsKey(key)) {
                MARKED_FOR_CONFIG_CREATION.set(true);
                CONFIG_MAP.get(MOD_ID).put(key, true);
            }
        }

        HAS_INITIALIZED_LIST.add(true);
    }

    public Block convert(String key, Block block) {
        if (conversionMap.containsKey(key)) {
            log(key, MOD_ID);
            if (isKeyEnabled(key, MOD_ID)) {
                Registry.register(BuiltInRegistries.BLOCK, key + "_deprecated", block);
                return conversionMap.get(key).get();
            }
        }
        return block;
    }

    public void applyCompatibility() {
        List<String> modList = LoadingModList.get().getMods().stream().map(ModInfo::getModId).toList();
        if (modList.contains("apotheosis")) {
            LOGGER.debug("Apply compatible registry with \"apotheosis\"");
            conversionMap.replace("anvil", ApothAnvilBlock::new);
            conversionMap.replace("chipped_anvil", ApothAnvilBlock::new);
            conversionMap.replace("damaged_anvil", ApothAnvilBlock::new);

            conversionMap.replace("enchanting_table", ApothEnchantBlock::new);
        }
    }

    private BedBlock bed(DyeColor pColor) {
        return new BedBlock(pColor, BlockBehaviour.Properties.of().mapColor((p_284863_) -> {
            return p_284863_.getValue(BedBlock.PART) == BedPart.FOOT ? pColor.getMapColor() : MapColor.WOOL;
        }).sound(SoundType.WOOD).strength(0.2F).noOcclusion().ignitedByLava().pushReaction(PushReaction.DESTROY));
    }

    private BannerBlock banner(DyeColor pColor) {
        return new BannerBlock(pColor, BlockBehaviour.Properties.of().mapColor(MapColor.WOOD).forceSolidOn()
                .instrument(NoteBlockInstrument.BASS).noCollission().strength(1.0F)
                .sound(SoundType.WOOD).ignitedByLava());
    }

    private WallBannerBlock wallBanner(DyeColor pColor, Block standingBanner) {
        return new WallBannerBlock(pColor, BlockBehaviour.Properties.of().mapColor(MapColor.WOOD).forceSolidOn()
                .instrument(NoteBlockInstrument.BASS).noCollission().strength(1.0F).sound(SoundType.WOOD)
                .dropsLike(standingBanner).ignitedByLava());
    }

    private AnvilBlock anvil() {
        return new AnvilBlock(BlockBehaviour.Properties.of().mapColor(MapColor.METAL)
                .requiresCorrectToolForDrops().strength(5.0F, 1200.0F)
                .sound(SoundType.ANVIL).pushReaction(PushReaction.BLOCK));
    }

    private BellBlock bell() {
        return new BellBlock(BlockBehaviour.Properties.of().mapColor(MapColor.GOLD).forceSolidOn()
                .requiresCorrectToolForDrops().strength(5.0F)
                .sound(SoundType.ANVIL).pushReaction(PushReaction.DESTROY));
    }

    private BrewingStandBlock brewingStand() {
        return new BrewingStandBlock(BlockBehaviour.Properties.of().mapColor(MapColor.METAL).requiresCorrectToolForDrops().strength(0.5F)
                .lightLevel((p_50872_) -> {
                    return 1;
                }).noOcclusion());
    }

    private EnchantmentTableBlock enchantmentTable() {
        return new EnchantmentTableBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_RED).instrument(NoteBlockInstrument.BASEDRUM)
                .requiresCorrectToolForDrops().lightLevel((p_50874_) -> {
                    return 7;
                }).strength(5.0F, 1200.0F));
    }

    private GrindstoneBlock grindstone() {
        return new GrindstoneBlock(BlockBehaviour.Properties.of().mapColor(MapColor.METAL).requiresCorrectToolForDrops().strength(2.0F, 6.0F)
                .sound(SoundType.STONE).pushReaction(PushReaction.BLOCK));
    }

    private HopperBlock hopper() {
        return new HopperBlock(BlockBehaviour.Properties.of().mapColor(MapColor.STONE).requiresCorrectToolForDrops().strength(3.0F, 4.8F)
                .sound(SoundType.METAL).noOcclusion());
    }

    private LecternBlock lectern() {
        return new LecternBlock(BlockBehaviour.Properties.of().mapColor(MapColor.WOOD).instrument(NoteBlockInstrument.BASS).strength(2.5F)
                .sound(SoundType.WOOD).ignitedByLava());
    }

    private NetherPortalBlock netherPortal() {
        return new NetherPortalBlock(BlockBehaviour.Properties.of().noCollission().randomTicks().strength(-1.0F).sound(SoundType.GLASS)
                .lightLevel((p_152605_) -> {
                    return 11;
                }).pushReaction(PushReaction.BLOCK));
    }

    private StonecutterBlock stonecutter() {
        return new StonecutterBlock(BlockBehaviour.Properties.of().mapColor(MapColor.STONE).instrument(NoteBlockInstrument.BASEDRUM)
                .requiresCorrectToolForDrops().strength(3.5F));
    }

    private DoorBlock door(BlockSetType type) {
        if (type == BlockSetType.IRON) {
            return new DoorBlock(BlockBehaviour.Properties.of().mapColor(MapColor.METAL)
                    .requiresCorrectToolForDrops().strength(5.0F).noOcclusion()
                    .pushReaction(PushReaction.DESTROY), type);
        } else if (mapMaterial.containsKey(type)) {
            return new DoorBlock(BlockBehaviour.Properties.of().mapColor(mapMaterial.get(type).get().defaultMapColor())
                    .instrument(NoteBlockInstrument.BASS).strength(3.0F).noOcclusion().ignitedByLava()
                    .pushReaction(PushReaction.DESTROY), type);
        }
        throw new RuntimeException("Mismatching door type");
    }
}
