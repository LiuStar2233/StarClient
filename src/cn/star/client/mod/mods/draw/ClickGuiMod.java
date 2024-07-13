package cn.star.client.mod.mods.draw;

import cn.star.client.gui.clickGui.ClickGui;
import cn.star.client.mod.Mod;
import cn.star.client.mod.mods.Category;
import cn.star.client.util.UtilTools;
import org.lwjgl.input.Keyboard;

import static cn.star.client.util.UtilTools.MC;

/**
 * Created by IntelliJ IDEA
 *
 * @author LiuStar2233
 * {@code @create} 2024/7/8 下午9:10
 */

public class ClickGuiMod extends Mod{
    public ClickGuiMod() {
        super("ClickGui", Category.DRAW);
        setKey(Keyboard.KEY_NONE);
        setKeyboard("NONE");

        UtilTools.PrintLog("ClickGuiMod Run...", "Mod Run/INFO");
    }

    @Override
    public void enable() {
        MC.displayGuiScreen(new ClickGui());
        setEnable(false);
    }
}
