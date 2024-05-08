package com.zenesta.morewaterlogged.mixin.apotheosis;

import dev.shadowsoffire.apotheosis.ench.EnchModule;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(EnchModule.class)
public class MixinApotheosisEnchModule {
    @Inject(method = "blocks(Ldev/shadowsoffire/placebo/registry/RegistryEvent$Register;)V", at = @At("HEAD"), cancellable = true, remap = false)
    public void injected(CallbackInfo ci) {
        ci.cancel();
    }
}
