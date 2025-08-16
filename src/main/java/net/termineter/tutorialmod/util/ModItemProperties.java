package net.termineter.tutorialmod.util;

import net.minecraft.client.renderer.item.ClampedItemPropertyFunction;
import net.minecraft.client.renderer.item.ItemProperties;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BiomeTags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.termineter.tutorialmod.TutorialMod;
import net.termineter.tutorialmod.component.ModDataComponents;
import net.termineter.tutorialmod.item.ModItems;

public class ModItemProperties {

    public static void addCustomItemProperties() {
        ItemProperties.register(ModItems.CHISEL.get(), ResourceLocation.fromNamespaceAndPath(TutorialMod.MOD_ID, "used"),
                (stack, level, entity, seed) -> stack.get(ModDataComponents.COORDINATES) != null ? 1f : 0f);

        ItemProperties.register(ModItems.BIOME_BLADE.get(), ResourceLocation.fromNamespaceAndPath(TutorialMod.MOD_ID, "biome"),
                (stack, level, entity, seed) -> {
                    if (stack.get(ModDataComponents.BIOME) == null) {
                        return 0f;
                    }
                    else if (stack.get(ModDataComponents.BIOME).is(BiomeTags.IS_NETHER)) {
                        return 1.0f;
                    }
                    else if ((stack.get(ModDataComponents.BIOME).is(BiomeTags.IS_END))) {
                        return 2.0f;
                    }
                    return 0f;
                });

            makeCustomBow(ModItems.KAUPEN_BOW.get());
    }

    private static void makeCustomBow(Item  item) {
        ItemProperties.register(item, ResourceLocation.withDefaultNamespace("pull"), (ClampedItemPropertyFunction)((p_344163_, p_344164_, p_344165_, p_344166_) -> {
            if (p_344165_ == null) {
                return 0.0F;
            } else {
                return p_344165_.getUseItem() != p_344163_ ? 0.0F : (float)(p_344163_.getUseDuration(p_344165_) - p_344165_.getUseItemRemainingTicks()) / 20.0F;
            }
        }));
        ItemProperties.register(
                item,
                ResourceLocation.withDefaultNamespace("pulling"),
                (ClampedItemPropertyFunction)((p_174630_, p_174631_, p_174632_, p_174633_) -> p_174632_ != null && p_174632_.isUsingItem() && p_174632_.getUseItem() == p_174630_ ? 1.0F : 0.0F));
    }
}
