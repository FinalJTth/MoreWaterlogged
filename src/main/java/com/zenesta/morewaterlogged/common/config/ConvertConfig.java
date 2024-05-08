package com.zenesta.morewaterlogged.common.config;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.zenesta.morewaterlogged.common.MoreWaterlogged;
import com.zenesta.morewaterlogged.common.map.ConversionMap;
import net.minecraftforge.fml.loading.FMLPaths;

import java.io.*;
import java.lang.reflect.Type;
import java.nio.file.Paths;
import java.util.Map;

import static com.zenesta.morewaterlogged.common.MoreWaterlogged.LOGGER;

public class ConvertConfig {
    public static final File FILE = Paths.get(FMLPaths.CONFIGDIR.get().toString(), MoreWaterlogged.MOD_ID + "-map.json").toFile();
    public static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();
    private static final Type REVIEW_TYPE = new TypeToken<Map<String, Map<String, Boolean>>>() {
    }.getType();

    public static void initialize() {
        if (!FILE.exists()) {
            createOrReplaceConfig();
            read();
        } else {
            read();
            createOrReplaceConfig();
        }
    }

    public static void read() {
        try {
            JsonReader reader = new JsonReader(new FileReader(FILE));
            Map<String, Map<String, Boolean>> loadedMapConfig = GSON.fromJson(reader, REVIEW_TYPE);
            if (loadedMapConfig != null && !loadedMapConfig.isEmpty())
                ConversionMap.CONFIG_MAP.putAll(loadedMapConfig);
        } catch (FileNotFoundException e) {
            LOGGER.error("{} This shouldn't happen in at all.", e.getMessage());
            LOGGER.error(e.getStackTrace());
        }
    }

    private static void createOrReplaceConfig() {
        Thread waitForDefaultConfig = new Thread(() -> {
            int i = 0;
            while (ConversionMap.HAS_INITIALIZED_LIST.size() != MoreWaterlogged.INSTALLED_SUPPORTED_MODS.size()) {
                if (i == 100000000) {
                    LOGGER.debug("Waiting for map initialization in mixin transformation.");
                    i = 0;
                }
                i++;
            }
            if (ConversionMap.MARKED_FOR_CONFIG_CREATION.get()) {
                LOGGER.debug("Config doesn't exist or is missing some entries. Creating one.");
                try {
                    Writer writer = new FileWriter(FILE);
                    FILE.createNewFile();
                    GSON.toJson(ConversionMap.CONFIG_MAP, writer);
                    writer.close();
                } catch (IOException e) {
                    LOGGER.error(e.getMessage());
                    LOGGER.error(e.getStackTrace());
                }
            }
        }, "morewaterlogged-config-worker");
        waitForDefaultConfig.start();
    }
}
