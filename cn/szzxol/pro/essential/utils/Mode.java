package cn.szzxol.pro.essential.utils;

import org.bukkit.entity.Player;

/**
 *
 * @author I_promise
 */
public class Mode {

    public static String getFlyMode(Player player) {
        if (player.isFlying()) {
            return "开启";
        } else {
            return "关闭";
        }
    }

    public static String getFlyingMode(Player player) {
        if (player.isFlying()) {
            return "飞行";
        } else {
            return "行走";
        }
    }

    public static String getGameMode(Player player) {
        String gamemode = player.getGameMode().toString();
        if (null != gamemode) {
            switch (gamemode) {
                case "SURVIVAL":
                    return "生存模式";
                case "CREATIVE":
                    return "创造模式";
                case "ADVENTURE":
                    return "冒险模式";
                case "SPECTATOR":
                    return "旁观模式";
            }
        }
        return "未知模式";
    }

}
