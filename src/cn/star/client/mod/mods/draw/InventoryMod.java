package cn.star.client.mod.mods.draw;

import cn.star.client.mod.Mod;
import cn.star.client.mod.mods.Category;
import cn.star.client.util.UtilTools;
import net.minecraft.entity.player.EntityPlayer;
import org.lwjgl.input.Keyboard;

import java.awt.*;

import static cn.star.client.util.UtilTools.MC;
import static cn.star.client.util.UtilTools.SR;

/**
 * Created by IntelliJ IDEA
 * @author LiuStar2233
 * {@code @create} 2024/7/6 下午4:46
 */

public class InventoryMod extends Mod {
    public InventoryMod() {
        super("Inventory", Category.DRAW);
        setKey(Keyboard.KEY_C);
        setKeyboard("C");
    }

    @Override
    public void draw() {
        EntityPlayer entityplayer = (EntityPlayer) MC.getRenderViewEntity();
        int i = SR.getScaledWidth() / 2;
        UtilTools.drawRect(i - 91 + entityplayer.inventory.currentItem * 20
                , SR.getScaledHeight() - 22
                , 22
                , 22
                , new Color(0, 0, 0, 191).getRGB());
        UtilTools.drawRect(i - 91
                , SR.getScaledHeight() - 23
                , 182
                , 22
                , new Color(0, 0, 0, 64).getRGB());
    }
}
