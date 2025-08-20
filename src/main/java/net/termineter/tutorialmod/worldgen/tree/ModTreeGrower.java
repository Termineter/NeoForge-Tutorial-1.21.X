package net.termineter.tutorialmod.worldgen.tree;

import net.minecraft.world.level.block.grower.TreeGrower;
import net.termineter.tutorialmod.TutorialMod;
import net.termineter.tutorialmod.worldgen.ModConfiguredFeatures;

import java.util.Optional;

public class ModTreeGrower {

    public static final TreeGrower BLOODWOOD = new TreeGrower(TutorialMod.MOD_ID + ":bloodwood",
            Optional.empty(), Optional.of(ModConfiguredFeatures.BLOODWOOD_KEY), Optional.empty());
}
