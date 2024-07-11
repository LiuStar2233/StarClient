package cn.star.client.command.commands;

import cn.star.client.command.Command;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiNewChat;
import net.minecraft.util.ChatComponentText;

import java.util.Arrays;

import static cn.star.client.util.UtilTools.MC;
import static cn.star.client.util.UtilTools.PrintMessage;

/**
 * Created by IntelliJ IDEA
 * @author LiuStar2233
 * {@code @create} 2024/7/3 下午8:20
 */

public class HelpCommand extends Command {
    public HelpCommand() {
        super(new String[]{"h", "help", "H", "HELP", "?"});
    }

    @Override
    public void run(String[] args) {
        PrintMessage("\n§1This client was made by LiuStar2233(GitHub user)!!! \n");

        PrintMessage("§bIf you have problems with the client, please email me: \n");
        PrintMessage("§bLhx14776409450@163.com or Lhx14776409450@outlook.com \n");

        PrintMessage("§8All Command: \n");
        PrintMessage("§9Enable/disable the module: \n");
        PrintMessage("§a|e §8<Mod Name>\n");
        PrintMessage("§9View module shortcuts: \n");
        PrintMessage("§a|k §f\n");

        System.out.println(Arrays.toString(args));
    }
}
