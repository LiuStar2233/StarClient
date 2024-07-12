package cn.star.client.mod.mods.render;

import cn.star.client.mod.Mod;
import cn.star.client.mod.mods.Category;
import cn.star.client.util.UtilTools;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import org.lwjgl.input.Keyboard;

import static cn.star.client.util.UtilTools.MC;

/**
 * Created by IntelliJ IDEA
 *
 * @author LiuStar2233
 * {@code @create} 2024/7/12 下午2:39
 */

public class NameLabelMod extends Mod{
    public NameLabelMod() {
        super("NameLabel", Category.RENDER);
        setKey(Keyboard.KEY_NONE);
        setKeyboard("NONE");
    }

    @Override
    public void render(float partialTicks) {
        for (Entity entity : MC.theWorld.loadedEntityList) {
            if (entity instanceof EntityLivingBase && !(entity instanceof EntityPlayerSP)) {
                EntityLivingBase entityLivingBase = (EntityLivingBase) entity;
                float Health = ((EntityLivingBase) entity).getHealth();
                float MaxHealth = ((EntityLivingBase) entity).getMaxHealth();
                String entityInfo = entityLivingBase.getDisplayName().getFormattedText() + " " + Health + "/" + MaxHealth;
                UtilTools.renderLabel(entityLivingBase
                        , entityInfo
                        , 64
                        , partialTicks);
            }
        }
    }
}
