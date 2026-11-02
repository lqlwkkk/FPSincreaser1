package com.cyx.fpsincreaser;

import net.fabricmc.api.ClientModInitializer;

public final class FPSincreaserClient implements ClientModInitializer {
    public static volatile boolean enabled = true;

    @Override
    public void onInitializeClient() {
        System.out.println("[FPSincreaser] Fake 10000 FPS mode loaded.");
    }
}
