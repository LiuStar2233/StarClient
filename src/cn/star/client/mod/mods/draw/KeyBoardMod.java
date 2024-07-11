package cn.star.client.mod.mods.draw;

import cn.star.client.mod.Mod;
import cn.star.client.mod.mods.Category;
import net.minecraft.client.settings.GameSettings;
import org.lwjgl.input.Keyboard;

import java.awt.*;

import static cn.star.client.util.UtilTools.*;

/**
 * Created by IntelliJ IDEA
 * @author LiuStar2233
 * {@code @create} 2024/7/8 下午1:57
 */

public class KeyBoardMod extends Mod{

    public KeyBoardMod() {
        super("KeyBoard", Category.DRAW);
        setKey(Keyboard.KEY_X);
    }

    @Override
    public void draw() {
        drawKey(0, SR.getScaledHeight() / 2);
    }

    public void drawKey(int x, int y) {
        int BackGround = new Color(40, 40, 40, 179).getRGB();
        int Press = new Color(90, 90, 90, 203).getRGB();
        GameSettings gameSettings = MC.gameSettings;

        drawRect(x + 23, y, 23, 23
                , gameSettings.keyBindForward.isKeyDown() ? Press : BackGround);
        fontRenderer.drawString("W", x + 23 + 9, y + 9, 0xFFFFFFFF);

        drawRect(x + 23, y + 23, 23, 23
                , gameSettings.keyBindBack.isKeyDown() ? Press : BackGround);
        fontRenderer.drawString("S", x + 23 + 9,  y + 23 + 9, 0xFFFFFFFF);

        drawRect(x, y + 23, 23, 23
                , gameSettings.keyBindLeft.isKeyDown() ? Press : BackGround);
        fontRenderer.drawString("A", x + 9, y + 23 + 9, 0xFFFFFFFF);

        drawRect(x + 46, y + 23, 23, 23
                , gameSettings.keyBindRight.isKeyDown() ? Press : BackGround);
        fontRenderer.drawString("D", x + 46 + 9, y + 23 + 9, 0xFFFFFFFF);
    }
}
