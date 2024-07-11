package cn.star.client.mod.mods.render;

import cn.star.client.mod.Mod;
import cn.star.client.mod.mods.Category;
import org.lwjgl.input.Keyboard;

/**
 * Created by IntelliJ IDEA
 *
 * @author LiuStar2233
 * {@code @create} 2024/7/11 下午3:07
 */

public class SelectBlockMod extends Mod{
    public SelectBlockMod() {
        super("SelectBlock", Category.RENDER);
        setKey(Keyboard.KEY_G);
    }


}
