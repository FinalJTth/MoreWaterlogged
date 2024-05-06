package com.zenesta.morewaterlogged.common;

import com.zenesta.morewaterlogged.common.block.MechanicalPressBlock;
import net.minecraft.client.ClientBrandRetriever;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.internal.BrandingControl;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegisterEvent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod("morewaterlogged")
public class MoreWaterlogged {
    public static final String MOD_ID = "morewaterlogged";
    public static final Logger LOGGER = LogManager.getLogger(MOD_ID);

    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class CommonModEvents {
        @SubscribeEvent
        public static void commonSetup(final FMLCommonSetupEvent event) {
            // ModNe
        }

        @SubscribeEvent
        public static void register(final RegisterEvent event) {
            BlockBehaviour.Properties mechanicalPressProps = BlockBehaviour.Properties.of()..noOcclusion().mapColor(MapColor.PODZOL)
            event.register(ForgeRegistries.Keys.BLOCKS, (helper) -> helper.register(new ResourceLocation("create", "mechanical_press"), new MechanicalPressBlock()));
        }
    }
}
