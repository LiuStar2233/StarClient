package cn.star.client;

import cn.star.client.command.CommandManager;
import cn.star.client.config.ConfigManager;
import cn.star.client.mod.ModManager;
import org.lwjgl.opengl.Display;
import java.time.*;
import java.time.format.*;

/**
 * Created by IntelliJ IDEA
 * @author LiuStar2233
 * {@code @create} 2024/5/27 下午17:45
 */

public class Client {
    public static final String NAME = "StarClient";
    public static final String VERSION_FULL = "V1.0.0_Alpha";
    public static final String CLIENT_TITLE = NAME + " | " + VERSION_FULL + " | Minecraft 1.8.8";
    public static final String CLIENT_NAME = Client.NAME + " | " + Client.VERSION_FULL;
    public static DateTimeFormatter Time_formatter = DateTimeFormatter.ofPattern("HH:mm:ss");

    public static ModManager modManager;
    public static ConfigManager configManager;
    public static CommandManager commandManager;

    public static void My_Log(String Log, String Type) {
        LocalTime time = LocalTime.now();
        String OutPut_Log = "[" + time.format(Time_formatter) + "]";
        String OutPut_Type = " [" + Type + "]";
        System.out.println("\033[36m" + OutPut_Log + OutPut_Type + ": " + Log + "\033[0m");
    }

    public static void start() {
        modManager = new ModManager();
        modManager.load();
        configManager = new ConfigManager();
        configManager.load();
        commandManager = new CommandManager();
        commandManager.load();
        Display.setTitle(CLIENT_TITLE);
        My_Log("Start The Client!!!", "Client Run/INFO");
    }

    public static void stop() {
        configManager.save();

        Display.setTitle(CLIENT_TITLE + " ShutDown Client...");
        My_Log("ShutDown The Client!!!", "Client Stop/INFO");
    }
}