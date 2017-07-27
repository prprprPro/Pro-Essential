package cn.szzxol.pro.essential.commands;

import java.util.ArrayList;
import java.util.List;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.entity.Player;

/**
 *
 * @author I_promise
 */
public class CommandTpall {

    public static boolean CommandTpall(Player player, Command cmd, String label, String[] args) {
        List<Player> AllPlayers = new ArrayList<>();
        AllPlayers.addAll(Bukkit.getServer().getOnlinePlayers());
        for (Player target : AllPlayers) {
            target.teleport(player);
            player.sendMessage((new StringBuilder()).append(ChatColor.GOLD).append("已将玩家 ").append(ChatColor.WHITE).append(target.getName()).append(ChatColor.GOLD).append(" 传送到身边").toString());
            target.sendMessage((new StringBuilder()).append(ChatColor.GOLD).append("你被玩家 ").append(ChatColor.WHITE).append(player.getName()).append(ChatColor.GOLD).append(" 强制传送").toString());
        }
        return true;
    }

}
