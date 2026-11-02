# FPSincreaser

A client-side Fabric mod project for Minecraft 1.21.11. It draws a fake `FPS: 10000` HUD and runs a bounded, intentionally expensive per-frame calculation to make performance worse as a joke.

## Build
1. Install JDK 21.
2. Open this folder in a terminal.
3. Run `gradle build` (or generate a Gradle wrapper and run it).
4. The mod JAR will be in `build/libs/`.

## Install
Copy `FPSincreaser-1.0.0.jar` into `.minecraft/mods` alongside Fabric Loader.

## Notes
- The HUD value is fake; it does not measure or improve FPS.
- The performance load is deliberately limited, but it can still make the game stutter.
- Remove the JAR from the mods folder if the game becomes difficult to use.
- This is a source project ZIP, not a precompiled JAR.
