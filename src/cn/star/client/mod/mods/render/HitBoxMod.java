package cn.star.client.mod.mods.render;

import cn.star.client.mod.Mod;
import cn.star.client.mod.mods.Category;
import cn.star.client.util.UtilTools;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.renderer.RenderGlobal;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.AxisAlignedBB;
import org.lwjgl.input.Keyboard;

import static cn.star.client.util.UtilTools.MC;

/**
 * Created by IntelliJ IDEA
 *
 * @author LiuStar2233
 * {@code @create} 2024/7/3 下午10:03
 */

public class HitBoxMod extends Mod {
    public HitBoxMod() {
        super("HitBox", Category.RENDER);
        setKey(Keyboard.KEY_NONE);
        setKeyboard("NONE");

        UtilTools.PrintLog("HitBoxMod Run...", "Mod Run/INFO");
    }

    @Override
    public void render(float partialTicks) {
        for (Entity entity : MC.theWorld.loadedEntityList) {
            double renderPosX = MC.getRenderManager().renderPosX;
            double renderPosY = MC.getRenderManager().renderPosY;
            double renderPosZ = MC.getRenderManager().renderPosZ;
            if (entity instanceof EntityLivingBase) {
                if (!(entity instanceof EntityPlayerSP)) {
                    AxisAlignedBB entityBB = entity.getEntityBoundingBox();
                    AxisAlignedBB axisAlignedBB = new AxisAlignedBB(
                            entityBB.minX - renderPosX,
                            entityBB.minY - renderPosY,
                            entityBB.minZ - renderPosZ,
                            entityBB.maxX - renderPosX,
                            entityBB.maxY - renderPosY,
                            entityBB.maxZ - renderPosZ);
                    RenderGlobal.func_181563_a(axisAlignedBB, 255, 255, 255, 255);
                }
            }
        }
    }
}
