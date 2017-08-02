package cn.szzxol.pro.essential.messages;

import static cn.szzxol.pro.essential.Essential.DefaultConfig;
import static cn.szzxol.pro.essential.messages.MsgShow.MsgShowHomeList;
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

    public static void MsgGoHome(Player player) {
        MsgShowHomeList(player);
        player.sendMessage((new StringBuilder()).append(ChatColor.GOLD).append("输入 ").append(ChatColor.WHITE).append("/home <序号>").append(ChatColor.GOLD).append(" 回家").toString());
    }

    public static void MsgHomeSet(Player player) {
        player.sendMessage((new StringBuilder()).append(ChatColor.GOLD).append("已成功把你的当前位置设置为家").toString());
    }

    public static void MsgSpawnSet(Player player) {
        player.sendMessage((new StringBuilder()).append(ChatColor.GOLD).append("已成功把你的当前位置设置为出生点").toString());
    }

    public static void MsgSpawn(Player player) {
        player.sendMessage((new StringBuilder()).append(ChatColor.GOLD).append("传送到出生点...").toString());
    }

    public static void MsgFly(Player player, Player target) {
        player.sendMessage((new StringBuilder()).append(ChatColor.GOLD).append(getFlyMode(player)).append("了玩家 ").append(ChatColor.WHITE).append(target.getName()).append(ChatColor.GOLD).append(" 的飞行模式").toString());
    }

    public static void MsgHeal(Player player, Player target) {
        player.sendMessage((new StringBuilder()).append(ChatColor.GOLD).append("恢复了玩家 ").append(ChatColor.WHITE).append(target.getName()).append(ChatColor.GOLD).append(" 的生命值").toString());
    }

    public static void MsgGamemode(Player player, Player target) {
        player.sendMessage((new StringBuilder()).append(ChatColor.GOLD).append("已将玩家 ").append(ChatColor.WHITE).append(target.getName()).append(ChatColor.GOLD).append(" 的模式改为 ").append(ChatColor.WHITE).append(getGameMode(target)).toString());
    }

    public static void MsgSpeed(Player player, Player target, Float speed) {
        player.sendMessage((new StringBuilder()).append(ChatColor.GOLD).append("已将玩家 ").append(ChatColor.WHITE).append(target.getName()).append(ChatColor.GOLD).append(" 的").append(getFlyingMode(target)).append("速度设为 ").append(ChatColor.WHITE).append(speed).toString());
    }

    public static void MsgSun(Player player) {
        player.sendMessage((new StringBuilder()).append(ChatColor.GOLD).append("已将天气设置为晴天...").toString());
    }

    public static void MsgRain(Player player) {
        player.sendMessage((new StringBuilder()).append(ChatColor.GOLD).append("已将天气设置为雨天...").toString());
    }
    
    public static void MsgDay(Player player) {
        player.sendMessage((new StringBuilder()).append(ChatColor.GOLD).append("已将时间设置为白天...").toString());
    }
    
    public static void MsgNight(Player player) {
        player.sendMessage((new StringBuilder()).append(ChatColor.GOLD).append("已将时间设置为黑夜...").toString());
    }

    public static void MsgReload(Player player) {
        player.sendMessage((new StringBuilder()).append(ChatColor.GOLD).append("插件重载完成...").toString());
    }

    public static void MsgTp(Player player, Player target) {
        player.sendMessage((new StringBuilder()).append(ChatColor.GOLD).append("已传送到玩家 ").append(ChatColor.WHITE).append(target.getName()).append(ChatColor.GOLD).append(" 身边").toString());
    }

    public static void MsgTphere(Player player, Player target) {
        player.sendMessage((new StringBuilder()).append(ChatColor.GOLD).append("已把玩家 ").append(ChatColor.WHITE).append(target.getName()).append(ChatColor.GOLD).append(" 传送到你身边").toString());
        target.sendMessage((new StringBuilder()).append(ChatColor.AQUA).append(ChatColor.BOLD).append(player.getName()).append(ChatColor.WHITE).append(ChatColor.BOLD).append(" 把你传送到他的身边").toString());
    }

    public static void MsgTpRequest(Player player, Player target) {
        player.sendMessage((new StringBuilder()).append(ChatColor.GOLD).append("已向玩家 ").append(ChatColor.WHITE).append(target.getName()).append(ChatColor.GOLD).append(" 发送了传送请求").toString());
        target.sendMessage((new StringBuilder()).append(ChatColor.AQUA).append(ChatColor.BOLD).append(player.getName()).append(ChatColor.WHITE).append(ChatColor.BOLD).append(" 请求传送到您的身边").toString());
        target.sendMessage((new StringBuilder()).append(ChatColor.WHITE).append(ChatColor.BOLD).append("输入 ").append(ChatColor.GREEN).append(ChatColor.BOLD).append("/tpaccept").append(ChatColor.WHITE).append(ChatColor.BOLD).append(" 同意他的请求").toString());
        target.sendMessage((new StringBuilder()).append(ChatColor.WHITE).append(ChatColor.BOLD).append("输入 ").append(ChatColor.RED).append(ChatColor.BOLD).append("/tpdeny").append(ChatColor.WHITE).append(ChatColor.BOLD).append("   拒绝他的请求").toString());
    }

    public static void MsgTphereRequest(Player player, Player target) {
        player.sendMessage((new StringBuilder()).append(ChatColor.GOLD).append("已向玩家 ").append(ChatColor.WHITE).append(target.getName()).append(ChatColor.GOLD).append(" 发送了传送邀请").toString());
        target.sendMessage((new StringBuilder()).append(ChatColor.AQUA).append(ChatColor.BOLD).append(player.getName()).append(ChatColor.WHITE).append(ChatColor.BOLD).append(" 想让你传送到他身边").toString());
        target.sendMessage((new StringBuilder()).append(ChatColor.WHITE).append(ChatColor.BOLD).append("输入 ").append(ChatColor.GREEN).append(ChatColor.BOLD).append("/tpaccept").append(ChatColor.WHITE).append(ChatColor.BOLD).append(" 同意他的请求").toString());
        target.sendMessage((new StringBuilder()).append(ChatColor.WHITE).append(ChatColor.BOLD).append("输入 ").append(ChatColor.RED).append(ChatColor.BOLD).append("/tpdeny").append(ChatColor.WHITE).append(ChatColor.BOLD).append("   拒绝他的请求").toString());
    }

    public static void MsgTpAccept(Player player, Player target) {
        player.sendMessage((new StringBuilder()).append(ChatColor.GOLD).append("你已接受 ").append(target.getName()).append(" 的传送请求").toString());
        target.sendMessage((new StringBuilder()).append(ChatColor.GOLD).append(player.getName()).append(" 接受了你的传送请求").toString());
        target.sendMessage((new StringBuilder()).append(ChatColor.GOLD).append("正在传送...").toString());
    }

    public static void MsgTpDeny(Player player, Player target) {
        player.sendMessage((new StringBuilder()).append(ChatColor.GOLD).append("你已拒绝 ").append(target.getName()).append(" 的传送请求").toString());
        target.sendMessage((new StringBuilder()).append(ChatColor.GOLD).append(player.getName()).append(" 拒绝了你的传送请求").toString());
    }

    public static void MsgTpall(Player player, Player target) {
        player.sendMessage((new StringBuilder()).append(ChatColor.GOLD).append("已将玩家 ").append(ChatColor.WHITE).append(target.getName()).append(ChatColor.GOLD).append(" 传送到身边").toString());
        target.sendMessage((new StringBuilder()).append(ChatColor.GOLD).append("你被玩家 ").append(ChatColor.WHITE).append(player.getName()).append(ChatColor.GOLD).append(" 强制传送").toString());
    }

}
