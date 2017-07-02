package cn.szzxol.pro.essential.commands;

import static cn.szzxol.pro.essential.utils.Configuration.getConfiguration;
import static cn.szzxol.pro.essential.utils.Configuration.saveConfiguration;
import static cn.szzxol.pro.essential.messages.MsgError.MsgErrorArgs;
import static cn.szzxol.pro.essential.messages.MsgError.MsgPlayerNotFound;
import java.util.ArrayList;
import java.util.List;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

/**
 *
 * @author I_promise
 */
public class CommandTpahere {

    public static boolean CommandTpahere(Player player, Command cmd, String label, String[] args) {
        if (args.length == 1) {
            TPAHere(player, args[0]);
            return true;
        } else {
            MsgErrorArgs(player);
            return true;
        }
    }

    public static void TPAHere(Player player, String TargetName) {
        if (TargetName.equals(player.getName())) {
            player.sendMessage((new StringBuilder()).append(ChatColor.RED).append(ChatColor.BOLD).append("不可以向自己发送传送请求").toString());
            return;
        }
        String Name = player.getName();
        List<Player> AllPlayers = new ArrayList<>();
        AllPlayers.addAll(Bukkit.getServer().getOnlinePlayers());
        for (Player target : AllPlayers) {
            if (TargetName == null ? false : TargetName.equals(target.getName())) {
                YamlConfiguration config = getConfiguration("/players/" + TargetName);
                config.set("Request.TPATYPE", 2);
                config.set("Request.TPA", Name);
                saveConfiguration(config, "/players/" + TargetName);
                player.sendMessage((new StringBuilder()).append(ChatColor.GOLD).append("已向玩家 ").append(ChatColor.WHITE).append(TargetName).append(ChatColor.GOLD).append(" 发送了传送邀请").toString());
                target.sendMessage((new StringBuilder()).append(ChatColor.AQUA).append(ChatColor.BOLD).append(Name).append(ChatColor.WHITE).append(ChatColor.BOLD).append(" 想让你传送到他身边").toString());
                target.sendMessage((new StringBuilder()).append(ChatColor.WHITE).append(ChatColor.BOLD).append("输入 ").append(ChatColor.GREEN).append(ChatColor.BOLD).append("/tpaccept").append(ChatColor.WHITE).append(ChatColor.BOLD).append(" 同意他的请求").toString());
                target.sendMessage((new StringBuilder()).append(ChatColor.WHITE).append(ChatColor.BOLD).append("输入 ").append(ChatColor.RED).append(ChatColor.BOLD).append("/tpdeny").append(ChatColor.WHITE).append(ChatColor.BOLD).append("   拒绝他的请求").toString());
                return;
            }
        }
        MsgPlayerNotFound(player,TargetName);
        return;
    }
}
