package cn.star.client.mod.mods.draw;

import cn.star.client.mod.Mod;
import cn.star.client.mod.mods.Category;
import net.minecraft.client.entity.EntityPlayerSP;
import org.lwjgl.input.Keyboard;

import java.awt.*;

import static cn.star.client.util.UtilTools.*;

/**
 * Created by IntelliJ IDEA
 * @author LiuStar2233
 * {@code @create} 2024/7/7 下午4:06
 */

public class PosMod extends Mod{
    public PosMod() {
        super("Pos", Category.DRAW);
        setKey(Keyboard.KEY_NONE);
    }

    public String getPlayerPos() {
        EntityPlayerSP thePlayer = MC.thePlayer;
        long PosX = Math.round(thePlayer.posX);
        long PosY = Math.round(thePlayer.posY);
        long PosZ = Math.round(thePlayer.posZ);
        return String.format("X:%s Y:%s Z:%s", PosX, PosY, PosZ);
    }

    @Override
    public void draw() {
        String playerPos = "[" + getPlayerPos() + "]";
        int height = SR.getScaledHeight();
        int StringPosX = 5;
        int StringPosY = height - 14;
        int ColorRGB = new Color(0, 0, 0, 255).getRGB();
        fontRenderer.drawString(playerPos, StringPosX, StringPosY, ColorRGB);
    }
}
