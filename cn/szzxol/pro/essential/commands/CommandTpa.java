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
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

/**
 *
 * @author I_promise
 */
public class CommandTpa {

    public static boolean CommandTpa(Player player, Command cmd, String label, String[] args) {
        if (args.length == 1) {
            TPA(player, args[0]);
            return true;
        } else {
            MsgErrorArgs(player);
            return true;
        }
    }

    public static void TPA(Player player, String TargetName) {
        if (TargetName.equals(player.getName())) {
            player.sendMessage((new StringBuilder()).append(ChatColor.RED).append(ChatColor.BOLD).append("不可以向自己发送传送请求").toString());
            return;
        }
        String Name = player.getName();
        List<Player> AllPlayers = new ArrayList<>();
        AllPlayers.addAll(Bukkit.getServer().getOnlinePlayers());
        for (Player target : AllPlayers) {
            if (TargetName == null ? false : (TargetName.equalsIgnoreCase(target.getName()) || target.getName().toLowerCase().startsWith(TargetName.toLowerCase()))) {
                YamlConfiguration config = getConfiguration("/players/" + TargetName);
                config.set("Request.TPATYPE", 1);
                config.set("Request.TPA", Name);
                saveConfiguration(config, "/players/" + TargetName);
                player.sendMessage((new StringBuilder()).append(ChatColor.GOLD).append("已向玩家 ").append(ChatColor.WHITE).append(target.getName()).append(ChatColor.GOLD).append(" 发送了传送请求").toString());
                target.sendMessage((new StringBuilder()).append(ChatColor.AQUA).append(ChatColor.BOLD).append(Name).append(ChatColor.WHITE).append(ChatColor.BOLD).append(" 请求传送到您的身边").toString());
                target.sendMessage((new StringBuilder()).append(ChatColor.WHITE).append(ChatColor.BOLD).append("输入 ").append(ChatColor.GREEN).append(ChatColor.BOLD).append("/tpaccept").append(ChatColor.WHITE).append(ChatColor.BOLD).append(" 同意他的请求").toString());
                target.sendMessage((new StringBuilder()).append(ChatColor.WHITE).append(ChatColor.BOLD).append("输入 ").append(ChatColor.RED).append(ChatColor.BOLD).append("/tpdeny").append(ChatColor.WHITE).append(ChatColor.BOLD).append("   拒绝他的请求").toString());
                return;
            }
        }
        MsgPlayerNotFound(player, TargetName);
        return;
    }
}
