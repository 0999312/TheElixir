package org.teacon.theelixir.item;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.Util;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.World;
import org.teacon.theelixir.capability.CapabilityRegistryHandler;

/**
 * @author DustW
 */
public class ElixirItem extends ModItemBase {
    public ElixirItem() {
        super("elixir_item", 1);
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
        if (!worldIn.isRemote) {
            playerIn.getCapability(CapabilityRegistryHandler.THE_ELIXIR_CAPABILITY).ifPresent((theCap) -> {
                if (theCap.isUsedElixir()) {
                    playerIn.sendMessage(new StringTextComponent("已经用过了!"), Util.DUMMY_UUID);
                }
                else {
                    playerIn.sendMessage(new StringTextComponent("使用了蓬莱之药!"), Util.DUMMY_UUID);
                    theCap.setUsedElixir(true);
                }
            });
        }
        return super.onItemRightClick(worldIn, playerIn, handIn);
    }
}
