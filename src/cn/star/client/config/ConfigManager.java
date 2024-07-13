package cn.star.client.config;

import cn.star.client.config.configs.ModConfig;
import cn.star.client.util.UtilTools;

import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by IntelliJ IDEA
 *
 * @author LiuStar2233
 * {@code @create} 2024/7/2 下午9:31
 */

public class ConfigManager {
    private final List<Config> configs = new ArrayList<Config>() {
        {
            add(new ModConfig());
        }
    };

    public void load() {
        for (Config config : configs) {
            if (config.getPath().toFile().exists()) {
                config.load();
            }
        }

        UtilTools.PrintLog("ConfigManager Loading...", "Config Run/INFO");
    }

    public void save() {
        for (Config config : configs) {
            if (!config.getPath().toFile().exists()) {
                try {
                    Files.createDirectories(config.getPath().getParent());
                    config.getPath().toFile().createNewFile();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            config.save();
        }

        UtilTools.PrintLog("ConfigManager Saving...", "Config Run/INFO");
    }
}