package com.zenesta.morewaterlogged.mixin;

import com.zenesta.morewaterlogged.common.block.*;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.BedPart;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;
import org.spongepowered.asm.mixin.*;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;
import java.util.stream.Collectors;

import static net.minecraft.world.level.block.Blocks.YELLOW_BANNER;

@Mixin(Blocks.class)
public class MixinBlocks {
    @Shadow @Final public static Block WHITE_BANNER;
    @Shadow @Final public static Block ORANGE_BANNER;
    @Shadow @Final public static Block MAGENTA_BANNER;
    @Shadow @Final public static Block LIGHT_BLUE_BANNER;
    @Shadow @Final public static Block YELLOW_BANNER;
    @Shadow @Final public static Block LIME_BANNER;
    @Shadow @Final public static Block PINK_BANNER;
    @Shadow @Final public static Block GRAY_BANNER;
    @Shadow @Final public static Block LIGHT_GRAY_BANNER;
    @Shadow @Final public static Block CYAN_BANNER;
    @Shadow @Final public static Block PURPLE_BANNER;
    @Shadow @Final public static Block BLUE_BANNER;
    @Shadow @Final public static Block BROWN_BANNER;
    @Shadow @Final public static Block GREEN_BANNER;
    @Shadow @Final public static Block RED_BANNER;
    @Shadow @Final public static Block BLACK_BANNER;
    @Unique
    private static Map<String, Supplier<Block>> moreWaterlogged$conversionMap;
    @Unique
    private static Map<String, Supplier<Block>> moreWaterlogged$bannerMap;
    @Unique
    private static boolean moreWaterlogged$hasInitialized = false;

    @Unique
    private static void moreWaterlogged$initialize() {
        moreWaterlogged$conversionMap = new HashMap<>();
        moreWaterlogged$conversionMap.put("white_bed", () -> moreWaterlogged$bed(DyeColor.WHITE));
        moreWaterlogged$conversionMap.put("orange_bed", () -> moreWaterlogged$bed(DyeColor.ORANGE));
        moreWaterlogged$conversionMap.put("magenta_bed", () -> moreWaterlogged$bed(DyeColor.MAGENTA));
        moreWaterlogged$conversionMap.put("light_blue_bed", () -> moreWaterlogged$bed(DyeColor.LIGHT_BLUE));
        moreWaterlogged$conversionMap.put("yellow_bed", () -> moreWaterlogged$bed(DyeColor.YELLOW));
        moreWaterlogged$conversionMap.put("lime_bed", () -> moreWaterlogged$bed(DyeColor.LIME));
        moreWaterlogged$conversionMap.put("pink_bed", () -> moreWaterlogged$bed(DyeColor.PINK));
        moreWaterlogged$conversionMap.put("gray_bed", () -> moreWaterlogged$bed(DyeColor.GRAY));
        moreWaterlogged$conversionMap.put("light_gray_bed", () -> moreWaterlogged$bed(DyeColor.LIGHT_GRAY));
        moreWaterlogged$conversionMap.put("cyan_bed", () -> moreWaterlogged$bed(DyeColor.CYAN));
        moreWaterlogged$conversionMap.put("purple_bed", () -> moreWaterlogged$bed(DyeColor.PURPLE));
        moreWaterlogged$conversionMap.put("blue_bed", () -> moreWaterlogged$bed(DyeColor.BLUE));
        moreWaterlogged$conversionMap.put("brown_bed", () -> moreWaterlogged$bed(DyeColor.BROWN));
        moreWaterlogged$conversionMap.put("green_bed", () -> moreWaterlogged$bed(DyeColor.GREEN));
        moreWaterlogged$conversionMap.put("red_bed", () -> moreWaterlogged$bed(DyeColor.RED));
        moreWaterlogged$conversionMap.put("black_bed", () -> moreWaterlogged$bed(DyeColor.BLACK));
        moreWaterlogged$conversionMap.put("white_banner", () -> moreWaterlogged$banner(DyeColor.WHITE));
        moreWaterlogged$conversionMap.put("orange_banner", () -> moreWaterlogged$banner(DyeColor.ORANGE));
        moreWaterlogged$conversionMap.put("magenta_banner", () -> moreWaterlogged$banner(DyeColor.MAGENTA));
        moreWaterlogged$conversionMap.put("light_blue_banner", () -> moreWaterlogged$banner(DyeColor.LIGHT_BLUE));
        moreWaterlogged$conversionMap.put("yellow_banner", () -> moreWaterlogged$banner(DyeColor.YELLOW));
        moreWaterlogged$conversionMap.put("lime_banner", () -> moreWaterlogged$banner(DyeColor.LIME));
        moreWaterlogged$conversionMap.put("pink_banner", () -> moreWaterlogged$banner(DyeColor.PINK));
        moreWaterlogged$conversionMap.put("gray_banner", () -> moreWaterlogged$banner(DyeColor.GRAY));
        moreWaterlogged$conversionMap.put("light_gray_banner", () -> moreWaterlogged$banner(DyeColor.LIGHT_GRAY));
        moreWaterlogged$conversionMap.put("cyan_banner", () -> moreWaterlogged$banner(DyeColor.CYAN));
        moreWaterlogged$conversionMap.put("purple_banner", () -> moreWaterlogged$banner(DyeColor.PURPLE));
        moreWaterlogged$conversionMap.put("blue_banner", () -> moreWaterlogged$banner(DyeColor.BLUE));
        moreWaterlogged$conversionMap.put("brown_banner", () -> moreWaterlogged$banner(DyeColor.BROWN));
        moreWaterlogged$conversionMap.put("green_banner", () -> moreWaterlogged$banner(DyeColor.GREEN));
        moreWaterlogged$conversionMap.put("red_banner", () -> moreWaterlogged$banner(DyeColor.RED));
        moreWaterlogged$conversionMap.put("black_banner", () -> moreWaterlogged$banner(DyeColor.BLACK));
        moreWaterlogged$conversionMap.put("white_wall_banner", () -> moreWaterlogged$wallBanner(DyeColor.WHITE, WHITE_BANNER));
        moreWaterlogged$conversionMap.put("orange_wall_banner", () -> moreWaterlogged$wallBanner(DyeColor.ORANGE, ORANGE_BANNER));
        moreWaterlogged$conversionMap.put("magenta_wall_banner", () -> moreWaterlogged$wallBanner(DyeColor.MAGENTA, MAGENTA_BANNER));
        moreWaterlogged$conversionMap.put("light_blue_wall_banner", () -> moreWaterlogged$wallBanner(DyeColor.LIGHT_BLUE, LIGHT_BLUE_BANNER));
        moreWaterlogged$conversionMap.put("yellow_wall_banner", () -> moreWaterlogged$wallBanner(DyeColor.YELLOW, YELLOW_BANNER));
        moreWaterlogged$conversionMap.put("lime_wall_banner", () -> moreWaterlogged$wallBanner(DyeColor.LIME, LIME_BANNER));
        moreWaterlogged$conversionMap.put("pink_wall_banner", () -> moreWaterlogged$wallBanner(DyeColor.PINK, PINK_BANNER));
        moreWaterlogged$conversionMap.put("gray_wall_banner", () -> moreWaterlogged$wallBanner(DyeColor.GRAY, GRAY_BANNER));
        moreWaterlogged$conversionMap.put("light_gray_wall_banner", () -> moreWaterlogged$wallBanner(DyeColor.LIGHT_GRAY, LIGHT_GRAY_BANNER));
        moreWaterlogged$conversionMap.put("cyan_wall_banner", () -> moreWaterlogged$wallBanner(DyeColor.CYAN, CYAN_BANNER));
        moreWaterlogged$conversionMap.put("purple_wall_banner", () -> moreWaterlogged$wallBanner(DyeColor.PURPLE, PURPLE_BANNER));
        moreWaterlogged$conversionMap.put("blue_wall_banner", () -> moreWaterlogged$wallBanner(DyeColor.BLUE, BLUE_BANNER));
        moreWaterlogged$conversionMap.put("brown_wall_banner", () -> moreWaterlogged$wallBanner(DyeColor.BROWN, BROWN_BANNER));
        moreWaterlogged$conversionMap.put("green_wall_banner", () -> moreWaterlogged$wallBanner(DyeColor.GREEN, GREEN_BANNER));
        moreWaterlogged$conversionMap.put("red_wall_banner", () -> moreWaterlogged$wallBanner(DyeColor.RED, RED_BANNER));
        moreWaterlogged$conversionMap.put("black_wall_banner", () -> moreWaterlogged$wallBanner(DyeColor.BLACK, BLACK_BANNER));
        moreWaterlogged$conversionMap.put("anvil", MixinBlocks::moreWaterlogged$anvil);
        moreWaterlogged$conversionMap.put("chipped_anvil", MixinBlocks::moreWaterlogged$anvil);
        moreWaterlogged$conversionMap.put("damaged_anvil", MixinBlocks::moreWaterlogged$anvil);
        moreWaterlogged$conversionMap.put("bell", MixinBlocks::moreWaterlogged$bell);
        moreWaterlogged$conversionMap.put("brewing_stand", MixinBlocks::moreWaterlogged$brewingStand);
        moreWaterlogged$conversionMap.put("enchanting_table", MixinBlocks::moreWaterlogged$enchantmentTable);
        moreWaterlogged$conversionMap.put("nether_portal", MixinBlocks::moreWaterlogged$netherPortal);
        moreWaterlogged$conversionMap.put("lectern", MixinBlocks::moreWaterlogged$lectern);
        moreWaterlogged$conversionMap.put("stonecutter", MixinBlocks::moreWaterlogged$stonecutter);
        moreWaterlogged$conversionMap.put("grindstone", MixinBlocks::moreWaterlogged$grindstone);
        moreWaterlogged$conversionMap.put("hopper", MixinBlocks::moreWaterlogged$hopper);
    }

    @Unique
    private static BedBlock moreWaterlogged$bed(DyeColor pColor) {
        return new BedBlock(pColor, BlockBehaviour.Properties.of().mapColor((p_284863_) -> {
            return p_284863_.getValue(BedBlock.PART) == BedPart.FOOT ? pColor.getMapColor() : MapColor.WOOL;
        }).sound(SoundType.WOOD).strength(0.2F).noOcclusion().ignitedByLava().pushReaction(PushReaction.DESTROY));
    }

    @Unique
    private static BannerBlock moreWaterlogged$banner(DyeColor pColor) {
        return new BannerBlock(pColor, BlockBehaviour.Properties.of().mapColor(MapColor.WOOD).forceSolidOn()
                .instrument(NoteBlockInstrument.BASS).noCollission().strength(1.0F)
                .sound(SoundType.WOOD).ignitedByLava());
    }

    @Unique
    private static WallBannerBlock moreWaterlogged$wallBanner(DyeColor pColor, Block standingBanner) {
        return new WallBannerBlock(pColor, BlockBehaviour.Properties.of().mapColor(MapColor.WOOD).forceSolidOn()
                .instrument(NoteBlockInstrument.BASS).noCollission().strength(1.0F).sound(SoundType.WOOD)
                .dropsLike(standingBanner).ignitedByLava());
    }

    @Unique
    private static AnvilBlock moreWaterlogged$anvil() {
        return new AnvilBlock(BlockBehaviour.Properties.of().mapColor(MapColor.METAL)
                .requiresCorrectToolForDrops().strength(5.0F, 1200.0F)
                .sound(SoundType.ANVIL).pushReaction(PushReaction.BLOCK));
    }

    @Unique
    private static BellBlock moreWaterlogged$bell() {
        return new BellBlock(BlockBehaviour.Properties.of().mapColor(MapColor.GOLD).forceSolidOn()
                .requiresCorrectToolForDrops().strength(5.0F)
                .sound(SoundType.ANVIL).pushReaction(PushReaction.DESTROY));
    }

    @Unique
    private static BrewingStandBlock moreWaterlogged$brewingStand() {
        return new BrewingStandBlock(BlockBehaviour.Properties.of().mapColor(MapColor.METAL).requiresCorrectToolForDrops().strength(0.5F)
                .lightLevel((p_50872_) -> {
            return 1;
        }).noOcclusion());
    }

    @Unique
    private static EnchantmentTableBlock moreWaterlogged$enchantmentTable() {
        return new EnchantmentTableBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_RED).instrument(NoteBlockInstrument.BASEDRUM)
                .requiresCorrectToolForDrops().lightLevel((p_50874_) -> {
            return 7;
        }).strength(5.0F, 1200.0F));
    }

    @Unique
    private static NetherPortalBlock moreWaterlogged$netherPortal() {
        return new NetherPortalBlock(BlockBehaviour.Properties.of().noCollission().randomTicks().strength(-1.0F).sound(SoundType.GLASS)
                .lightLevel((p_152605_) -> {
            return 11;
        }).pushReaction(PushReaction.BLOCK));
    }

    @Unique
    private static LecternBlock moreWaterlogged$lectern() {
        return new LecternBlock(BlockBehaviour.Properties.of().mapColor(MapColor.WOOD).instrument(NoteBlockInstrument.BASS).strength(2.5F)
                .sound(SoundType.WOOD).ignitedByLava());
    }

    @Unique
    private static StonecutterBlock moreWaterlogged$stonecutter() {
        return new StonecutterBlock(BlockBehaviour.Properties.of().mapColor(MapColor.STONE).instrument(NoteBlockInstrument.BASEDRUM)
                .requiresCorrectToolForDrops().strength(3.5F));
    }

    @Unique
    private static GrindstoneBlock moreWaterlogged$grindstone() {
        return new GrindstoneBlock(BlockBehaviour.Properties.of().mapColor(MapColor.METAL).requiresCorrectToolForDrops().strength(2.0F, 6.0F)
                .sound(SoundType.STONE).pushReaction(PushReaction.BLOCK));
    }

    @Unique
    private static HopperBlock moreWaterlogged$hopper() {
        return new HopperBlock(BlockBehaviour.Properties.of().mapColor(MapColor.STONE).requiresCorrectToolForDrops().strength(3.0F, 4.8F)
                .sound(SoundType.METAL).noOcclusion());
    }

    /**
     * @author Zenesta
     * @reason Test
     */
    @Overwrite
    public static Block register(String pKey, Block pBlock) {
        if (!moreWaterlogged$hasInitialized) {
            moreWaterlogged$initialize();
            moreWaterlogged$hasInitialized = true;
        }
        if (moreWaterlogged$conversionMap.containsKey(pKey)) {
            Registry.register(BuiltInRegistries.BLOCK, pKey + "_deprecated", pBlock);
            return (Block) Registry.register(BuiltInRegistries.BLOCK, pKey, moreWaterlogged$conversionMap.get(pKey).get());
        }
        else
            return (Block) Registry.register(BuiltInRegistries.BLOCK, pKey, pBlock);
    }
}
