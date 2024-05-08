package com.zenesta.morewaterlogged.common.map;

import com.simibubi.create.content.decoration.slidingDoor.SlidingDoorBlock;
import com.tterrag.registrate.util.nullness.NonNullFunction;
import com.zenesta.morewaterlogged.common.block.create.*;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Supplier;

public class CreateConversionMap extends ConversionMap {
    public static final String MOD_ID = "create";
    public static final Map<String, Supplier<NonNullFunction<BlockBehaviour.Properties, Block>>> CONVERSION_MAP = new LinkedHashMap<>();
    public static boolean hasInitialized = false;

    @SuppressWarnings("unchecked")
    public static void initialize() {
        hasInitialized = true;
        // Processing
        CONVERSION_MAP.put("basin", () -> BasinBlock::new);
        CONVERSION_MAP.put("crushing_wheel", () -> CrushingWheelBlock::new);
        CONVERSION_MAP.put("mechanical_mixer", () -> MechanicalMixerBlock::new);
        CONVERSION_MAP.put("mechanical_press", () -> MechanicalPressBlock::new);
        CONVERSION_MAP.put("millstone", () -> MillstoneBlock::new);
        CONVERSION_MAP.put("blaze_burner", () -> BlazeBurnerBlock::new);

        // Kinetic
        CONVERSION_MAP.put("creative_motor", () -> CreativeMotorBlock::new);

        CONVERSION_MAP.put("adjustable_chain_gearshift", () -> ChainGearshiftBlock::new);
        CONVERSION_MAP.put("clutch", () -> ClutchBlock::new);
        CONVERSION_MAP.put("encased_chain_drive", () -> ChainDriveBlock::new);
        CONVERSION_MAP.put("gearbox", () -> GearboxBlock::new);
        CONVERSION_MAP.put("gearshift", () -> GearshiftBlock::new);
        CONVERSION_MAP.put("sequenced_gearshift", () -> SequencedGearshiftBlock::new);

        CONVERSION_MAP.put("encased_fan", () -> EncasedFanBlock::new);
        CONVERSION_MAP.put("turntable", () -> TurntableBlock::new);

        CONVERSION_MAP.put("speedometer", () -> GaugeBlock::speed);
        CONVERSION_MAP.put("stressometer", () -> GaugeBlock::stress);

        CONVERSION_MAP.put("cuckoo_clock", () -> CuckooClockBlock::regular);
        CONVERSION_MAP.put("mysterious_cuckoo_clock", () -> CuckooClockBlock::mysterious);

        CONVERSION_MAP.put("gantry_shaft", () -> GantryShaftBlock::new);

        CONVERSION_MAP.put("mechanical_saw", () -> SawBlock::new);

        CONVERSION_MAP.put("deployer", () -> DeployerBlock::new);

        CONVERSION_MAP.put("mechanical_crafter", () -> MechanicalCrafterBlock::new);

        CONVERSION_MAP.put("flywheel", () -> FlywheelBlock::new);

        CONVERSION_MAP.put("rotation_speed_controller", () -> SpeedControllerBlock::new);

        CONVERSION_MAP.put("mechanical_arm", () -> ArmBlock::new);

        // Logistic
        CONVERSION_MAP.put("smart_chute", () -> SmartChuteBlock::new);

        CONVERSION_MAP.put("creative_crate", () -> CreativeCrateBlock::new);

        // Fluid
        CONVERSION_MAP.put("fluid_tank", () -> FluidTankBlock::regular);
        CONVERSION_MAP.put("creative_fluid_tank", () -> FluidTankBlock::creative);

        CONVERSION_MAP.put("hose_pulley", () -> HosePulleyBlock::new);
        CONVERSION_MAP.put("item_drain", () -> ItemDrainBlock::new);
        CONVERSION_MAP.put("spout", () -> SpoutBlock::new);

        // Contraptions
        CONVERSION_MAP.put("mechanical_piston", () -> MechanicalPistonBlock::normal);
        CONVERSION_MAP.put("sticky_mechanical_piston", () -> MechanicalPistonBlock::sticky);

        CONVERSION_MAP.put("gantry_carriage", () -> GantryCarriageBlock::new);

        CONVERSION_MAP.put("mechanical_bearing", () -> MechanicalBearingBlock::new);
        CONVERSION_MAP.put("clockwork_bearing", () -> MechanicalBearingBlock::new);

        CONVERSION_MAP.put("rope_pulley", () -> PulleyBlock::new);
        CONVERSION_MAP.put("elevator_pulley", () -> ElevatorPulleyBlock::new);
        CONVERSION_MAP.put("elevator_contact", () -> ElevatorContactBlock::new);

        CONVERSION_MAP.put("sticker", () -> StickerBlock::new);

        // Stress Generator
        CONVERSION_MAP.put("water_wheel", () -> WaterWheelBlock::new);
        CONVERSION_MAP.put("large_water_wheel", () -> LargeWaterWheelBlock::new);
        CONVERSION_MAP.put("water_wheel_structure", () -> WaterWheelStructuralBlock::new);

        CONVERSION_MAP.put("windmill_bearing", () -> WindmillBearingBlock::new);
        CONVERSION_MAP.put("sail_frame", () -> SailBlock::frame);
        for (DyeColor colour : DyeColor.values())
            CONVERSION_MAP.put(colour.getSerializedName() + "_sail", () -> (properties) -> SailBlock.withCanvas(properties, colour));

        // Redstone
        CONVERSION_MAP.put("redstone_contact", () -> RedstoneContactBlock::new);
        CONVERSION_MAP.put("content_observer", () -> SmartObserverBlock::new);
        CONVERSION_MAP.put("stockpile_switch", () -> ThresholdSwitchBlock::new);
        CONVERSION_MAP.put("display_link", () -> DisplayLinkBlock::new);
        CONVERSION_MAP.put("redstone_link", () -> RedstoneLinkBlock::new);

        // Equipment
        CONVERSION_MAP.put("peculiar_bell", () -> PeculiarBellBlock::new);
        CONVERSION_MAP.put("haunted_bell", () -> HauntedBellBlock::new);

        // Decoration
        CONVERSION_MAP.put("steam_whistle", () -> WhistleBlock::new);
        CONVERSION_MAP.put("steam_whistle_extension", () -> WhistleExtenderBlock::new);

        CONVERSION_MAP.put("andesite_door", () -> (properties) -> SlidingDoorBlock.metal(properties, true));
        CONVERSION_MAP.put("brass_door", () -> (properties) -> SlidingDoorBlock.metal(properties, false));
        CONVERSION_MAP.put("copper_door", () -> (properties) -> SlidingDoorBlock.metal(properties, true));
        CONVERSION_MAP.put("train_door", () -> (properties) -> SlidingDoorBlock.metal(properties, false));
        CONVERSION_MAP.put("framed_glass_door", () -> (properties) -> SlidingDoorBlock.glass(properties, false));

        if (!CONFIG_MAP.containsKey(MOD_ID)) {
            CONFIG_MAP.put(MOD_ID, new LinkedHashMap<>());
        }
        for (String key : CONVERSION_MAP.keySet()) {
            if (!CONFIG_MAP.get(MOD_ID).containsKey(key)) {
                MARKED_FOR_CONFIG_CREATION.set(true);
                CONFIG_MAP.get(MOD_ID).put(key, true);
            }
        }

        HAS_INITIALIZED_LIST.add(true);
    }

    @SuppressWarnings("unchecked")
    public static <T extends Block> NonNullFunction<BlockBehaviour.Properties, T> convert(String key, NonNullFunction<BlockBehaviour.Properties, T> factory) {
        if (CONVERSION_MAP.containsKey(key)) {
            log(key, MOD_ID);
            if (isKeyEnabled(key, MOD_ID)) {
                return (NonNullFunction<BlockBehaviour.Properties, T>) CONVERSION_MAP.get(key).get();
            }
        }
        return factory;
    }
}
