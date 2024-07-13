package cn.star.client.mod.mods.draw;

import cn.star.client.Client;
import cn.star.client.mod.Mod;
import cn.star.client.mod.mods.Category;
import cn.star.client.util.UtilTools;
import org.lwjgl.input.Keyboard;

import java.awt.*;
import java.util.List;

import static cn.star.client.util.UtilTools.*;

/**
 * Created by IntelliJ IDEA
 *
 * @author LiuStar2233
 * {@code @create} 2024/5/27 下午17:45
 */

public class ModListMod extends Mod {
    public ModListMod() {
        super("ModList", Category.DRAW);
        setKey(Keyboard.KEY_NONE);
        setKeyboard("NONE");

        UtilTools.PrintLog("ModListMod Run...", "Mod Run/INFO");
    }

    @Override
    public void draw() {
        int width = SR.getScaledWidth();

        List<Mod> enableMods = Client.modManager.getEnableMods();
        enableMods.sort((o1, o2) -> fontRenderer.getStringWidth(o2.getName()) - fontRenderer.getStringWidth(o1.getName()));

        int Y_ = 0;
        for (Mod enableMod : enableMods) {
            fontRenderer.drawString(enableMod.getName(), width - fontRenderer.getStringWidth(enableMod.getName()) - 5, Y_ + 5, new Color(0, 0, 0).getRGB());
            Y_ += 14;
        }
    }
}
