package cn.star.client.mod.mods.world;

import cn.star.client.mod.Mod;
import cn.star.client.mod.mods.Category;
import net.minecraft.client.Minecraft;
import org.lwjgl.input.Keyboard;

import static cn.star.client.util.UtilTools.MC;

/**
 * Created by IntelliJ IDEA
 *
 * @author LiuStar2233
 * {@code @create} 2024/7/8 下午5:48
 */

public class XRayMod extends Mod{
    public XRayMod() {
        super("XRay", Category.WORLD);
        setKey(Keyboard.KEY_NONE);
        setKeyboard("NONE");
    }

    @Override
    public void enable() {
        MC.renderGlobal.loadRenderers();
    }

    @Override
    public void disable() {
        MC.renderGlobal.loadRenderers();
    }
}
