package cn.star.client.command.commands;

import cn.star.client.command.Command;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiNewChat;
import net.minecraft.util.ChatComponentText;

import java.util.Arrays;

import static cn.star.client.util.UtilTools.MC;

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
        GuiNewChat Chat = MC.ingameGUI.getChatGUI();

        ChatComponentText Introduce = new ChatComponentText("This client was made by LiuStar2233(GitHub user)!!! \n");
        Chat.printChatMessage(Introduce);
        ChatComponentText ContactWay = new ChatComponentText("If you have problems with the client, please email me:");
        Chat.printChatMessage(ContactWay);
        ChatComponentText Email = new ChatComponentText("Lhx14776409450@163.com or Lhx14776409450@outlook.com \n");
        Chat.printChatMessage(Email);

        ChatComponentText ModCommandHelp = new ChatComponentText("You can enable and disable client-side modules with these commands.");
        Chat.printChatMessage(ModCommandHelp);
        ChatComponentText ModCommand = new ChatComponentText("Command: |e    |enable    |E    |ENABLE");
        Chat.printChatMessage(ModCommand);

        System.out.println(Arrays.toString(args));
    }
}
