package com.zenesta.morewaterlogged.common.map;

import com.simibubi.create.content.kinetics.press.MechanicalPressBlock;
import com.tterrag.registrate.util.nullness.NonNullFunction;
import com.zenesta.morewaterlogged.common.block.create.*;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Supplier;

public class CreateConversionMap extends ConversionMap{
    public final Map<String, Supplier<NonNullFunction<BlockBehaviour.Properties, Block>>> CONVERSION_MAP = new LinkedHashMap<>();

    public CreateConversionMap() {
        initialize();
    }

    public void initialize() {
        /*
        Supplier<BlockEntry<?>> basin = () -> Create.REGISTRATE.block("basin", BasinBlock::new)
                .initialProperties(SharedProperties::stone).properties((p) -> {
                    return p.mapColor(MapColor.COLOR_GRAY).sound(SoundType.NETHERITE_BLOCK);
                })
                .transform(TagGen.pickaxeOnly()).blockstate(new BasinGenerator()::generate)
                .addLayer(() -> {
                    return RenderType::cutoutMipped;
                })
                .onRegister(AllMovementBehaviours.movementBehaviour(new BasinMovementBehaviour())).item()
                .transform(ModelGen.customItemModel(new String[]{"_", "block"}))
                .register();

        Supplier<BlockEntry<?>> crushingWheel = () -> Create.REGISTRATE.block("crushing_wheel", CrushingWheelBlock::new)
                .properties((p) -> {
                    return p.mapColor(MapColor.METAL);
                }).initialProperties(SharedProperties::stone).properties(BlockBehaviour.Properties::noOcclusion)
                .transform(TagGen.pickaxeOnly()).blockstate((c, p) -> {
                    BlockStateGen.axisBlock(c, p, (s) -> {
                        return AssetLookup.partialBaseModel(c, p, new String[0]);
                    });
                }).addLayer(() -> {
                    return RenderType::cutoutMipped;
                }).transform(BlockStressDefaults.setImpact(8.0)).item()
                .transform(ModelGen.customItemModel())
                .register();

        Supplier<BlockEntry<?>> mechanicalMixer = () -> Create.REGISTRATE.block("mechanical_mixer", MechanicalMixerBlock::new)
                .initialProperties(SharedProperties::stone).properties((p) -> {
                    return p.noOcclusion().mapColor(MapColor.STONE);
                }).transform(TagGen.axeOrPickaxe()).blockstate((c, p) -> {
                    p.simpleBlock(c.getEntry(), AssetLookup.partialBaseModel(c, p));
                }).addLayer(() -> {
                    return RenderType::cutoutMipped;
                })
                .transform(BlockStressDefaults.setImpact(4.0)).item(AssemblyOperatorBlockItem::new)
                .transform(ModelGen.customItemModel())
                .register();

        Supplier<BlockEntry<?>> mechanicalPress = () -> Create.REGISTRATE.block("mechanical_press", MechanicalPressBlock::new)
                .initialProperties(SharedProperties::stone).properties((p) -> {
                    return p.noOcclusion().mapColor(MapColor.PODZOL);
                })
                .transform(TagGen.axeOrPickaxe())
                .blockstate(BlockStateGen.horizontalBlockProvider(true))
                .transform(BlockStressDefaults.setImpact(8.0)).item(AssemblyOperatorBlockItem::new)
                .transform(ModelGen.customItemModel())
                .register();

        Supplier<BlockEntry<?>> chainGearshift = () -> Create.REGISTRATE.block("adjustable_chain_gearshift", ChainGearshiftBlock::new)
                .initialProperties(SharedProperties::stone).properties((p) -> {
                    return p.noOcclusion().mapColor(MapColor.NETHER);
                }).transform(BlockStressDefaults.setNoImpact())
                .transform(TagGen.axeOrPickaxe()).blockstate((c, p) -> {
                    (new ChainDriveGenerator((state, suffix) -> {
                        String powered = (Boolean)state.getValue(ChainGearshiftBlock.POWERED) ? "_powered" : "";
                        BlockModelBuilder var10000 = (BlockModelBuilder)p.models().withExistingParent(c.getName() + "_" + suffix + powered, p.modLoc("block/encased_chain_drive/" + suffix));
                        String var10003 = c.getName();
                        return var10000.texture("side", p.modLoc("block/" + var10003 + powered));
                    })).generate(c, p);
                }).item().model((c, p) -> {
                    ((ItemModelBuilder)p.withExistingParent(c.getName(), p.modLoc("block/encased_chain_drive/item"))).texture("side", p.modLoc("block/" + c.getName()));
                }).build()
                .register();

        Supplier<BlockEntry<?>> clutch = () -> Create.REGISTRATE.block("clutch", ClutchBlock::new)
                .initialProperties(SharedProperties::stone).properties((p) -> {
                    return p.noOcclusion().mapColor(MapColor.PODZOL);
                }).addLayer(() -> {
                    return RenderType::cutoutMipped;
                }).transform(BlockStressDefaults.setNoImpact())
                .transform(TagGen.axeOrPickaxe()).blockstate((c, p) -> {
                    BlockStateGen.axisBlock(c, p, AssetLookup.forPowered(c, p));
                }).item()
                .transform(ModelGen.customItemModel())
                .register();

        Supplier<BlockEntry<?>> encased_chain_drive = () -> Create.REGISTRATE.block("encased_chain_drive", ChainDriveBlock::new)
                .initialProperties(SharedProperties::stone).properties((p) -> {
                    return p.noOcclusion().mapColor(MapColor.PODZOL);
                }).transform(BlockStressDefaults.setNoImpact())
                .transform(TagGen.axeOrPickaxe()).blockstate((c, p) -> {
                    (new ChainDriveGenerator((state, suffix) -> {
                        BlockModelProvider var10000 = p.models();
                        String var10002 = c.getName();
                        return var10000.getExistingFile(p.modLoc("block/" + var10002 + "/" + suffix));
                    })).generate(c, p);
                }).item()
                .transform(ModelGen.customItemModel())
                .register();

        Supplier<BlockEntry<?>> gearbox = () -> Create.REGISTRATE.block("gearbox", GearboxBlock::new)
                .initialProperties(SharedProperties::stone).properties((p) -> {
                    return p.noOcclusion().mapColor(MapColor.PODZOL);
                }).transform(BlockStressDefaults.setNoImpact()).transform(TagGen.axeOrPickaxe())
                .onRegister(CreateRegistrate.connectedTextures(() -> {
                    return new EncasedCTBehaviour(AllSpriteShifts.ANDESITE_CASING);
                }))
                .onRegister(CreateRegistrate.casingConnectivity((block, cc) -> {
                    cc.make(block, AllSpriteShifts.ANDESITE_CASING, (s, f) -> {
                        return f.getAxis() == s.getValue(GearboxBlock.AXIS);
                    });
                }))
                .blockstate((c, p) -> {
                    BlockStateGen.axisBlock(c, p, ($) -> {
                        return AssetLookup.partialBaseModel(c, p, new String[0]);
                    }, true);
                }).item()
                .transform(ModelGen.customItemModel())
                .register();

        Supplier<BlockEntry<?>> gearshift = () -> Create.REGISTRATE.block("gearshift", GearshiftBlock::new)
                .initialProperties(SharedProperties::stone).properties((p) -> {
                    return p.noOcclusion().mapColor(MapColor.PODZOL);
                }).addLayer(() -> {
                    return RenderType::cutoutMipped;
                })
                .transform(BlockStressDefaults.setNoImpact())
                .transform(TagGen.axeOrPickaxe()).blockstate((c, p) -> {
                    BlockStateGen.axisBlock(c, p, AssetLookup.forPowered(c, p));
                }).item()
                .transform(ModelGen.customItemModel()).register();
         */

        CONVERSION_MAP.put("basin", () -> BasinBlock::new);
        CONVERSION_MAP.put("crushing_wheel", () -> CrushingWheelBlock::new);
        CONVERSION_MAP.put("mechanical_mixer", () -> MechanicalMixerBlock::new);
        CONVERSION_MAP.put("mechanical_press", () -> MechanicalPressBlock::new);
        CONVERSION_MAP.put("millstone", () -> MillstoneBlock::new);
        CONVERSION_MAP.put("blaze_burner", () -> BlazeBurnerBlock::new);
        CONVERSION_MAP.put("adjustable_chain_gearshift", () -> ChainGearshiftBlock::new);
        CONVERSION_MAP.put("clutch", () -> ClutchBlock::new);
        CONVERSION_MAP.put("encased_chain_drive", () -> ChainDriveBlock::new);
        CONVERSION_MAP.put("gearbox", () -> GearboxBlock::new);
        CONVERSION_MAP.put("gearshift", () -> GearshiftBlock::new);
        CONVERSION_MAP.put("water_wheel", () -> WaterWheelBlock::new);
        CONVERSION_MAP.put("large_water_wheel", () -> LargeWaterWheelBlock::new);
    }

    @SuppressWarnings("unchecked")
    public <T extends Block> NonNullFunction<BlockBehaviour.Properties, T> convert(String key, NonNullFunction<BlockBehaviour.Properties, T> factory) {
        if (CONVERSION_MAP.containsKey(key)) {
            log(key);
            return (NonNullFunction<BlockBehaviour.Properties, T>) CONVERSION_MAP.get(key).get();
        }
        return factory;
    }
}
