package cn.star.client.mod.mods.movement;

import cn.star.client.mod.Mod;
import cn.star.client.mod.mods.Category;
import net.minecraft.client.gui.GuiChat;
import net.minecraft.client.settings.GameSettings;
import net.minecraft.client.settings.KeyBinding;
import org.lwjgl.input.Keyboard;

import static cn.star.client.util.UtilTools.MC;

/**
 * Created by IntelliJ IDEA
 *
 * @author LiuStar2233
 * {@code @create} 2024/7/8 下午4:55
 */

public class InventoryMoveMod extends Mod{
    public InventoryMoveMod() {
        super("InventoryMove",Category.MOVEMENT);
        setKey(Keyboard.KEY_NONE);
    }

    @Override
    public void update() {
        if (MC.currentScreen instanceof GuiChat) {
            return;
        }

        GameSettings gameSettings = MC.gameSettings;
        KeyBinding[] keyBindings = {gameSettings.keyBindForward
                , gameSettings.keyBindBack
                , gameSettings.keyBindLeft
                , gameSettings.keyBindRight
                , gameSettings.keyBindJump
                , gameSettings.keyBindSprint
                , gameSettings.keyBindSneak};
        for (KeyBinding keyBinding : keyBindings) {
            KeyBinding.setKeyBindState(keyBinding.getKeyCode(), Keyboard.isKeyDown(keyBinding.getKeyCode()));
        }
    }
}
