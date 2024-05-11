package com.zenesta.morewaterlogged.mixin.generic;

import com.zenesta.morewaterlogged.common.MoreWaterlogged;
import com.zenesta.morewaterlogged.common.map.AlchemistryConversionMap;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.Map;
import java.util.Objects;
import java.util.function.Supplier;

@Mixin(DeferredRegister.class)
public class MixinDeferredRegister<T> {
    @Shadow(remap = false) @Final
    private ResourceKey<? extends Registry<T>> registryKey;
    @Shadow(remap = false) @Final
    private String modid;
    @Shadow(remap = false) @Final
    private Map<RegistryObject<T>, Supplier<? extends T>> entries;
    @Shadow(remap = false) @Final
    private boolean optionalRegistry;
    @Shadow(remap = false)
    private boolean seenRegisterEvent;

    @Inject(method = "<init>*", at = @At("TAIL"))
    private void staticHead(CallbackInfo ci) {
        if (AlchemistryConversionMap.instance == null)
            new AlchemistryConversionMap();
    }

    /**
     * @author Zenesta
     * @reason test
     */
    @SuppressWarnings("unchecked")
    @Overwrite(remap = false)
    public <I extends T> RegistryObject<I> register(String name, Supplier<? extends I> sup) {
        if (registryKey.equals(ForgeRegistries.BLOCKS.getRegistryKey()) && modid.equals(MoreWaterlogged.ALCHEMISTRY_MOD_ID)) {
           sup = (Supplier<? extends I>) AlchemistryConversionMap.instance.convert(name, (Supplier<Block>) sup);
        }
        if (this.seenRegisterEvent) {
            throw new IllegalStateException("Cannot register new entries to DeferredRegister after RegisterEvent has been fired.");
        } else {
            Objects.requireNonNull(name);
            Objects.requireNonNull(sup);
            ResourceLocation key = new ResourceLocation(this.modid, name);
            if (this.registryKey != null) {
                RegistryObject<I> ret = this.optionalRegistry ? RegistryObject.createOptional(key, this.registryKey, this.modid) : RegistryObject.create(key, this.registryKey, this.modid);
                if (this.entries.putIfAbsent((RegistryObject<T>) ret, sup) != null) {
                    throw new IllegalArgumentException("Duplicate registration " + name);
                } else {
                    return ret;
                }
            } else {
                throw new IllegalStateException("Could not create RegistryObject in DeferredRegister");
            }
        }
    }
}
