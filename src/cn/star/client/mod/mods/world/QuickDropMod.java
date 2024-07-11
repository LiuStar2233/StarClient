package cn.star.client.mod.mods.world;

import cn.star.client.mod.Mod;
import cn.star.client.mod.mods.Category;
import net.minecraft.item.ItemBlock;
import org.lwjgl.input.Keyboard;

import static cn.star.client.util.UtilTools.MC;

/**
 * Created by IntelliJ IDEA
 * @author LiuStar2233
 * {@code @create} 2024/7/7 下午7:09
 */

public class QuickDropMod extends Mod{
    public QuickDropMod() {
        super("QuickDrop", Category.WORLD);
        setKey(Keyboard.KEY_NONE);
    }

    @Override
    public void update() {
        if (MC.thePlayer.inventory.getCurrentItem() != null) {
            if (MC.thePlayer.getCurrentEquippedItem().getItem() instanceof ItemBlock) {
                MC.rightClickDelayTimer = 1;
            } else {
                MC.rightClickDelayTimer = 4;
            }
        }
    }
}
