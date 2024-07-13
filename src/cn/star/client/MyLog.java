package cn.star.client;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

/**
 * Created by IntelliJ IDEA
 *
 * @author LiuStar2233
 * {@code @create} 2024/7/13 下午1:38
 */

public class MyLog {
    public static DateTimeFormatter Time_formatter = DateTimeFormatter.ofPattern("HH:mm:ss");

    public static MyLog My_Log(String Log, String Type) {
        LocalTime time = LocalTime.now();
        String OutPut_Log = "[" + time.format(Time_formatter) + "]";
        String OutPut_Type = " [" + Type + "]";
        System.out.println("\033[36m" + OutPut_Log + OutPut_Type + ": " + Log + "\033[0m");
        return null;
    }
}
