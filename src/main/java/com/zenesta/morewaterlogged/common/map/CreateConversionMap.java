package com.zenesta.morewaterlogged.common.map;

import com.tterrag.registrate.util.nullness.NonNullFunction;
import com.zenesta.morewaterlogged.common.MoreWaterlogged;
import com.zenesta.morewaterlogged.common.block.create.*;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;

public class CreateConversionMap extends RegistrateConversionMap {
    public static CreateConversionMap instance = null;

    public CreateConversionMap() {
        super(MoreWaterlogged.CREATE_MOD_ID);
        instance = this;
    }

    @SuppressWarnings("unchecked")
    @Override
    public void initialize() {
        // Processing
        conversionMap.put("basin", BasinBlock::new);
        conversionMap.put("crushing_wheel", CrushingWheelBlock::new);
        conversionMap.put("mechanical_mixer", MechanicalMixerBlock::new);
        conversionMap.put("mechanical_press", MechanicalPressBlock::new);
        conversionMap.put("millstone", MillstoneBlock::new);
        conversionMap.put("blaze_burner", BlazeBurnerBlock::new);

        // Kinetic
        conversionMap.put("creative_motor", CreativeMotorBlock::new);

        conversionMap.put("adjustable_chain_gearshift", ChainGearshiftBlock::new);
        conversionMap.put("clutch", ClutchBlock::new);
        conversionMap.put("encased_chain_drive", ChainDriveBlock::new);
        conversionMap.put("gearbox", GearboxBlock::new);
        conversionMap.put("gearshift", GearshiftBlock::new);
        conversionMap.put("sequenced_gearshift", SequencedGearshiftBlock::new);

        conversionMap.put("encased_fan", EncasedFanBlock::new);
        conversionMap.put("turntable", TurntableBlock::new);

        conversionMap.put("speedometer", GaugeBlock::speed);
        conversionMap.put("stressometer", GaugeBlock::stress);

        conversionMap.put("cuckoo_clock", CuckooClockBlock::regular);
        conversionMap.put("mysterious_cuckoo_clock", CuckooClockBlock::mysterious);

        conversionMap.put("gantry_shaft", GantryShaftBlock::new);

        conversionMap.put("mechanical_saw", SawBlock::new);

        conversionMap.put("deployer", DeployerBlock::new);

        conversionMap.put("mechanical_crafter", MechanicalCrafterBlock::new);

        conversionMap.put("flywheel", FlywheelBlock::new);

        conversionMap.put("rotation_speed_controller", SpeedControllerBlock::new);

        conversionMap.put("mechanical_arm", ArmBlock::new);

        // Logistic
        conversionMap.put("smart_chute", SmartChuteBlock::new);

        conversionMap.put("creative_crate", CreativeCrateBlock::new);

        // Fluid
        conversionMap.put("fluid_tank", FluidTankBlock::regular);
        conversionMap.put("creative_fluid_tank", FluidTankBlock::creative);

        conversionMap.put("hose_pulley", HosePulleyBlock::new);
        conversionMap.put("item_drain", ItemDrainBlock::new);
        conversionMap.put("spout", SpoutBlock::new);

        // Contraptions
        conversionMap.put("mechanical_piston", MechanicalPistonBlock::normal);
        conversionMap.put("sticky_mechanical_piston", MechanicalPistonBlock::sticky);

        conversionMap.put("gantry_carriage", GantryCarriageBlock::new);

        conversionMap.put("mechanical_bearing", MechanicalBearingBlock::new);
        conversionMap.put("clockwork_bearing", MechanicalBearingBlock::new);

        conversionMap.put("rope_pulley", PulleyBlock::new);
        conversionMap.put("elevator_pulley", ElevatorPulleyBlock::new);
        conversionMap.put("elevator_contact", ElevatorContactBlock::new);

        conversionMap.put("sticker", StickerBlock::new);

        // Stress Generator
        conversionMap.put("water_wheel", WaterWheelBlock::new);
        conversionMap.put("large_water_wheel", LargeWaterWheelBlock::new);
        conversionMap.put("water_wheel_structure", WaterWheelStructuralBlock::new);

        conversionMap.put("windmill_bearing", WindmillBearingBlock::new);
        conversionMap.put("sail_frame", SailBlock::frame);
        for (DyeColor colour : DyeColor.values())
            conversionMap.put(colour.getSerializedName() + "_sail", (properties) -> SailBlock.withCanvas(properties, colour));

        // Redstone
        conversionMap.put("redstone_contact", RedstoneContactBlock::new);
        conversionMap.put("content_observer", SmartObserverBlock::new);
        conversionMap.put("stockpile_switch", ThresholdSwitchBlock::new);
        conversionMap.put("display_link", DisplayLinkBlock::new);
        conversionMap.put("redstone_link", RedstoneLinkBlock::new);

        // Equipment
        conversionMap.put("peculiar_bell", PeculiarBellBlock::new);
        conversionMap.put("haunted_bell", HauntedBellBlock::new);

        // Decoration
        conversionMap.put("steam_whistle", WhistleBlock::new);
        conversionMap.put("steam_whistle_extension", WhistleExtenderBlock::new);

        conversionMap.put("andesite_door", (properties) -> SlidingDoorBlock.metal(properties, true));
        conversionMap.put("brass_door", (properties) -> SlidingDoorBlock.metal(properties, false));
        conversionMap.put("copper_door", (properties) -> SlidingDoorBlock.metal(properties, true));
        conversionMap.put("train_door", (properties) -> SlidingDoorBlock.metal(properties, false));
        conversionMap.put("framed_glass_door", (properties) -> SlidingDoorBlock.glass(properties, false));

        postInitialize(conversionMap.keySet());

        hasInitialized = true;
    }
}
