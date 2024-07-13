package cn.star.client.mod;

import cn.star.client.mod.mods.Category;
import cn.star.client.mod.mods.combat.*;
import cn.star.client.mod.mods.draw.*;
import cn.star.client.mod.mods.movement.*;
import cn.star.client.mod.mods.render.*;
import cn.star.client.mod.mods.world.*;
import cn.star.client.util.UtilTools;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by IntelliJ IDEA
 * @author LiuStar2233
 * {@code @create} 2024/5/27 下午17:45
 */

public class ModManager {
    private final List<Mod> mods = new ArrayList<>();

    public List<Mod> getMods() {
        return mods;
    }

    public List<Mod> getEnableMods() {
        return mods.stream().filter(Mod::isEnable).collect(Collectors.toList());
    }

    public void onKey(int key) {
        for (Mod TheMod : mods) {
            if (TheMod.getKey() == key) {
                TheMod.setEnable(!TheMod.isEnable());
            }
        }
    }

    public void load() {
        // combat
        mods.add(new AutoAttackMod());

        // draw
        mods.add(new TabMod());
        mods.add(new ModListMod());
        mods.add(new LogoMod());
        mods.add(new FPSMod());
        mods.add(new PosMod());
        mods.add(new InventoryMod());
        mods.add(new TargetInfoMod());
        mods.add(new KeyBoardMod());
        mods.add(new ClickGuiMod());

        // movement
        mods.add(new SprintMod());
        mods.add(new NoFallMod());
        mods.add(new InventoryMoveMod());

        // render
        mods.add(new HitBoxMod());
        mods.add(new CapeMod());
        mods.add(new NameLabelMod());
        mods.add(new NoHurtCameraMod());
        mods.add(new SelectBlockMod());

        // world
        mods.add(new QuickDropMod());
        mods.add(new FallWaterMod());
        mods.add(new XRayMod());
        mods.add(new AutoMineMod());

        UtilTools.PrintLog("ModManager Run...", "Mod Run/INFO");
    }

    public Mod getByName(String name) {
        for (Mod mod : mods) {
            if (name.equalsIgnoreCase(mod.getName())) {
                return mod;
            }
        }
        return null;
    }

    public Mod getByClass(Class<? extends Mod> modClass) {
        for (Mod mod : mods) {
            if (mod.getClass() == modClass) {
                return mod;
            }
        }
        return null;
    }

    public List<Mod> getByCategory(Category category) {
        return mods.stream().filter(m -> m.getCategory() == category).collect(Collectors.toList());
    }
}
