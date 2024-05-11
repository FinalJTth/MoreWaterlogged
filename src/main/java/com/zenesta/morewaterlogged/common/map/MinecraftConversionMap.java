package com.zenesta.morewaterlogged.common.map;

import com.google.common.collect.ImmutableMap;
import com.tterrag.registrate.util.nullness.NonNullFunction;
import com.zenesta.morewaterlogged.common.MoreWaterlogged;
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
import net.minecraftforge.fml.loading.LoadingModList;
import net.minecraftforge.fml.loading.moddiscovery.ModInfo;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;

import static net.minecraft.world.level.block.Blocks.*;

import static com.zenesta.morewaterlogged.common.MoreWaterlogged.LOGGER;

@SuppressWarnings("deprecation")
public class MinecraftConversionMap extends ConversionMap {
    public static MinecraftConversionMap instance = null;

    private final Map<BlockSetType, Supplier<Block>> mapMaterial = ImmutableMap.of(BlockSetType.OAK, () -> OAK_PLANKS, BlockSetType.SPRUCE, () -> SPRUCE_PLANKS,
            BlockSetType.BIRCH, () -> BIRCH_PLANKS, BlockSetType.JUNGLE, () -> JUNGLE_PLANKS, BlockSetType.ACACIA, () -> ACACIA_PLANKS, BlockSetType.CHERRY, () -> CHERRY_PLANKS,
            BlockSetType.DARK_OAK, () -> DARK_OAK_PLANKS, BlockSetType.MANGROVE, () -> MANGROVE_PLANKS, BlockSetType.BAMBOO, () -> BAMBOO_PLANKS);

    // public final Map<String, Supplier<? extends Block>> conversionMap = new LinkedHashMap<>();

    public MinecraftConversionMap() {
        super(MoreWaterlogged.MINECRAFT_MOD_ID);
        instance = this;
    }

    @Override
    public void initialize() {
        conversionMap.put("white_bed", (props) -> bed(DyeColor.WHITE));
        conversionMap.put("orange_bed", (props) -> bed(DyeColor.ORANGE));
        conversionMap.put("magenta_bed", (props) -> bed(DyeColor.MAGENTA));
        conversionMap.put("light_blue_bed", (props) -> bed(DyeColor.LIGHT_BLUE));
        conversionMap.put("yellow_bed", (props) -> bed(DyeColor.YELLOW));
        conversionMap.put("lime_bed", (props) -> bed(DyeColor.LIME));
        conversionMap.put("pink_bed", (props) -> bed(DyeColor.PINK));
        conversionMap.put("gray_bed", (props) -> bed(DyeColor.GRAY));
        conversionMap.put("light_gray_bed", (props) -> bed(DyeColor.LIGHT_GRAY));
        conversionMap.put("cyan_bed", (props) -> bed(DyeColor.CYAN));
        conversionMap.put("purple_bed", (props) -> bed(DyeColor.PURPLE));
        conversionMap.put("blue_bed", (props) -> bed(DyeColor.BLUE));
        conversionMap.put("brown_bed", (props) -> bed(DyeColor.BROWN));
        conversionMap.put("green_bed", (props) -> bed(DyeColor.GREEN));
        conversionMap.put("red_bed", (props) -> bed(DyeColor.RED));
        conversionMap.put("black_bed", (props) -> bed(DyeColor.BLACK));
        conversionMap.put("white_banner", (props) -> banner(DyeColor.WHITE));
        conversionMap.put("orange_banner", (props) -> banner(DyeColor.ORANGE));
        conversionMap.put("magenta_banner", (props) -> banner(DyeColor.MAGENTA));
        conversionMap.put("light_blue_banner", (props) -> banner(DyeColor.LIGHT_BLUE));
        conversionMap.put("yellow_banner", (props) -> banner(DyeColor.YELLOW));
        conversionMap.put("lime_banner", (props) -> banner(DyeColor.LIME));
        conversionMap.put("pink_banner", (props) -> banner(DyeColor.PINK));
        conversionMap.put("gray_banner", (props) -> banner(DyeColor.GRAY));
        conversionMap.put("light_gray_banner", (props) -> banner(DyeColor.LIGHT_GRAY));
        conversionMap.put("cyan_banner", (props) -> banner(DyeColor.CYAN));
        conversionMap.put("purple_banner", (props) -> banner(DyeColor.PURPLE));
        conversionMap.put("blue_banner", (props) -> banner(DyeColor.BLUE));
        conversionMap.put("brown_banner", (props) -> banner(DyeColor.BROWN));
        conversionMap.put("green_banner", (props) -> banner(DyeColor.GREEN));
        conversionMap.put("red_banner", (props) -> banner(DyeColor.RED));
        conversionMap.put("black_banner", (props) -> banner(DyeColor.BLACK));
        conversionMap.put("white_wall_banner", (props) -> wallBanner(DyeColor.WHITE, WHITE_BANNER));
        conversionMap.put("orange_wall_banner", (props) -> wallBanner(DyeColor.ORANGE, ORANGE_BANNER));
        conversionMap.put("magenta_wall_banner", (props) -> wallBanner(DyeColor.MAGENTA, MAGENTA_BANNER));
        conversionMap.put("light_blue_wall_banner", (props) -> wallBanner(DyeColor.LIGHT_BLUE, LIGHT_BLUE_BANNER));
        conversionMap.put("yellow_wall_banner", (props) -> wallBanner(DyeColor.YELLOW, YELLOW_BANNER));
        conversionMap.put("lime_wall_banner", (props) -> wallBanner(DyeColor.LIME, LIME_BANNER));
        conversionMap.put("pink_wall_banner", (props) -> wallBanner(DyeColor.PINK, PINK_BANNER));
        conversionMap.put("gray_wall_banner", (props) -> wallBanner(DyeColor.GRAY, GRAY_BANNER));
        conversionMap.put("light_gray_wall_banner", (props) -> wallBanner(DyeColor.LIGHT_GRAY, LIGHT_GRAY_BANNER));
        conversionMap.put("cyan_wall_banner", (props) -> wallBanner(DyeColor.CYAN, CYAN_BANNER));
        conversionMap.put("purple_wall_banner", (props) -> wallBanner(DyeColor.PURPLE, PURPLE_BANNER));
        conversionMap.put("blue_wall_banner", (props) -> wallBanner(DyeColor.BLUE, BLUE_BANNER));
        conversionMap.put("brown_wall_banner", (props) -> wallBanner(DyeColor.BROWN, BROWN_BANNER));
        conversionMap.put("green_wall_banner", (props) -> wallBanner(DyeColor.GREEN, GREEN_BANNER));
        conversionMap.put("red_wall_banner", (props) -> wallBanner(DyeColor.RED, RED_BANNER));
        conversionMap.put("black_wall_banner", (props) -> wallBanner(DyeColor.BLACK, BLACK_BANNER));
        conversionMap.put("anvil", (props) -> anvil());
        conversionMap.put("chipped_anvil", (props) -> anvil());
        conversionMap.put("damaged_anvil", (props) -> anvil());
        conversionMap.put("bell", (props) -> bell());
        conversionMap.put("brewing_stand", (props) -> brewingStand());
        conversionMap.put("enchanting_table", (props) -> enchantmentTable());
        conversionMap.put("grindstone", (props) -> grindstone());
        conversionMap.put("hopper", (props) -> hopper());
        conversionMap.put("lectern", (props) -> lectern());
        conversionMap.put("jukebox", (props) -> jukebox());
        conversionMap.put("nether_portal", (props) -> netherPortal());
        conversionMap.put("stonecutter", (props) -> stonecutter());
        conversionMap.put("oak_door", (props) -> door(BlockSetType.OAK));
        conversionMap.put("iron_door", (props) -> door(BlockSetType.IRON));
        conversionMap.put("spruce_door", (props) -> door(BlockSetType.SPRUCE));
        conversionMap.put("birch_door", (props) -> door(BlockSetType.BIRCH));
        conversionMap.put("jungle_door", (props) -> door(BlockSetType.JUNGLE));
        conversionMap.put("acacia_door", (props) -> door(BlockSetType.ACACIA));
        conversionMap.put("cherry_door", (props) -> door(BlockSetType.CHERRY));
        conversionMap.put("dark_oak_door", (props) -> door(BlockSetType.DARK_OAK));
        conversionMap.put("mangrove_door", (props) -> door(BlockSetType.MANGROVE));
        conversionMap.put("bamboo_door", (props) -> door(BlockSetType.BAMBOO));

        applyCompatibility();

        postInitialize(conversionMap.keySet());

        hasInitialized = true;
    }

    public Block convert(String key, Block block) {
        if (conversionMap.containsKey(key)) {
            log(key);
            if (isKeyEnabled(key)) {
                Registry.register(BuiltInRegistries.BLOCK, key + "_deprecated", block);
                return (Block) conversionMap.get(key).apply(null);
            }
        }
        return block;
    }

    public void applyCompatibility() {
        List<String> modList = LoadingModList.get().getMods().stream().map(ModInfo::getModId).toList();
        if (modList.contains("apotheosis")) {
            LOGGER.debug("Apply compatible registry with \"apotheosis\"");
            conversionMap.replace("anvil", (props) -> new ApothAnvilBlock());
            conversionMap.replace("chipped_anvil", (props) -> new ApothAnvilBlock());
            conversionMap.replace("damaged_anvil", (props) -> new ApothAnvilBlock());

            conversionMap.replace("enchanting_table", (props) -> new ApothEnchantBlock());
        }
    }

    private BedBlock bed(DyeColor pColor) {
        return new BedBlock(pColor, BlockBehaviour.Properties.of()
                .mapColor((p_284863_) -> p_284863_.getValue(BedBlock.PART) == BedPart.FOOT ? pColor.getMapColor() : MapColor.WOOL)
                .sound(SoundType.WOOD).strength(0.2F).noOcclusion().ignitedByLava().pushReaction(PushReaction.DESTROY));
    }

    private BannerBlock banner(DyeColor pColor) {
        return new BannerBlock(pColor, BlockBehaviour.Properties.of().mapColor(MapColor.WOOD).forceSolidOn()
                .instrument(NoteBlockInstrument.BASS).noCollission().strength(1.0F)
                .sound(SoundType.WOOD).ignitedByLava());
    }

    @SuppressWarnings("deprecated")
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
                .lightLevel((p_50872_) -> 1).noOcclusion());
    }

    private EnchantmentTableBlock enchantmentTable() {
        return new EnchantmentTableBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_RED).instrument(NoteBlockInstrument.BASEDRUM)
                .requiresCorrectToolForDrops().lightLevel((p_50874_) -> 7).strength(5.0F, 1200.0F));
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
                .lightLevel((p_152605_) -> 11).pushReaction(PushReaction.BLOCK));
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

    private JukeboxBlock jukebox() {
        return new JukeboxBlock(BlockBehaviour.Properties.of().mapColor(MapColor.DIRT).instrument(NoteBlockInstrument.BASS)
                .strength(2.0F, 6.0F).ignitedByLava());
    }
}
