package cn.star.client;

import cn.star.client.command.CommandManager;
import cn.star.client.config.ConfigManager;
import cn.star.client.mod.ModManager;
import cn.star.client.util.UtilTools;
import org.lwjgl.opengl.Display;

/**
 * Created by IntelliJ IDEA
 *
 * @author LiuStar2233
 * {@code @create} 2024/5/27 下午17:45
 */

public class Client {
    public static final String NAME = "StarClient";
    public static final String VERSION_FULL = "V1.0.3_Alpha";
    public static final String CLIENT_TITLE = NAME + " | " + VERSION_FULL + " | Minecraft 1.8.8";
    public static final String CLIENT_NAME = Client.NAME + " | " + Client.VERSION_FULL;

    public static ModManager modManager;
    public static ConfigManager configManager;
    public static CommandManager commandManager;

    public static void start() {
        UtilTools.PrintLog("Start The Client!!!", "Client Run/INFO");
        modManager = new ModManager();
        configManager = new ConfigManager();
        commandManager = new CommandManager();
        modManager.load();
        configManager.load();
        commandManager.load();
        Display.setTitle(CLIENT_TITLE);
    }

    public static void stop() {
        configManager.save();
        Display.setTitle(CLIENT_TITLE + " ShutDown Client...");
        UtilTools.PrintLog("ShutDown The Client!!!", "Client Stop/INFO");
    }
}