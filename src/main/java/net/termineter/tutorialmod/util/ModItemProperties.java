package net.termineter.tutorialmod.util;

import net.minecraft.client.renderer.item.ItemProperties;
import net.minecraft.resources.ResourceLocation;
import net.termineter.tutorialmod.TutorialMod;
import net.termineter.tutorialmod.component.ModDataComponents;
import net.termineter.tutorialmod.item.ModItems;

public class ModItemProperties {

    public static void addCustomItemProperties() {
        ItemProperties.register(ModItems.CHISEL.get(), ResourceLocation.fromNamespaceAndPath(TutorialMod.MOD_ID, "used"),
                (stack, level, entity, seed) -> stack.get(ModDataComponents.COORDINATES) != null ? 1f : 0f);
    }
}
