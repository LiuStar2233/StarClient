package cn.star.client.command;

/**
 * Created by IntelliJ IDEA
 *
 * @author LiuStar2233
 * {@code @create} 2024/7/3 下午7:46
 */

public abstract class Command {
    private final String[] key;

    public Command(String[] key) {
        this.key = key;
    }

    public abstract void run(String[] args);

    public String[] getKey() {
        return key;
    }
}
