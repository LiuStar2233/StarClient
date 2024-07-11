package cn.star.client.mod.mods.draw;

import cn.star.client.Client;
import cn.star.client.mod.Mod;
import cn.star.client.mod.mods.Category;
import net.minecraft.client.gui.Gui;
import org.lwjgl.input.Keyboard;

import java.awt.*;
import java.util.List;

import static cn.star.client.util.UtilTools.fontRenderer;

/**
 * Created by IntelliJ IDEA
 * @author LiuStar2233
 * {@code @create} 2024/7/4 下午7:40
 */

public class TabMod extends Mod {

    private int currentCategory = 0;

    private int currentMod = 0;

    private boolean mod = false;

    private final int FormatDraw = 4;

    public TabMod() {
        super("Tab", Category.DRAW);
        setKey(Keyboard.KEY_TAB);
    }

    @Override
    public void draw() {
        drawTab(0, 14);
    }

    @Override
    public void key(int key) {
        if (!mod) {
            if (key == Keyboard.KEY_UP) {
                if (currentCategory > 0) {
                    currentCategory--;
                } else {
                    currentCategory = Category.values().length - 1;
                }
            } else if (key == Keyboard.KEY_DOWN) {
                if (currentCategory < Category.values().length - 1) {
                    currentCategory++;
                } else {
                    currentCategory = 0;
                }
            } else if (key == Keyboard.KEY_RETURN || key == Keyboard.KEY_RIGHT) {
                mod = true;
                System.out.println(Category.values()[currentCategory].name());
            }
        } else {
            if (key == Keyboard.KEY_UP) {
                if (currentMod > 0) {
                    currentMod--;
                } else {
                    currentMod = Client.modManager.getByCategory(Category.values()[currentCategory]).size() - 1;
                }
            } else if (key == Keyboard.KEY_DOWN) {
                if (currentMod < Client.modManager.getByCategory(Category.values()[currentCategory]).size() - 1) {
                    currentMod++;
                } else {
                    currentMod = 0;
                }
            } else if (key == Keyboard.KEY_RETURN || key == Keyboard.KEY_RIGHT) {
                Mod mod = Client.modManager.getByCategory(Category.values()[currentCategory]).get(currentMod);
                mod.setEnable(!mod.isEnable());

            } else if (key == Keyboard.KEY_LEFT) {
                mod = false;
                currentMod = 0;
            }
        }
    }

    private void drawTab(int x, int y) {
        Gui.drawRect(x + FormatDraw - 2, y + FormatDraw - 2
                , x + fontRenderer.getStringWidth(Category.MOVEMENT.name()) + FormatDraw + 2
                , (int) (y + Category.values().length * 10.7 + FormatDraw * 2)
                , new Color(0, 120, 80, 179).getRGB());
        int index = y;
        Category[] values = Category.values();
        for (int i = 0; i < values.length; i++) {
            Category value = values[i];

            if (i == currentCategory) {
                Gui.drawRect(x + FormatDraw - 2, index + FormatDraw - 2
                        , x + fontRenderer.getStringWidth(Category.MOVEMENT.name()) + FormatDraw + 2
                        , index + 9 + FormatDraw
                        , new Color(250, 255, 0, 128).getRGB());

                if (mod) {
                    int modX = x + fontRenderer.getStringWidth(Category.MOVEMENT.name());
                    List<Mod> byCategory = Client.modManager.getByCategory(Category.values()[currentCategory]);
                    int modY = index;
                    for (int j = 0; j < byCategory.size(); j++) {
                        Mod m = byCategory.get(j);
                        int ChoiceColor = (j == currentMod ? new Color(190, 75, 245, 255).getRGB() : new Color(0, 117, 255, 153).getRGB());
                        Gui.drawRect(modX + FormatDraw + 2, modY + FormatDraw - 2
                                , modX + getModWidth() + FormatDraw + 6
                                , modY + 9 + FormatDraw
                                , ChoiceColor);

                        int SelectedColor = (m.isEnable() ? new Color(0, 0, 0, 255).getRGB() : new Color(120, 120, 120, 153).getRGB());
                        fontRenderer.drawString(m.getName()
                                , modX + FormatDraw + 4
                                , modY + FormatDraw
                                , SelectedColor);
                        modY += 11;
                    }
                }
            }
            fontRenderer.drawString(value.name()
                    , x + FormatDraw
                    , index + 4
                    , new Color(0 ,0, 0, 255).getRGB());
            index += 12;
        }
    }

    private int getModWidth() {
        List<Mod> byCategory = Client.modManager.getByCategory(Category.values()[currentCategory]);
        byCategory.sort((o1, o2) -> fontRenderer.getStringWidth(o2.getName()) - fontRenderer.getStringWidth(o1.getName()));
        return fontRenderer.getStringWidth(byCategory.get(0).getName());
    }
}
