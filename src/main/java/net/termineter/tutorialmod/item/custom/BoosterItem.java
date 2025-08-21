package net.termineter.tutorialmod.item.custom;

import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.UseAnim;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import net.neoforged.neoforge.event.level.NoteBlockEvent;

import java.time.Duration;

public class BoosterItem extends Item {

    public BoosterItem(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand usedHand) {
        player.startUsingItem(usedHand);
        return InteractionResultHolder.success(player.getItemInHand(usedHand));
    }

    @Override
    public int getUseDuration(ItemStack stack, LivingEntity entity) {
        return 60;
    }

    @Override
    public void onUseTick(Level level, LivingEntity livingEntity, ItemStack stack, int remainingUseDuration) {
        super.onUseTick(level, livingEntity, stack, remainingUseDuration);
    }

    @Override
    public void releaseUsing(ItemStack stack, Level level, LivingEntity livingEntity, int timeCharged) {
        if (!level.isClientSide) {
            if (livingEntity instanceof Player player) {
                Vec3 lookDirection = player.getLookAngle().normalize();
                player.getPersistentData().putInt("boosterTicks", this.getUseDuration(stack, player) - timeCharged);
                player.getPersistentData().putDouble("boosterDirectionX", lookDirection.x);
                player.getPersistentData().putDouble("boosterDirectionY", lookDirection.y);
                player.getPersistentData().putDouble("boosterDirectionZ", lookDirection.z);

                player.getCooldowns().addCooldown(this, 100);
            }
        }
    }

    @Override
    public ItemStack finishUsingItem(ItemStack stack, Level level, LivingEntity livingEntity) {

        if (!level.isClientSide) {
            if (livingEntity instanceof Player player) {
                Vec3 lookDirection = player.getLookAngle().normalize();
                player.getPersistentData().putInt("boosterTicks", 60);
                player.getPersistentData().putDouble("boosterDirectionX", lookDirection.x);
                player.getPersistentData().putDouble("boosterDirectionY", lookDirection.y);
                player.getPersistentData().putDouble("boosterDirectionZ", lookDirection.z);
            }

        }

        return super.finishUsingItem(stack, level, livingEntity);
    }

    /*@Override
    public ItemStack finishUsingItem(ItemStack stack, Level level, LivingEntity livingEntity) {
        if (!level.isClientSide) {
            if (livingEntity instanceof Player player) {
                Vec3 lookDirection = player.getLookAngle().normalize();
                double boostModifier = 20;
                double horizontalModifier = 2;
                double verticalModifier = 1;
                Vec3 boost = lookDirection.multiply(
                        boostModifier*horizontalModifier,
                        boostModifier*verticalModifier,
                        boostModifier*horizontalModifier
                );


                player.setDeltaMovement(boost);
                player.hurtMarked = true;
                player.getCooldowns().addCooldown(this, 100);
            }

        }
        return super.finishUsingItem(stack, level, livingEntity);
    }*/

    @Override
    public UseAnim getUseAnimation(ItemStack stack) {
        return UseAnim.BOW;
    }


}
