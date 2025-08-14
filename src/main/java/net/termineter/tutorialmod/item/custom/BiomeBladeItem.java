package net.termineter.tutorialmod.item.custom;

import net.minecraft.core.Holder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.biome.Biome;
import net.termineter.tutorialmod.component.ModDataComponents;

public class BiomeBladeItem extends SwordItem {

    public BiomeBladeItem(Tier tier, Properties properties) {
        super(tier, properties);
    }

    @Override
    public void inventoryTick(ItemStack stack, Level level, Entity entity, int slotId, boolean isSelected) {
        Holder<Biome> biome = level.getBiome(entity.getOnPos());

        //context.itemStack.get(ModDataComponents.BIOME).is(BiomeTags.IS_NETHER)

        stack.set(ModDataComponents.BIOME.get(), biome);
    }

    @Override
    public InteractionResult useOn(UseOnContext context) {
        return super.useOn(context);
    }
}

