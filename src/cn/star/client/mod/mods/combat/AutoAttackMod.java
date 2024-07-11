package cn.star.client.mod.mods.combat;

import cn.star.client.mod.Mod;
import cn.star.client.mod.mods.Category;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import org.lwjgl.input.Keyboard;

import static cn.star.client.util.UtilTools.MC;

/**
 * Created by IntelliJ IDEA
 * @author LiuStar2233
 * {@code @create} 2024/7/7 下午4:20
 */

public class AutoAttackMod extends Mod{
    public AutoAttackMod() {
        super("AutoAttack", Category.COMBAT);
        setKey(Keyboard.KEY_NONE);
        setKeyboard("NONE");
    }

    @Override
    public void update() {
        for (Entity entity : MC.theWorld.loadedEntityList) {
            if (entity instanceof EntityLivingBase) {
                EntityLivingBase livingBase = (EntityLivingBase) entity;
                if (!livingBase.equals(MC.thePlayer)
                        && !(livingBase.getHealth() <= 0)
                        && !livingBase.isDead
                        && !livingBase.isInvisible()
                        && livingBase.getDistanceToEntity(MC.thePlayer) <= 3.8) {
                    MC.thePlayer.swingItem();
                    MC.playerController.attackEntity(MC.thePlayer, livingBase);
                }
            }
        }
    }
}
