package cn.star.client.mod.mods.render;

import cn.star.client.mod.Mod;
import cn.star.client.mod.mods.Category;
import cn.star.client.util.UtilTools;
import org.lwjgl.input.Keyboard;

/**
 * Created by IntelliJ IDEA
 *
 * @author LiuStar2233
 * {@code @create} 2024/7/12 下午2:08
 */

public class NoHurtCameraMod extends Mod{
    public NoHurtCameraMod() {
        super("NoHurtCamera", Category.RENDER);
        setKey(Keyboard.KEY_NONE);
        setKeyboard("NONE");

        UtilTools.PrintLog("NoHurtCameraMod Run...", "Mod Run/INFO");
    }
}
