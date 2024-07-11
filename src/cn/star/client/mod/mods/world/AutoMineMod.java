package cn.star.client.mod.mods.world;

import cn.star.client.mod.Mod;
import cn.star.client.mod.mods.Category;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.init.Blocks;
import net.minecraft.util.MovingObjectPosition;
import org.lwjgl.input.Keyboard;

import static cn.star.client.util.UtilTools.MC;

/**
 * Created by IntelliJ IDEA
 *
 * @author LiuStar2233
 * {@code @create} 2024/7/8 下午6:28
 */

public class AutoMineMod extends Mod{
    int keyCode = MC.gameSettings.keyBindAttack.getKeyCode();

    public AutoMineMod() {
        super("AutoMine", Category.WORLD);
        setKey(Keyboard.KEY_NONE);
        setKeyboard("NONE");
    }

    @Override
    public void update() {
        if (MC.objectMouseOver.typeOfHit == MovingObjectPosition.MovingObjectType.BLOCK
                && MC.theWorld.getBlockState(MC.objectMouseOver.getBlockPos()).getBlock() != Blocks.air) {
            KeyBinding.setKeyBindState(keyCode, true);
        }
    }

    @Override
    public void disable() {
        KeyBinding.setKeyBindState(keyCode, false);
    }
}
