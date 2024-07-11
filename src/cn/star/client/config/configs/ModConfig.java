package cn.star.client.config.configs;

import cn.star.client.Client;
import cn.star.client.config.Config;
import cn.star.client.mod.Mod;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;

/*
 * Created by IntelliJ IDEA
 * @author LiuStar2233
 * @create 2024/7/2 下午9:31
 */

public class ModConfig extends Config {
    public ModConfig() {
        super("Mod");
    }

    @Override
    public void save() {
        JsonObject jsonObject = new JsonObject();
        for (Mod mod : Client.modManager.getMods()) {
            JsonObject modJsonObject = new JsonObject();
            modJsonObject.addProperty("key", mod.getKey());
            modJsonObject.addProperty("enable", mod.isEnable());
            jsonObject.add(mod.getName(), modJsonObject);
        }
        try {
            Files.write(getPath(), new GsonBuilder().setPrettyPrinting().create().toJson(jsonObject).getBytes(StandardCharsets.UTF_8));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        System.out.println("\033[32mSave Mod Config...\033[0m");
    }

    @Override
    public void load() {
        try {
            JsonObject jsonObject = new Gson().fromJson(new String(Files.readAllBytes(getPath()), StandardCharsets.UTF_8), JsonObject.class);
            for (Mod mod : Client.modManager.getMods()) {
                if (jsonObject.has(mod.getName())) {
                    JsonObject modJsonObject = jsonObject.get(mod.getName()).getAsJsonObject();
                    if (modJsonObject.has("enable")) {
                        mod.setEnable(modJsonObject.get("enable").getAsBoolean());
                    }

                    if (modJsonObject.has("key")) {
                        mod.setKey(modJsonObject.get("key").getAsInt());
                    }
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        System.out.println("\033[32mLoad Mod Config...\033[0m");
    }
}