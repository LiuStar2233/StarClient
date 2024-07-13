package cn.star.client.gui;

import cn.star.client.Client;
import cn.star.client.util.UtilTools;
import net.minecraft.client.gui.*;
import net.minecraft.client.resources.I18n;
import net.minecraft.util.ResourceLocation;

import java.awt.*;
import java.io.*;
import java.util.Random;

import static cn.star.client.util.UtilTools.fontRenderer;

/**
 * Created by IntelliJ IDEA
 *
 * @author LiuStar2233
 * {@code @create} 2024/6/30 下午5:32
 */

public class MainMenuGui extends GuiScreen {
    private int RandomNum(int min, int max) {
        Random random = new Random();
        return random.nextInt((max - min) + 1) + min;
    }
    int Image = RandomNum(1, 3);

    @Override
    public void initGui() {
        int i = 24;
        int j = this.height / 4 + 48;
        this.buttonList.add(new GuiButton(0, this.width / 2 - 100, j + 72 + 12, 98, 20, I18n.format("menu.options")));
        this.buttonList.add(new GuiButton(4, this.width / 2 + 2, j + 72 + 12, 98, 20, I18n.format("menu.quit")));
        this.buttonList.add(new GuiButton(1, this.width / 2 - 100, j, I18n.format("menu.singleplayer")));
        this.buttonList.add(new GuiButton(2, this.width / 2 - 100, j + i, I18n.format("menu.multiplayer")));

        UtilTools.PrintLog("MainMenu Run...", "Gui Run/INFO");
    }

    @Override
    public void drawScreen(int mouseX, int mouseY, float partialTicks) {
        drawBackground(0);
        if (Image == 1)
            mc.getTextureManager().bindTexture(new ResourceLocation("client/WallPaper/SnowSpace.jpg"));
        else if (Image == 2)
            mc.getTextureManager().bindTexture(new ResourceLocation("client/WallPaper/Night Sky.jpg"));
        else if (Image == 3)
            mc.getTextureManager().bindTexture(new ResourceLocation("client/WallPaper/Snow Mountain.jpg"));
        Gui.drawModalRectWithCustomSizedTexture(0, 0, 0, 0, width, height, width, height);

        int TextWidth = width / 2 - fontRenderer.getStringWidth(Client.CLIENT_NAME) / 2;
        int TextHeight = height / 2 - 9 / 2 - 65;
        fontRenderer.drawString(Client.CLIENT_NAME, TextWidth, TextHeight, new Color(0, 0, 0).getRGB());
        super.drawScreen(mouseX, mouseY, partialTicks);
    }

    @Override
    protected void actionPerformed(GuiButton button) throws IOException {
        if (button.id == 0) {
            this.mc.displayGuiScreen(new GuiOptions(this, this.mc.gameSettings));
        }
        if (button.id == 4) {
            this.mc.shutdown();
        }
        if (button.id == 1) {
            this.mc.displayGuiScreen(new GuiSelectWorld(this));
        }
        if (button.id == 2) {
            this.mc.displayGuiScreen(new GuiMultiplayer(this));
        }
    }
}
