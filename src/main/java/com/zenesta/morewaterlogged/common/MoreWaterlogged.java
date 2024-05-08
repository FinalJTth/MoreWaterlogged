package com.zenesta.morewaterlogged.common;

import com.simibubi.create.Create;
import net.minecraftforge.common.ForgeHooks;
import net.minecraftforge.common.ForgeMod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.loading.LoadingModList;
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
            LOGGER.debug("Displaying Mod List ...");
            for (String modname : ForgeHooks.getModPacks()) {
                LOGGER.debug("Mod : {}", modname);
            }
            for (String modname : ForgeHooks.getModPacksWithVanilla()) {
                LOGGER.debug("ModVanilla : {}", modname);
            }
            // ModNe
        }

        @SubscribeEvent
        public static void register(final RegisterEvent event) {
            /*
            BlockBehaviour.Properties mechanicalPressProps = BlockBehaviour.Properties.of().noOcclusion().mapColor(MapColor.PODZOL);
            event.register(ForgeRegistries.Keys.BLOCKS, (helper) -> helper.register(new ResourceLocation("create", "mechanical_press"), new MechanicalPressBlock(mechanicalPressProps)));
            */
        }
    }
}
