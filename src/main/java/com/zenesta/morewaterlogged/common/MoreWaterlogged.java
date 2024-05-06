package com.zenesta.morewaterlogged.common;

import com.mojang.datafixers.types.Type;
import com.zenesta.morewaterlogged.common.block.AnvilBlock;
import com.zenesta.morewaterlogged.common.block.BedBlock;
import com.zenesta.morewaterlogged.common.block.BellBlock;
// import com.zenesta.morewaterlogged.common.block.renderer.BedRenderer;
import com.zenesta.morewaterlogged.common.block.map.ConversionMap;
import net.minecraft.Util;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderDispatcher;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.datafix.fixes.References;
import net.minecraft.world.item.DyeColor;
// import net.minecraft.world.level.block.BedBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SlabBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.BedPart;
import net.minecraft.world.level.chunk.LevelChunk;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLModContainer;
import net.minecraftforge.registries.*;
// import net.minecraft.client.renderer.blockentity.BedRenderer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import net.minecraft.world.level.block.entity.BellBlockEntity;
// import com.zenesta.morewaterlogged.common.block.entity.BellBlockEntity;
// import com.zenesta.morewaterlogged.common.block.entity.BedBlockEntity;
import net.minecraft.world.level.block.entity.BedBlockEntity;
import net.minecraft.client.renderer.blockentity.BedRenderer;

@Mod("morewaterlogged")
public class MoreWaterlogged {
    public static final String MOD_ID = "morewaterlogged";
    public static final Logger LOGGER = LogManager.getLogger(MOD_ID);

    /*
    static final BlockBehaviour.Properties bellProperties = BlockBehaviour.Properties.of().mapColor(MapColor.GOLD).forceSolidOn()
            .requiresCorrectToolForDrops().strength(5.0F)
            .sound(SoundType.ANVIL).pushReaction(PushReaction.DESTROY);

    public static final DeferredRegister<Block> REGISTER_BLOCK = DeferredRegister.create(ForgeRegistries.BLOCKS, "minecraft");
    public static final RegistryObject<Block> BELL_BLOCK = REGISTER_BLOCK.register("bell", () -> new BellBlock(bellProperties));
    public static final DeferredRegister<BlockEntityType<?>> REGISTER_BLOCK_ENTITY = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, "minecraft");
    public static final RegistryObject<BlockEntityType<BellBlockEntity>> BELL_BLOCK_ENTITY = REGISTER_BLOCK_ENTITY.register("bell", () -> BlockEntityType.Builder.of(BellBlockEntity::new, BELL_BLOCK.get()).build(null));
     */

    public static final RegistryObject<Block> BELL_BLOCK = RegistryObject.create(new ResourceLocation("minecraft:bell"), ForgeRegistries.BLOCKS);
    public static final RegistryObject<BlockEntityType<?>> BELL_BLOCK_ENTITY = RegistryObject.create(new ResourceLocation("minecraft:bell"), ForgeRegistries.BLOCK_ENTITY_TYPES);
    public static final BlockEntityType<BellBlockEntity> BELL_BLOCK_ENTITY_TYPE = (BlockEntityType<BellBlockEntity>) BELL_BLOCK_ENTITY.get();

    public static final RegistryObject<Block> WHITE_BED_BLOCK = RegistryObject.create(new ResourceLocation("minecraft:white_bed"), ForgeRegistries.BLOCKS);
    public static final RegistryObject<Block> ORANGE_BED_BLOCK = RegistryObject.create(new ResourceLocation("minecraft:orange_bed"), ForgeRegistries.BLOCKS);
    public static final RegistryObject<Block> MAGENTA_BED_BLOCK = RegistryObject.create(new ResourceLocation("minecraft:magenta_bed"), ForgeRegistries.BLOCKS);
    public static final RegistryObject<Block> LIGHT_BLUE_BED_BLOCK = RegistryObject.create(new ResourceLocation("minecraft:light_blue_bed"), ForgeRegistries.BLOCKS);
    public static final RegistryObject<Block> YELLOW_BED_BLOCK = RegistryObject.create(new ResourceLocation("minecraft:yellow_bed"), ForgeRegistries.BLOCKS);
    public static final RegistryObject<Block> LIME_BED_BLOCK = RegistryObject.create(new ResourceLocation("minecraft:lime_bed"), ForgeRegistries.BLOCKS);
    public static final RegistryObject<Block> PINK_BED_BLOCK = RegistryObject.create(new ResourceLocation("minecraft:pink_bed"), ForgeRegistries.BLOCKS);
    public static final RegistryObject<Block> GRAY_BED_BLOCK = RegistryObject.create(new ResourceLocation("minecraft:gray_bed"), ForgeRegistries.BLOCKS);
    public static final RegistryObject<Block> LIGHT_GRAY_BED_BLOCK = RegistryObject.create(new ResourceLocation("minecraft:light_gray_bed"), ForgeRegistries.BLOCKS);
    public static final RegistryObject<Block> CYAN_BED_BLOCK = RegistryObject.create(new ResourceLocation("minecraft:cyan_bed"), ForgeRegistries.BLOCKS);
    public static final RegistryObject<Block> PURPLE_BED_BLOCK = RegistryObject.create(new ResourceLocation("minecraft:purple_bed"), ForgeRegistries.BLOCKS);
    public static final RegistryObject<Block> BLUE_BED_BLOCK = RegistryObject.create(new ResourceLocation("minecraft:blue_bed"), ForgeRegistries.BLOCKS);
    public static final RegistryObject<Block> BROWN_BED_BLOCK = RegistryObject.create(new ResourceLocation("minecraft:brown_bed"), ForgeRegistries.BLOCKS);
    public static final RegistryObject<Block> GREEN_BED_BLOCK = RegistryObject.create(new ResourceLocation("minecraft:green_bed"), ForgeRegistries.BLOCKS);
    public static final RegistryObject<Block> RED_BED_BLOCK = RegistryObject.create(new ResourceLocation("minecraft:red_bed"), ForgeRegistries.BLOCKS);
    public static final RegistryObject<Block> BLACK_BED_BLOCK = RegistryObject.create(new ResourceLocation("minecraft:black_bed"), ForgeRegistries.BLOCKS);

    static final RegistryObject<BlockEntityType<?>> BED_BLOCK_ENTITY = RegistryObject.create(new ResourceLocation("minecraft:bed"), ForgeRegistries.BLOCK_ENTITY_TYPES);
    public static final BlockEntityType<BedBlockEntity> BED_BLOCK_ENTITY_TYPE = (BlockEntityType<BedBlockEntity>) BED_BLOCK_ENTITY.get();

    public MoreWaterlogged() {
        ConversionMap.initialize();
    }

    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void entityRenderersRegister(final EntityRenderersEvent.RegisterRenderers event) {
            event.registerBlockEntityRenderer(BED_BLOCK_ENTITY_TYPE, BedRenderer::new);
        }
    }

    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class CommonModEvents {
        @SubscribeEvent
        public static void register(final RegisterEvent event) {
            /*
            final BlockBehaviour.Properties anvilProperties = BlockBehaviour.Properties.of().mapColor(MapColor.METAL)
                    .requiresCorrectToolForDrops().strength(5.0F, 1200.0F)
                    .sound(SoundType.ANVIL).pushReaction(PushReaction.BLOCK);
            final BlockBehaviour.Properties chippedProperties = BlockBehaviour.Properties.of().mapColor(MapColor.METAL)
                    .requiresCorrectToolForDrops().strength(5.0F, 1200.0F)
                    .sound(SoundType.ANVIL).pushReaction(PushReaction.BLOCK);
            final BlockBehaviour.Properties damagedProperties = BlockBehaviour.Properties.of().mapColor(MapColor.METAL)
                    .requiresCorrectToolForDrops().strength(5.0F, 1200.0F)
                    .sound(SoundType.ANVIL).pushReaction(PushReaction.BLOCK);
            final BlockBehaviour.Properties bellProperties = BlockBehaviour.Properties.of().mapColor(MapColor.GOLD).forceSolidOn()
                    .requiresCorrectToolForDrops().strength(5.0F)
                    .sound(SoundType.ANVIL).pushReaction(PushReaction.DESTROY);

            event.register(ForgeRegistries.Keys.BLOCKS, (helper) -> helper.register(new ResourceLocation("minecraft:anvil"), new AnvilBlock(anvilProperties)));
            event.register(ForgeRegistries.Keys.BLOCKS, (helper) -> helper.register(new ResourceLocation("minecraft:chipped_anvil"), new AnvilBlock(chippedProperties)));
            event.register(ForgeRegistries.Keys.BLOCKS, (helper) -> helper.register(new ResourceLocation("minecraft:damaged_anvil"), new AnvilBlock(damagedProperties)));
            event.register(ForgeRegistries.Keys.BLOCKS, (helper) -> helper.register(new ResourceLocation("minecraft:bell"), new BellBlock(bellProperties)));
            // event.register(ForgeRegistries.Keys.BLOCKS, (helper) -> helper.register(new ResourceLocation("minecraft:white_bed"), bed(DyeColor.WHITE)));
            event.register(ForgeRegistries.Keys.BLOCKS, (helper) -> helper.register(new ResourceLocation("minecraft:orange_bed"), bed(DyeColor.ORANGE)));
            event.register(ForgeRegistries.Keys.BLOCKS, (helper) -> helper.register(new ResourceLocation("minecraft:magenta_bed"), bed(DyeColor.MAGENTA)));
            event.register(ForgeRegistries.Keys.BLOCKS, (helper) -> helper.register(new ResourceLocation("minecraft:light_blue_bed"), bed(DyeColor.LIGHT_BLUE)));
            event.register(ForgeRegistries.Keys.BLOCKS, (helper) -> helper.register(new ResourceLocation("minecraft:yellow_bed"), bed(DyeColor.YELLOW)));
            event.register(ForgeRegistries.Keys.BLOCKS, (helper) -> helper.register(new ResourceLocation("minecraft:lime_bed"), bed(DyeColor.LIME)));
            event.register(ForgeRegistries.Keys.BLOCKS, (helper) -> helper.register(new ResourceLocation("minecraft:pink_bed"), bed(DyeColor.PINK)));
            event.register(ForgeRegistries.Keys.BLOCKS, (helper) -> helper.register(new ResourceLocation("minecraft:gray_bed"), bed(DyeColor.GRAY)));
            event.register(ForgeRegistries.Keys.BLOCKS, (helper) -> helper.register(new ResourceLocation("minecraft:light_gray_bed"), bed(DyeColor.LIGHT_GRAY)));
            event.register(ForgeRegistries.Keys.BLOCKS, (helper) -> helper.register(new ResourceLocation("minecraft:cyan_bed"), bed(DyeColor.CYAN)));
            event.register(ForgeRegistries.Keys.BLOCKS, (helper) -> helper.register(new ResourceLocation("minecraft:purple_bed"), bed(DyeColor.PURPLE)));
            event.register(ForgeRegistries.Keys.BLOCKS, (helper) -> helper.register(new ResourceLocation("minecraft:blue_bed"), bed(DyeColor.BLUE)));
            event.register(ForgeRegistries.Keys.BLOCKS, (helper) -> helper.register(new ResourceLocation("minecraft:brown_bed"), bed(DyeColor.BROWN)));
            event.register(ForgeRegistries.Keys.BLOCKS, (helper) -> helper.register(new ResourceLocation("minecraft:green_bed"), bed(DyeColor.GREEN)));
            event.register(ForgeRegistries.Keys.BLOCKS, (helper) -> helper.register(new ResourceLocation("minecraft:red_bed"), bed(DyeColor.RED)));
            // event.register(ForgeRegistries.Keys.BLOCKS, (helper) -> helper.register(new ResourceLocation("minecraft:black_bed"), bed(DyeColor.BLACK)));

            Type<?> $$2 = Util.fetchChoiceType(References.BLOCK_ENTITY, "bell");
            event.register(ForgeRegistries.Keys.BLOCK_ENTITY_TYPES, (helper) -> helper.register(new ResourceLocation("minecraft:bell"), BlockEntityType.Builder.of(BellBlockEntity::new, BELL_BLOCK.get()).build($$2)));

            Type<?> $$2 = Util.fetchChoiceType(References.BLOCK_ENTITY, "bed");
            event.register(ForgeRegistries.Keys.BLOCK_ENTITY_TYPES, (helper) -> helper.register(new ResourceLocation("minecraft:bed"), BlockEntityType.Builder.of(BedBlockEntity::new,
                    WHITE_BED_BLOCK.get(), ORANGE_BED_BLOCK.get(), MAGENTA_BED_BLOCK.get(), LIGHT_BLUE_BED_BLOCK.get(), YELLOW_BED_BLOCK.get(), LIME_BED_BLOCK.get(), PINK_BED_BLOCK.get(),
                    GRAY_BED_BLOCK.get(), LIGHT_GRAY_BED_BLOCK.get(), CYAN_BED_BLOCK.get(), PURPLE_BED_BLOCK.get(), BLUE_BED_BLOCK.get(), BROWN_BED_BLOCK.get(), GREEN_BED_BLOCK.get(), RED_BED_BLOCK.get(), BLACK_BED_BLOCK.get())
                    .build($$2)));
            */
        }

        public static BedBlock bed(DyeColor pColor) {
            return new BedBlock(pColor, BlockBehaviour.Properties.of().mapColor((p_284863_) -> {
                return p_284863_.getValue(BedBlock.PART) == BedPart.FOOT ? pColor.getMapColor() : MapColor.WOOL;
            }).sound(SoundType.WOOD).strength(0.2F).noOcclusion().ignitedByLava().pushReaction(PushReaction.DESTROY));
        }
    }
}
