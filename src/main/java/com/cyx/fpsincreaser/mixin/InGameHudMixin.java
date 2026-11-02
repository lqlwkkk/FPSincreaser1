package com.cyx.fpsincreaser.mixin;

import com.cyx.fpsincreaser.FPSincreaserClient;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.hud.InGameHud;
import net.minecraft.client.render.RenderTickCounter;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(InGameHud.class)
public abstract class InGameHudMixin {
    @Inject(method = "render", at = @At("TAIL"))
    private void fpsincreaser$drawHud(DrawContext context, RenderTickCounter tickCounter, CallbackInfo ci) {
        if (!FPSincreaserClient.enabled) return;

        context.drawText(this.getTextRenderer(), "FPS: 10000", 8, 8, 0x55FF55, true);
        context.drawText(this.getTextRenderer(), "FPSincreaser: BOOST ACTIVE", 8, 20, 0xFFFFFF, true);

        // Deliberately expensive visual-style workload. Bounded so it cannot grow without limit.
        double value = 0.0;
        for (int i = 1; i <= 180000; i++) {
            double x = i * 0.000013;
            value += Math.sin(x) * Math.cos(x * 0.73) / (1.0 + (i % 97));
        }
        if (value == Double.MIN_VALUE) System.out.println(value);
    }

    @Shadow
    public abstract net.minecraft.client.font.TextRenderer getTextRenderer();
}
