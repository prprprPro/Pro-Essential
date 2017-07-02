package cn.szzxol.pro.essential.messages;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

/**
 *
 * @author I_promise
 */
public class MsgError {

    public static void MsgNoPermission(Player player) {
        player.sendMessage((new StringBuilder()).append(ChatColor.RED).append(ChatColor.BOLD).append("你没有权限执行这个指令").toString());
    }

    public static void MsgErrorArgs(Player player) {
        player.sendMessage((new StringBuilder()).append(ChatColor.RED).append(ChatColor.BOLD).append("参数错误").toString());
    }

    public static void MsgPlayerNotFound(Player player, String TargetName) {
        player.sendMessage((new StringBuilder()).append(ChatColor.RED).append(ChatColor.BOLD).append("玩家 ").append(TargetName).append(" 不在线或不存在").toString());
    }

    public static void MsgNoTeleportRequest(Player player) {
        player.sendMessage((new StringBuilder()).append(ChatColor.RED).append(ChatColor.BOLD).append("你暂时没有传送请求").toString());
    }

    public static void MsgHomeNotSet(Player player) {
        player.sendMessage((new StringBuilder()).append(ChatColor.RED).append(ChatColor.BOLD).append("你还没有设置这个家的坐标").toString());
    }

}
