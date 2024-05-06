package com.zenesta.morewaterlogged.common.block.map;

import com.zenesta.morewaterlogged.common.block.AnvilBlock;
import com.zenesta.morewaterlogged.common.block.BedBlock;
import com.zenesta.morewaterlogged.common.block.BellBlock;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.BedPart;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;
import org.spongepowered.asm.mixin.Unique;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class ConversionMap {
    public static final Map<String, Supplier<Block>> CONVERSION_LIST = new HashMap<>();

    public static void initialize() {
        CONVERSION_LIST.put("white_bed", () -> bed(DyeColor.WHITE));
        CONVERSION_LIST.put("orange_bed", () -> bed(DyeColor.ORANGE));
        CONVERSION_LIST.put("magenta_bed", () -> bed(DyeColor.MAGENTA));
        CONVERSION_LIST.put("light_blue_bed", () -> bed(DyeColor.LIGHT_BLUE));
        CONVERSION_LIST.put("yellow_bed", () -> bed(DyeColor.YELLOW));
        CONVERSION_LIST.put("lime_bed", () -> bed(DyeColor.LIME));
        CONVERSION_LIST.put("pink_bed", () -> bed(DyeColor.PINK));
        CONVERSION_LIST.put("gray_bed", () -> bed(DyeColor.GRAY));
        CONVERSION_LIST.put("light_gray_bed", () -> bed(DyeColor.LIGHT_GRAY));
        CONVERSION_LIST.put("cyan_bed", () -> bed(DyeColor.CYAN));
        CONVERSION_LIST.put("purple_bed", () -> bed(DyeColor.PURPLE));
        CONVERSION_LIST.put("blue_bed", () -> bed(DyeColor.BLUE));
        CONVERSION_LIST.put("brown_bed", () -> bed(DyeColor.BROWN));
        CONVERSION_LIST.put("green_bed", () -> bed(DyeColor.GREEN));
        CONVERSION_LIST.put("red_bed", () -> bed(DyeColor.RED));
        CONVERSION_LIST.put("black_bed", () -> bed(DyeColor.BLACK));
        CONVERSION_LIST.put("anvil", ConversionMap::anvil);
        CONVERSION_LIST.put("chipped_anvil", ConversionMap::anvil);
        CONVERSION_LIST.put("damaged_anvil", ConversionMap::anvil);
        CONVERSION_LIST.put("bell", ConversionMap::bell);
    }

    private static BedBlock bed(DyeColor pColor) {
        return new BedBlock(pColor, BlockBehaviour.Properties.of().mapColor((p_284863_) -> {
            return p_284863_.getValue(BedBlock.PART) == BedPart.FOOT ? pColor.getMapColor() : MapColor.WOOL;
        }).sound(SoundType.WOOD).strength(0.2F).noOcclusion().ignitedByLava().pushReaction(PushReaction.DESTROY));
    }

    @Unique
    private static AnvilBlock anvil() {
        return new AnvilBlock(BlockBehaviour.Properties.of().mapColor(MapColor.METAL)
                .requiresCorrectToolForDrops().strength(5.0F, 1200.0F)
                .sound(SoundType.ANVIL).pushReaction(PushReaction.BLOCK));
    }

    @Unique
    private static BellBlock bell() {
        return new BellBlock(BlockBehaviour.Properties.of().mapColor(MapColor.GOLD).forceSolidOn()
                .requiresCorrectToolForDrops().strength(5.0F)
                .sound(SoundType.ANVIL).pushReaction(PushReaction.DESTROY));
    }
}
