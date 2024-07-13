package cn.star.client.mod.mods.draw;

import cn.star.client.mod.Mod;
import cn.star.client.mod.mods.Category;
import cn.star.client.util.UtilTools;
import net.minecraft.client.gui.inventory.GuiInventory;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import org.lwjgl.input.Keyboard;

import java.awt.*;

import static cn.star.client.util.UtilTools.*;

/**
 * Created by IntelliJ IDEA
 *
 * @author LiuStar2233
 * {@code @create} 2024/7/7 下午5:46
 */

public class TargetInfoMod extends Mod{
    public TargetInfoMod() {
        super("TargetInfo", Category.DRAW);
        setKey(Keyboard.KEY_NONE);
        setKeyboard("NONE");

        UtilTools.PrintLog("TargetInfoMod Run...", "Mod Run/INFO");
    }

    @Override
    public void draw() {
        Entity entityHit = MC.objectMouseOver.entityHit;
        if (entityHit instanceof EntityLivingBase && entityHit != null) {
            EntityLivingBase entity = (EntityLivingBase) entityHit;

            int ColorRGB = new Color(0, 0, 0, 255).getRGB();
            int width = (int) (SR.getScaledWidth() / 3.5);
            int height = SR.getScaledHeight() / 2;
            int entityX = (int) (width - entity.width / 2);
            int entityY = (int) (height - entity.height / 2);
            float Health = entity.getHealth();
            float MaxHealth = entity.getMaxHealth();
            String entityInfo = Health + "/" + MaxHealth;

            GuiInventory.drawEntityOnScreen(entityX, entityY, 30, 0, 0, entity);
            fontRenderer.drawString(entity.getName()
                    , entityX - fontRenderer.getStringWidth(entity.getName()) / 2
                    , (int) (entityY + entity.height + 4)
                    , ColorRGB);
            fontRenderer.drawString(entityInfo
                    , entityX - fontRenderer.getStringWidth(entityInfo) / 2
                    , (int) (entityY + entity.height + 18)
                    , ColorRGB);
        }
    }
}
