package com.zenesta.morewaterlogged.mixin.registrate;

import com.simibubi.create.foundation.data.CreateRegistrate;
import com.tterrag.registrate.AbstractRegistrate;
import com.tterrag.registrate.builders.BlockBuilder;
import com.tterrag.registrate.util.nullness.NonNullFunction;
import com.zenesta.morewaterlogged.common.MoreWaterlogged;
import com.zenesta.morewaterlogged.common.map.CreateConversionMap;
import com.zenesta.morewaterlogged.common.map.CreateNewAgeConversionMap;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import static com.zenesta.morewaterlogged.common.MoreWaterlogged.LOGGER;

@Mixin(AbstractRegistrate.class)
public class MixinAbstractRegistrate<S extends AbstractRegistrate<S>> {
    @Unique
    private static CreateConversionMap moreWaterlogged$map;

    @Inject(method = "<clinit>", at = @At("HEAD"))
    private static void staticHead(CallbackInfo ci) {
        if (CreateConversionMap.instance == null)
            new CreateConversionMap();
        if (CreateNewAgeConversionMap.instance == null)
            new CreateNewAgeConversionMap();
    }

    /**
     * @author Zenesta
     * @reason test
     */
    @SuppressWarnings("unchecked") @Overwrite(remap = false)
    public <T extends Block, P> BlockBuilder<T, P> block(P parent, String name, NonNullFunction<BlockBehaviour.Properties, T> factory) {
        if (parent instanceof CreateRegistrate registrate) {
            LOGGER.debug("MODNAME : {}", registrate.getModid());
            if (registrate.getModid().equals(MoreWaterlogged.CREATE_MOD_ID))
                factory = CreateConversionMap.instance.convert(name, factory);
            else if (registrate.getModid().equals(MoreWaterlogged.CREATE_NEW_AGE_MOD_ID))
                factory = CreateNewAgeConversionMap.instance.convert(name, factory);
        }
        NonNullFunction<BlockBehaviour.Properties, T> finalFactory = factory;
        return ((AbstractRegistrate<?>)(Object)this).entry(name, callback -> BlockBuilder.create((AbstractRegistrate<?>)(Object)this, parent, name, callback, finalFactory));
    }
    /*
    @Shadow
    protected final S self() {
        return (S) this;
    }
    */
    /*
    @ModifyVariable(method = "block(Ljava/lang/String;Lcom/tterrag/registrate/util/nullness/NonNullFunction;)Lcom/tterrag/registrate/builders/BlockBuilder;", at = @At("HEAD"), ordinal = 0, argsOnly = true, remap = false)
    private String injected(String name) {
        final CompletableFuture<String> name = new CompletableFuture<>();
        moreWaterlogged$commonFuture = name;
        return name.join();
    }

    @ModifyVariable(method = "block(Ljava/lang/String;Lcom/tterrag/registrate/util/nullness/NonNullFunction;)Lcom/tterrag/registrate/builders/BlockBuilder;", at = @At("HEAD"), ordinal = 0, argsOnly = true, remap = false)
    private <T extends Block> NonNullFunction<BlockBehaviour.Properties, T> injected(NonNullFunction<BlockBehaviour.Properties, T> factory) {
        NonNullFunction<BlockBehaviour.Properties, MechanicalPressBlock> tempFactory = MechanicalPressBlock::new;
        LOGGER.debug("Test : {}", factory.toString());
        return factory;
    }
    */
    /*
    @Shadow
    public <R, T extends R, P, S2 extends Builder<R, T, P, S2>> S2 entry(String name, NonNullFunction<BuilderCallback, S2> factory) {
        NonNullFunction<BuilderCallback, S2> test = MechanicalPressBlock::new;
        LOGGER.debug("Test : {} {}", factory.toString(), MechanicalPressBlock::new);
        return null;
    }
    */

    /*
    public final String target = "Lcom/tterrag/registrate/AbstractRegistrate;block(Lcom/tterrag/registrate/AbstractRegistrate;Ljava/lang/String;Lcom/tterrag/registrate/util/nullness/NonNullFunction;)Lcom/tterrag/registrate/builders/BlockBuilder;";

    @ModifyArgs(method = "block(Lcom/simibubi/create/foundation/data/CreateRegistrate;Ljava/lang/String;Lcom/tterrag/registrate/util/nullness/NonNullFunction;)Lcom/tterrag/registrate/builders/BlockBuilder;", at = @At("INVOKE", target = target), remap = false)
    private void injected(Args args) {

    }
    */
    // Lcom/simibubi/create/foundation/data/CreateRegistrate;
    // Lcom/tterrag/registrate/AbstractRegistrate;

    /*
    @Shadow
    public <T extends Block, P> BlockBuilder<T, P> block(P parent, String name, NonNullFunction<BlockBehaviour.Properties, T> factory) {
        return null;
    }

     */
}
