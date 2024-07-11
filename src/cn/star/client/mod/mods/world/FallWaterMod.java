package cn.star.client.mod.mods.world;

import cn.star.client.mod.Mod;
import cn.star.client.mod.mods.Category;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MovingObjectPosition;
import org.lwjgl.input.Keyboard;

import static cn.star.client.util.UtilTools.MC;

/**
 * Created by IntelliJ IDEA
 *
 * @author LiuStar2233
 * {@code @create} 2024/7/8 下午5:18
 */

public class FallWaterMod extends Mod{
    public FallWaterMod() {
        super("FallWater", Category.WORLD);
        setKey(Keyboard.KEY_Z);
    }

    @Override
    public void update() {
        ItemStack currentItem = MC.thePlayer.inventory.getCurrentItem();
        if (currentItem != null) {
            int idFromItem = Item.getIdFromItem(currentItem.getItem());
            if (idFromItem == 326
                    && MC.thePlayer.fallDistance > 3.5
                    && MC.objectMouseOver.typeOfHit == MovingObjectPosition.MovingObjectType.BLOCK
                    && MC.objectMouseOver.sideHit.getIndex() == 1) {
                MC.rightClickMouse();
            }
        }
    }
}
