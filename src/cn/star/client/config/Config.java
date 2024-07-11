package cn.star.client.config;

import java.nio.file.Path;
import java.nio.file.Paths;

import static cn.star.client.util.UtilTools.MC;

/**
 * Created by IntelliJ IDEA
 * @author LiuStar2233
 * {@code @create} 2024/7/2 下午9:31
 */

public class Config {
    private final String name;

    public Config(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Path getPath() {
        return Paths.get(MC.mcDataDir.getAbsolutePath(), "StarClient/config/", name + ".json");
    }

    public void load() {}

    public void save() {}

}