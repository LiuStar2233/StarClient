package cn.star.client.command;

import cn.star.client.command.commands.EnableCommand;
import cn.star.client.command.commands.HelpCommand;
import java.util.*;

/**
 * Created by IntelliJ IDEA
 * @author LiuStar2233
 * {@code @create} 2024/7/3 下午7:45
 */

public class CommandManager {
    private final Map<String[], Command> commandMap = new HashMap<>();

    public void load() {
        HelpCommand helpCommand = new HelpCommand();
        commandMap.put(helpCommand.getKey(), helpCommand);
        EnableCommand enableCommand = new EnableCommand();
        commandMap.put(enableCommand.getKey(), enableCommand);
    }

    public boolean run(String message) {
        if ('|' == message.charAt(0)) {
            String substring = message.substring(1);

            String[] s = substring.split(" ");

            String key = s[0];
            Command command = getCommand(key);

            if (command != null) {
                List<String> args = new ArrayList<>();
                Collections.addAll(args, s);
                args.remove(0);
                command.run(args.toArray(new String[0]));
            }
            return true;
        }
        return false;
    }

    public Command getCommand(String key) {
        for (Map.Entry<String[], Command> commandEntry : commandMap.entrySet()) {
            for (String k : commandEntry.getKey()) {
                if (k.equals(key)) {
                    return commandEntry.getValue();
                }
            }
        }
        return null;
    }
}
