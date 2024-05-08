package com.zenesta.morewaterlogged.mixin;

import com.simibubi.create.AllBlocks;
import com.zenesta.morewaterlogged.common.block.create.*;
import com.tterrag.registrate.util.entry.BlockEntry;
import com.zenesta.morewaterlogged.common.map.CreateConversionMap;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.List;
import java.util.Set;

@Mixin(AllBlocks.class)
public class MixinCreateAllBlocks {
    /*
    @Unique
    private static CreateConversionMap moreWaterlogged$map;

    @Inject(method = "<clinit>", at = @At("HEAD"))
    private static void constructorHead(CallbackInfo ci) {
        moreWaterlogged$map = new CreateConversionMap();
    }

    @SuppressWarnings("unchecked") @Shadow(remap = false)
    public static final BlockEntry<BasinBlock> BASIN = (BlockEntry<BasinBlock>) moreWaterlogged$map.convert("basin");

    @SuppressWarnings("unchecked") @Shadow(remap = false)
    public static final BlockEntry<CrushingWheelBlock> CRUSHING_WHEEL = (BlockEntry<CrushingWheelBlock>) moreWaterlogged$map.convert("crushing_wheel");
    @SuppressWarnings("unchecked") @Shadow(remap = false)
    public static final BlockEntry<MechanicalMixerBlock> MECHANICAL_MIXER = (BlockEntry<MechanicalMixerBlock>) moreWaterlogged$map.convert("mechanical_mixer");
    @SuppressWarnings("unchecked") @Shadow(remap = false)
    public static final BlockEntry<MechanicalPressBlock> MECHANICAL_PRESS = (BlockEntry<MechanicalPressBlock>) moreWaterlogged$map.convert("mechanical_press");
    @SuppressWarnings("unchecked") @Shadow(remap = false)
    public static final BlockEntry<BlazeBurnerBlock> BLAZE_BURNER = (BlockEntry<BlazeBurnerBlock>) moreWaterlogged$map.convert("blaze_burner");
    @SuppressWarnings("unchecked") @Shadow(remap = false)
    public static final BlockEntry<ChainGearshiftBlock> ADJUSTABLE_CHAIN_GEARSHIFT = (BlockEntry<ChainGearshiftBlock>) moreWaterlogged$map.convert("adjustable_chain_gearshift");

    @SuppressWarnings("unchecked") @Shadow(remap = false)
    public static final BlockEntry<ClutchBlock> CLUTCH = (BlockEntry<ClutchBlock>) moreWaterlogged$map.convert("clutch");

    @SuppressWarnings("unchecked") @Shadow(remap = false)
    public static final BlockEntry<ChainDriveBlock> ENCASED_CHAIN_DRIVE = (BlockEntry<ChainDriveBlock>) moreWaterlogged$map.convert("encased_chain_drive");
    @SuppressWarnings("unchecked") @Shadow(remap = false)
    public static final BlockEntry<GearboxBlock> GEARBOX = (BlockEntry<GearboxBlock>) moreWaterlogged$map.convert("gearbox");

    @SuppressWarnings("unchecked") @Shadow(remap = false)
    public static final BlockEntry<GearshiftBlock> GEARSHIFT = (BlockEntry<GearshiftBlock>) moreWaterlogged$map.convert("gearshift");
    */
}

