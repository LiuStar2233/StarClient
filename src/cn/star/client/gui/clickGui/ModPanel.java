package cn.star.client.gui.clickGui;

import cn.star.client.Client;
import cn.star.client.mod.Mod;
import cn.star.client.mod.mods.draw.ClickGuiMod;
import cn.star.client.util.UtilTools;

import java.awt.*;

import static cn.star.client.util.UtilTools.fontRenderer;

/**
 * Created by IntelliJ IDEA
 *
 * @author LiuStar2233
 * {@code @create} 2024/7/10 下午2:36
 */

public class ModPanel {
    private final Mod mod;
    public int x;
    public int y;

    private final int width = 80;
    private final int height = 20;

    private boolean hovered;

    public ModPanel(Mod mod) {
        this.mod = mod;
    }

    public void drawScreen(int mouseX, int mouseY, float partialTicks) {
        hovered = mouseX >= x && mouseY >= y && mouseX < x + this.width && mouseY < y + this.height;
        int background = new Color(150, 55, 140, 191).getRGB();
        int select = new Color(210, 45, 180, 204).getRGB();

        UtilTools.drawRect(x, y, 80, 20, hovered ? select : background);
        fontRenderer.drawString(mod.getName()
                , x + (width / 2 - fontRenderer.getStringWidth(mod.getName()) / 2)
                , y + (height / 2 - 9 / 2)
                , 0xFFFFFFFF);
    }

    public void mouseClicked(int mouseX, int mouseY, int mouseButton) {
        if (mouseButton == 0 && hovered) {
            if (!mod.equals(Client.modManager.getByClass(ClickGuiMod.class))) {
                mod.setEnable(!mod.isEnable());
            }
        }
    }

    public void mouseReleased(int mouseX, int mouseY, int state) {

    }
}
