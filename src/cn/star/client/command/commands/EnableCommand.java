package cn.star.client.command.commands;

import cn.star.client.Client;
import cn.star.client.command.Command;
import cn.star.client.mod.Mod;
import cn.star.client.util.UtilTools;

import java.util.Arrays;

import static cn.star.client.util.UtilTools.PrintMessage;

/**
 * Created by IntelliJ IDEA
 * @author LiuStar2233
 * {@code @create} 2024/7/3 下午9:19
 */

public class EnableCommand extends Command {
    public EnableCommand() {
        super(new String[]{"e", "enable", "E", "ENABLE"});

        UtilTools.PrintLog("EnableCommand Run...", "Command Run/INFO");
    }

    @Override
    public void run(String[] args) {
        PrintMessage("\n§8You can use these commands to turn modules on and off: \n");
        PrintMessage("§9Command:\n");
        PrintMessage("§a|e §8<Mod Name>\n§f");

        if (args.length == 1) {
            Mod byName = Client.modManager.getByName(args[0]);
            if (byName != null) {
                byName.setEnable(!byName.isEnable());
            } else {
                PrintMessage("§4Mod " + args[0] + " not found!§f");
            }
        }
        System.out.println(Arrays.toString(args));
    }
}
