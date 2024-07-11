package cn.star.client.mod;

/**
 * Created by IntelliJ IDEA
 *
 * @author LiuStar2233
 * {@code @create} 2024/5/27 下午17:45
 */

import cn.star.client.mod.mods.Category;

public class Mod {
    private final String name;
    private final Category category;
    private boolean enable;
    private int key;
    private String keyboard;

    public Mod(String name, Category category) {
        this.name = name;
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public String getKeyboard() {
        return keyboard;
    }

    public boolean isEnable() {
        return enable;
    }

    public void setEnable(boolean enable) {
        this.enable = enable;
        if (enable) {
            enable();
        } else {
            disable();
        }
    }

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public void setKeyboard(String keyboard) {
        this.keyboard = keyboard;
    }

    public Category getCategory() {
        return category;
    }

    public void enable() {

    }

    public void disable() {

    }

    public void draw() {

    }

    public void render() {

    }

    public void update() {

    }

    public void key(int key) {

    }
}
