package com.zenesta.morewaterlogged.mixin;

import com.simibubi.create.AllBlocks;
import com.simibubi.create.Create;
import com.simibubi.create.content.kinetics.BlockStressDefaults;
import com.zenesta.morewaterlogged.common.block.MechanicalPressBlock;
import com.simibubi.create.content.processing.AssemblyOperatorBlockItem;
import com.simibubi.create.foundation.data.BlockStateGen;
import com.simibubi.create.foundation.data.ModelGen;
import com.simibubi.create.foundation.data.SharedProperties;
import com.simibubi.create.foundation.data.TagGen;
import com.tterrag.registrate.builders.BlockBuilder;
import com.tterrag.registrate.util.entry.BlockEntry;
import net.minecraft.world.level.material.MapColor;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(AllBlocks.class)
public class MixinCreateAllBlocks {
    /*
    @Shadow
    public static final BlockEntry<com.simibubi.create.content.kinetics.press.MechanicalPressBlock> MECHANICAL_PRESS = ((BlockBuilder)((BlockBuilder)((BlockBuilder) Create.REGISTRATE.block("mechanical_press", MechanicalPressBlock::new).initialProperties(SharedProperties::stone).properties((p) -> {
        return p.noOcclusion().mapColor(MapColor.PODZOL);
    }).transform(TagGen.axeOrPickaxe())).blockstate(BlockStateGen.horizontalBlockProvider(true)).transform(BlockStressDefaults.setImpact(8.0))).item(AssemblyOperatorBlockItem::new).transform(ModelGen.customItemModel())).register();
    */
}

