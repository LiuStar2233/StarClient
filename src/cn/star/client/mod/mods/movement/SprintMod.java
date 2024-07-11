package cn.star.client.mod.mods.movement;

import cn.star.client.mod.Mod;
import cn.star.client.mod.mods.Category;
import org.lwjgl.input.Keyboard;

import static cn.star.client.util.UtilTools.MC;

/**
 * Created by IntelliJ IDEA
 * @author LiuStar2233
 * {@code @create} 2024/5/27 下午17:45
 */

public class SprintMod extends Mod {
    public SprintMod() {
        super("Sprint", Category.MOVEMENT);
        setKey(Keyboard.KEY_V);
    }

    @Override
    public void update() {
        if (MC.gameSettings.keyBindForward.isPressed()
                || MC.gameSettings.keyBindLeft.isPressed()
                || MC.gameSettings.keyBindRight.isPressed()
                || MC.gameSettings.keyBindBack.isPressed()
            )
        {
            if (!MC.thePlayer.isInWater())
                MC.thePlayer.setSprinting(true);
        }
    }
}
