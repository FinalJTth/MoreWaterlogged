package com.zenesta.morewaterlogged.common.map;

import com.zenesta.morewaterlogged.common.block.minecraft.*;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.BedPart;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Supplier;

import static net.minecraft.world.level.block.Blocks.*;

public class MinecraftConversionMap extends ConversionMap {
    public final Map<String, Supplier<Block>> CONVERSION_MAP = new LinkedHashMap<>();

    public MinecraftConversionMap() {
        initialize();
    }

    public void initialize() {
        CONVERSION_MAP.put("white_bed", () -> bed(DyeColor.WHITE));
        CONVERSION_MAP.put("orange_bed", () -> bed(DyeColor.ORANGE));
        CONVERSION_MAP.put("magenta_bed", () -> bed(DyeColor.MAGENTA));
        CONVERSION_MAP.put("light_blue_bed", () -> bed(DyeColor.LIGHT_BLUE));
        CONVERSION_MAP.put("yellow_bed", () -> bed(DyeColor.YELLOW));
        CONVERSION_MAP.put("lime_bed", () -> bed(DyeColor.LIME));
        CONVERSION_MAP.put("pink_bed", () -> bed(DyeColor.PINK));
        CONVERSION_MAP.put("gray_bed", () -> bed(DyeColor.GRAY));
        CONVERSION_MAP.put("light_gray_bed", () -> bed(DyeColor.LIGHT_GRAY));
        CONVERSION_MAP.put("cyan_bed", () -> bed(DyeColor.CYAN));
        CONVERSION_MAP.put("purple_bed", () -> bed(DyeColor.PURPLE));
        CONVERSION_MAP.put("blue_bed", () -> bed(DyeColor.BLUE));
        CONVERSION_MAP.put("brown_bed", () -> bed(DyeColor.BROWN));
        CONVERSION_MAP.put("green_bed", () -> bed(DyeColor.GREEN));
        CONVERSION_MAP.put("red_bed", () -> bed(DyeColor.RED));
        CONVERSION_MAP.put("black_bed", () -> bed(DyeColor.BLACK));
        CONVERSION_MAP.put("white_banner", () -> banner(DyeColor.WHITE));
        CONVERSION_MAP.put("orange_banner", () -> banner(DyeColor.ORANGE));
        CONVERSION_MAP.put("magenta_banner", () -> banner(DyeColor.MAGENTA));
        CONVERSION_MAP.put("light_blue_banner", () -> banner(DyeColor.LIGHT_BLUE));
        CONVERSION_MAP.put("yellow_banner", () -> banner(DyeColor.YELLOW));
        CONVERSION_MAP.put("lime_banner", () -> banner(DyeColor.LIME));
        CONVERSION_MAP.put("pink_banner", () -> banner(DyeColor.PINK));
        CONVERSION_MAP.put("gray_banner", () -> banner(DyeColor.GRAY));
        CONVERSION_MAP.put("light_gray_banner", () -> banner(DyeColor.LIGHT_GRAY));
        CONVERSION_MAP.put("cyan_banner", () -> banner(DyeColor.CYAN));
        CONVERSION_MAP.put("purple_banner", () -> banner(DyeColor.PURPLE));
        CONVERSION_MAP.put("blue_banner", () -> banner(DyeColor.BLUE));
        CONVERSION_MAP.put("brown_banner", () -> banner(DyeColor.BROWN));
        CONVERSION_MAP.put("green_banner", () -> banner(DyeColor.GREEN));
        CONVERSION_MAP.put("red_banner", () -> banner(DyeColor.RED));
        CONVERSION_MAP.put("black_banner", () -> banner(DyeColor.BLACK));
        CONVERSION_MAP.put("white_wall_banner", () -> wallBanner(DyeColor.WHITE, WHITE_BANNER));
        CONVERSION_MAP.put("orange_wall_banner", () -> wallBanner(DyeColor.ORANGE, ORANGE_BANNER));
        CONVERSION_MAP.put("magenta_wall_banner", () -> wallBanner(DyeColor.MAGENTA, MAGENTA_BANNER));
        CONVERSION_MAP.put("light_blue_wall_banner", () -> wallBanner(DyeColor.LIGHT_BLUE, LIGHT_BLUE_BANNER));
        CONVERSION_MAP.put("yellow_wall_banner", () -> wallBanner(DyeColor.YELLOW, YELLOW_BANNER));
        CONVERSION_MAP.put("lime_wall_banner", () -> wallBanner(DyeColor.LIME, LIME_BANNER));
        CONVERSION_MAP.put("pink_wall_banner", () -> wallBanner(DyeColor.PINK, PINK_BANNER));
        CONVERSION_MAP.put("gray_wall_banner", () -> wallBanner(DyeColor.GRAY, GRAY_BANNER));
        CONVERSION_MAP.put("light_gray_wall_banner", () -> wallBanner(DyeColor.LIGHT_GRAY, LIGHT_GRAY_BANNER));
        CONVERSION_MAP.put("cyan_wall_banner", () -> wallBanner(DyeColor.CYAN, CYAN_BANNER));
        CONVERSION_MAP.put("purple_wall_banner", () -> wallBanner(DyeColor.PURPLE, PURPLE_BANNER));
        CONVERSION_MAP.put("blue_wall_banner", () -> wallBanner(DyeColor.BLUE, BLUE_BANNER));
        CONVERSION_MAP.put("brown_wall_banner", () -> wallBanner(DyeColor.BROWN, BROWN_BANNER));
        CONVERSION_MAP.put("green_wall_banner", () -> wallBanner(DyeColor.GREEN, GREEN_BANNER));
        CONVERSION_MAP.put("red_wall_banner", () -> wallBanner(DyeColor.RED, RED_BANNER));
        CONVERSION_MAP.put("black_wall_banner", () -> wallBanner(DyeColor.BLACK, BLACK_BANNER));
        CONVERSION_MAP.put("anvil", this::anvil);
        CONVERSION_MAP.put("chipped_anvil", this::anvil);
        CONVERSION_MAP.put("damaged_anvil", this::anvil);
        CONVERSION_MAP.put("bell", this::bell);
        CONVERSION_MAP.put("brewing_stand", this::brewingStand);
        CONVERSION_MAP.put("enchanting_table", this::enchantmentTable);
        CONVERSION_MAP.put("grindstone", this::grindstone);
        CONVERSION_MAP.put("hopper", this::hopper);
        CONVERSION_MAP.put("lectern", this::lectern);
        CONVERSION_MAP.put("nether_portal", this::netherPortal);
        CONVERSION_MAP.put("stonecutter", this::stonecutter);
    }

    public Block convert(String key, Block block) {
        if (CONVERSION_MAP.containsKey(key)) {
            Registry.register(BuiltInRegistries.BLOCK, key + "_deprecated", block);
            log(key);
            return CONVERSION_MAP.get(key).get();
        }
        return block;
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
}
