package cn.szzxol.pro.essential.messages;

import static cn.szzxol.pro.essential.Essential.DefaultConfig;
import static cn.szzxol.pro.essential.utils.Mode.getFlyMode;
import static cn.szzxol.pro.essential.utils.Mode.getFlyingMode;
import static cn.szzxol.pro.essential.utils.Mode.getGameMode;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

/**
 *
 * @author I_promise
 */
public class MsgTip {

    public static void MsgBack(Player player) {
        player.sendMessage((new StringBuilder()).append(ChatColor.GOLD).append("正在回到上一位置...").toString());
    }

    public static void MsgHome(Player player) {
        player.sendMessage((new StringBuilder()).append(ChatColor.GOLD).append("正在回到家中...").toString());
    }

    public static void MsgisSettingHome(Player player) {
        player.sendMessage((new StringBuilder()).append(ChatColor.GOLD).append("已进入SetHome模式").toString());
        player.sendMessage((new StringBuilder()).append(ChatColor.GOLD).append("输入 ").append(ChatColor.WHITE).append("1-").append(DefaultConfig.getInt("Settings.MaxAmountOfHome")).append(ChatColor.GOLD).append(" 的任意数字把您的位置设为指定编号的家").toString());
    }

    public static void MsgHomeSet(Player player) {
        player.sendMessage((new StringBuilder()).append(ChatColor.GOLD).append("已成功把你的当前位置设置为家").toString());
    }

    public static void MsgSpawn(Player player) {
        player.sendMessage((new StringBuilder()).append(ChatColor.GOLD).append("传送到出生点...").toString());
    }

    public static void MsgFly(Player player, Player target) {
        player.sendMessage((new StringBuilder()).append(ChatColor.GOLD).append(getFlyMode(player)).append("了玩家 ").append(ChatColor.WHITE).append(target.getName()).append(ChatColor.GOLD).append(" 的飞行模式").toString());
    }

    public static void MsgGamemode(Player player, Player target) {
        player.sendMessage((new StringBuilder()).append(ChatColor.GOLD).append("已将玩家 ").append(ChatColor.WHITE).append(target.getName()).append(ChatColor.GOLD).append(" 的模式改为 ").append(ChatColor.WHITE).append(getGameMode(target)).toString());
    }

    public static void MsgSpeed(Player player, Player target, Float speed) {
        player.sendMessage((new StringBuilder()).append(ChatColor.GOLD).append("已将玩家 ").append(ChatColor.WHITE).append(target.getName()).append(ChatColor.GOLD).append(" 的").append(getFlyingMode(target)).append("速度设为 ").append(ChatColor.WHITE).append(speed).toString());
    }

}
