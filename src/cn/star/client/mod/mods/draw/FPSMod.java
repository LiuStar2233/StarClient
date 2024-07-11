package cn.star.client.mod.mods.draw;

import cn.star.client.mod.Mod;
import cn.star.client.mod.mods.Category;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import org.lwjgl.input.Keyboard;

import java.awt.*;

import static cn.star.client.util.UtilTools.fontRenderer;

/**
 * Created by IntelliJ IDEA
 * @author LiuStar2233
 * {@code @create} 2024/6/29 下午4:49
 */

public class FPSMod extends Mod {
    public FPSMod() {
        super("FPS", Category.DRAW);
        setKey(Keyboard.KEY_NONE);
    }

    @Override
    public void draw() {
        String The_FPS = "[FPS: " + Minecraft.getDebugFPS() + "]";
        fontRenderer.drawString(The_FPS, 5, 5, new Color(0, 0, 0).getRGB());
    }
}