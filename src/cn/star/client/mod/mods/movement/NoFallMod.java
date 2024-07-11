package cn.star.client.mod.mods.movement;

import cn.star.client.mod.Mod;
import cn.star.client.mod.mods.Category;
import net.minecraft.network.play.client.C03PacketPlayer;
import org.lwjgl.input.Keyboard;

import static cn.star.client.util.UtilTools.MC;

/**
 * Created by IntelliJ IDEA
 *
 * @author LiuStar2233
 * {@code @create} 2024/7/11 下午3:42
 */

public class NoFallMod extends Mod{
    public NoFallMod() {
        super("NoFall", Category.MOVEMENT);
        setKey(Keyboard.KEY_NONE);
        setKeyboard("NONE");
    }

    @Override
    public void update() {
        if (MC.thePlayer.fallDistance > 1) {
            MC.getNetHandler().addToSendQueue(new C03PacketPlayer(true));
        }
    }
}
