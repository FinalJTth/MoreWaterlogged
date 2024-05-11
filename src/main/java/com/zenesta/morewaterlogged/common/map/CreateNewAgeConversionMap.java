package com.zenesta.morewaterlogged.common.map;

import com.tterrag.registrate.util.nullness.NonNullFunction;
import com.zenesta.morewaterlogged.common.MoreWaterlogged;
import com.zenesta.morewaterlogged.common.block.createnewage.*;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;

public class CreateNewAgeConversionMap extends RegistrateConversionMap {
    public static CreateNewAgeConversionMap instance  = null;

    public CreateNewAgeConversionMap() {
        super(MoreWaterlogged.CREATE_NEW_AGE_MOD_ID);
        instance = this;
    }

    @SuppressWarnings("unchecked")
    @Override
    public void initialize() {
        // Processing
        conversionMap.put("energiser_t1", EnergiserBlock::createT1);
        conversionMap.put("energiser_t2", EnergiserBlock::createT2);
        conversionMap.put("energiser_t3", EnergiserBlock::createT3);

        conversionMap.put("electrical_connector", ElectricalConnectorBlock::new);

        conversionMap.put("basic_motor", MotorBlock::basic);
        conversionMap.put("advanced_motor", MotorBlock::advanced);
        conversionMap.put("reinforced_motor", MotorBlock::reinforced);

        conversionMap.put("basic_motor_extension", MotorExtensionBlock::basic);
        conversionMap.put("advanced_motor_extension", MotorExtensionBlock::advanced);

        conversionMap.put("carbon_brushes", CarbonBrushesBlock::new);
        conversionMap.put("generator_coil", GeneratorCoilBlock::new);

        conversionMap.put("heat_pipe", HeatPipeBlock::new);
        conversionMap.put("heat_pump", HeatPumpBlock::new);
        conversionMap.put("heater", HeaterBlock::new);

        conversionMap.put("stirling_engine", StirlingEngineBlock::normal);

        conversionMap.put("reactor_rod", ReactorRodBlock::new);
        conversionMap.put("reactor_glass", ReactorTransparentBlock::new);
        conversionMap.put("reactor_fuel_acceptor", ReactorFuelAcceptorBlock::new);
        conversionMap.put("reactor_heat_vent", ReactorHeatVentBlock::new);

        conversionMap.put("basic_solar_heating_plate", SolarHeatingPlateBlock::basic);
        conversionMap.put("advanced_solar_heating_plate", SolarHeatingPlateBlock::advanced);

        postInitialize(conversionMap.keySet());

        hasInitialized = true;
    }
}
