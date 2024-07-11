package cn.star.client.command.commands;

import cn.star.client.Client;
import cn.star.client.command.Command;
import cn.star.client.mod.Mod;

import java.util.Arrays;

import static cn.star.client.util.UtilTools.PrintMessage;

/**
 * Created by IntelliJ IDEA
 *
 * @author LiuStar2233
 * {@code @create} 2024/7/11 下午4:30
 */

public class KeyBoardCommand extends Command{
    public KeyBoardCommand() {
        super(new String[]{"k", "key", "keyboard ", "K", "KEY", "KEYBOARD"});
    }

    @Override
    public void run(String[] args) {
        PrintMessage("\n§6Below is a list of module shortcuts.");
        for (Mod mod : Client.modManager.getMods()) {
            PrintMessage("§7" + mod.getName() + ": " + mod.getKeyboard());
        }
        PrintMessage("§f");
        System.out.println(Arrays.toString(args));
    }
}
