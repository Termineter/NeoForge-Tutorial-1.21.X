package net.termineter.tutorialmod.item.custom;

import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.UseAnim;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;

public class WindScepterItem extends Item {

    public WindScepterItem(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand usedHand) {
        player.startUsingItem(usedHand);
        return super.use(level, player, usedHand);
    }

    @Override
    public int getUseDuration(ItemStack stack, LivingEntity entity) {
        return 72000;
    }

    @Override
    public UseAnim getUseAnimation(ItemStack stack) {
        return UseAnim.NONE;
    }

    @Override
    public void onUseTick(Level level, LivingEntity livingEntity, ItemStack stack, int remainingUseDuration) {

        //TODO: Fix
        Vec3 lookDirection = livingEntity.getLookAngle();
        Vec3 targetVelocity = lookDirection.multiply(Math.ceil(lookDirection.x), Math.ceil(lookDirection.y), Math.ceil(lookDirection.z));

        Vec3 movementVector = livingEntity.getDeltaMovement();

        double xChange;
        double yChange;
        double zChange;

        if ((movementVector.x - targetVelocity.x) > 0.04) {
            xChange = targetVelocity.x;
        } else if (movementVector.x > targetVelocity.x) {
            xChange = movementVector.x - 0.03;
        }
        else {
            xChange = movementVector.x + 0.03;
        }

        /*if (movementVector.y > targetVelocity.y) {
            yChange = movementVector.y - 0.03;
        } else {
            yChange = movementVector.y + 0.03;
        }*/

        if ((movementVector.z - targetVelocity.z) > 0.04) {
            zChange = targetVelocity.z;
        } else if (movementVector.z > targetVelocity.z) {
            zChange = movementVector.z - 0.03;
        } else {
            zChange = movementVector.z + 0.03;
        }

        movementVector = new Vec3(xChange, targetVelocity.y, zChange);

        livingEntity.setDeltaMovement(movementVector);
    }
}