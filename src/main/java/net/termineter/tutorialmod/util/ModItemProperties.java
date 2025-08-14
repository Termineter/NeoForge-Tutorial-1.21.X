package net.termineter.tutorialmod.util;

import net.minecraft.client.renderer.item.ItemProperties;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BiomeTags;
import net.termineter.tutorialmod.TutorialMod;
import net.termineter.tutorialmod.component.ModDataComponents;
import net.termineter.tutorialmod.item.ModItems;

public class ModItemProperties {

    public static void addCustomItemProperties() {
        ItemProperties.register(ModItems.CHISEL.get(), ResourceLocation.fromNamespaceAndPath(TutorialMod.MOD_ID, "used"),
                (stack, level, entity, seed) -> stack.get(ModDataComponents.COORDINATES) != null ? 1f : 0f);

        ItemProperties.register(ModItems.BIOME_BLADE.get(), ResourceLocation.fromNamespaceAndPath(TutorialMod.MOD_ID, "biome"),
                (stack, level, entity, seed) -> {
                    if (stack.get(ModDataComponents.BIOME).is(BiomeTags.IS_NETHER)) {
                        return 1.0f;
                    }
                    else if ((stack.get(ModDataComponents.BIOME).is(BiomeTags.IS_END))) {
                        return 2.0f;
                    }
                    return 0f;
                });
    }
}
