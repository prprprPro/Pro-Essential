package cn.szzxol.pro.essential.commands;

import static cn.szzxol.pro.essential.messages.MsgError.MsgErrorArgs;
import static cn.szzxol.pro.essential.messages.MsgError.MsgNoPermission;
import static cn.szzxol.pro.essential.messages.MsgError.MsgPlayerNotFound;
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
public class CommandTphere {

    public static boolean CommandTphere(Player player, Command cmd, String label, String[] args) {
        if (args.length == 1) {
            TPHere(player, args[0]);
            return true;
        } else {
            MsgErrorArgs(player);
            return true;
        }
    }

    public static void TPHere(Player player, String TargetName) {
        String Name = player.getName();
        List<Player> AllPlayers = new ArrayList<>();
        AllPlayers.addAll(Bukkit.getServer().getOnlinePlayers());
        for (Player target : AllPlayers) {
            if (TargetName == null ? false : (TargetName.equalsIgnoreCase(target.getName()) || target.getName().toLowerCase().startsWith(TargetName.toLowerCase()))) {
                target.teleport(player);
                player.sendMessage((new StringBuilder()).append(ChatColor.GOLD).append("已把玩家 ").append(ChatColor.WHITE).append(target.getName()).append(ChatColor.GOLD).append(" 传送到你身边").toString());
                target.sendMessage((new StringBuilder()).append(ChatColor.AQUA).append(ChatColor.BOLD).append(Name).append(ChatColor.WHITE).append(ChatColor.BOLD).append(" 把你传送到他的身边").toString());
                return;
            }
        }
        MsgPlayerNotFound(player, TargetName);
        return;
    }
}
