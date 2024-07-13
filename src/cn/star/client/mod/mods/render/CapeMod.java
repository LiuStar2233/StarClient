package cn.star.client.mod.mods.render;

import cn.star.client.mod.Mod;
import cn.star.client.mod.mods.Category;
import cn.star.client.util.UtilTools;
import org.lwjgl.input.Keyboard;

/**
 * Created by IntelliJ IDEA
 *
 * @author LiuStar2233
 * {@code @create} 2024/7/10 下午5:46
 */

public class CapeMod extends Mod{
    public CapeMod() {
        super("Cape", Category.RENDER);
        setKey(Keyboard.KEY_NONE);
        setKeyboard("NONE");

        UtilTools.PrintLog("CapeMod Run...", "Mod Run/INFO");
    }

    static String Cape = "./client/Cape/Mojang.png";

    public static String getCape() {
        if (Keyboard.isKeyDown(Keyboard.KEY_P)) {
            Cape = "./client/Cape/Chicken.png";
        } else if (Keyboard.isKeyDown(Keyboard.KEY_O)) {
            Cape = "./client/Cape/Creeper.png";
        } else if (Keyboard.isKeyDown(Keyboard.KEY_L)) {
            Cape = "./client/Cape/Dragon.png";
        } else if (Keyboard.isKeyDown(Keyboard.KEY_K)) {
            Cape = "./client/Cape/Mojang.png";
        }
        return Cape;
    }
}
