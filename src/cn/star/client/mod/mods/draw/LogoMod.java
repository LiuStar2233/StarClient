package cn.star.client.mod.mods.draw;

import cn.star.client.Client;
import cn.star.client.mod.Mod;
import cn.star.client.mod.mods.Category;
import org.lwjgl.input.Keyboard;

import java.awt.*;

import static cn.star.client.util.UtilTools.*;

/**
 * Created by IntelliJ IDEA
 * @author LiuStar2233
 * {@code @create} 2024/5/27 下午17:45
 */

public class LogoMod extends Mod {
    public LogoMod() {
        super("Logo", Category.DRAW);
        setKey(Keyboard.KEY_NONE);
    }

    @Override
    public void draw() {
        int width = SR.getScaledWidth();
        int height = SR.getScaledHeight();

        String NAME = Client.NAME;
        String VERSION = Client.VERSION_FULL;
        fontRenderer.drawString(NAME
                , width - fontRenderer.getStringWidth(NAME) - 5
                , height - 9 - 18
                , new Color(0, 0, 0).getRGB());
        fontRenderer.drawString(VERSION
                , width - fontRenderer.getStringWidth(VERSION) - 5
                , height - 9 - 5
                , new Color(0, 0, 0).getRGB());
    }
}
