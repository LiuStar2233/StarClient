package cn.star.client.command.commands;

import cn.star.client.Client;
import cn.star.client.command.Command;
import cn.star.client.mod.Mod;
import net.minecraft.client.gui.GuiNewChat;
import net.minecraft.util.ChatComponentText;

import java.util.Arrays;

import static cn.star.client.util.UtilTools.MC;

/**
 * Created by IntelliJ IDEA
 * @author LiuStar2233
 * {@code @create} 2024/7/3 下午9:19
 */

public class EnableCommand extends Command {
    public EnableCommand() {
        super(new String[]{"e", "enable", "E", "ENABLE"});
    }

    @Override
    public void run(String[] args) {
        GuiNewChat Chat = MC.ingameGUI.getChatGUI();
        ChatComponentText ModCommandHelp = new ChatComponentText("You can use these commands to get client-side help documentation.");
        Chat.printChatMessage(ModCommandHelp);
        ChatComponentText ModCommand = new ChatComponentText("Command: |h    |help    |H    |HELP    |?");
        Chat.printChatMessage(ModCommand);

        if (args.length == 1) {
            Mod byName = Client.modManager.getByName(args[0]);
            if (byName != null) {
                byName.setEnable(!byName.isEnable());
            } else {
                MC.ingameGUI.getChatGUI().printChatMessage(new ChatComponentText("Mod " + args[0] + " not found!"));
            }
        }
        System.out.println(Arrays.toString(args));
    }
}
