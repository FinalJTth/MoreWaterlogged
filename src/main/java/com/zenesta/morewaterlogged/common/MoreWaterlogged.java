package com.zenesta.morewaterlogged.common;

import com.zenesta.morewaterlogged.common.config.ConvertConfig;
import com.zenesta.morewaterlogged.common.map.CreateConversionMap;
import com.zenesta.morewaterlogged.common.map.MinecraftConversionMap;
import net.minecraftforge.common.ForgeHooks;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.loading.LoadingModList;
import net.minecraftforge.fml.loading.moddiscovery.ModInfo;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

@Mod("morewaterlogged")
public class MoreWaterlogged {
    public static final String MOD_ID = "morewaterlogged";
    public static final Logger LOGGER = LogManager.getLogger(MOD_ID);

    public static final List<String> SUPPORTED_MODS = List.of("minecraft", "create");
    public static final List<String> INSTALLED_SUPPORTED_MODS = new ArrayList<>();

    public MoreWaterlogged() {
        for (String modname : LoadingModList.get().getMods().stream().map(ModInfo::getModId).toList()) {
            if (SUPPORTED_MODS.contains(modname)) {
                INSTALLED_SUPPORTED_MODS.add(modname);
                LOGGER.debug("Supported mod \"{}\" detected. Will convert mapped blocks to its waterlogged counterpart", modname);
            }
        }
        ConvertConfig.initialize();
    }

    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class CommonModEvents {
        @SubscribeEvent
        public static void commonSetup(final FMLCommonSetupEvent event) {
            // ModNe
        }
    }
}
