package com.nmmoc7.theelixir.item;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityPredicate;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author DustW
 */
public class SoulBomb extends ModItemBase {
    public SoulBomb() {
        super("soul_bomb", 64);
    }

    @Override
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
        super.addInformation(stack, worldIn, tooltip, flagIn);
    }

    @Override
    public boolean onEntityItemUpdate(ItemStack stack, ItemEntity entity) {
        World world = entity.world;
        if (!world.isRemote) {
            PlayerEntity target = world.getClosestPlayer(
                    new EntityPredicate().setCustomPredicate(livingEntity ->
                            livingEntity.getUniqueID() != entity.getThrowerId()).setDistance(16),
                    entity.getPosX(), entity.getPosY(), entity.getPosZ());

            if (target != null) {
                Vector3d motion = entity.getPositionVec().subtract(target.getPositionVec()).normalize().scale(2);
                entity.setMotion(motion);
            }
        }

        return false;
    }

    @Override
    public boolean isDamageable(DamageSource damageSource) {
        return !damageSource.isExplosion() && super.isDamageable(damageSource);
    }
}