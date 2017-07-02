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
public class CommandTp {

    public static boolean CommandTp(Player player, Command cmd, String label, String[] args) {
        if (args.length == 1) {
            TP(player, args[0]);
            return true;
        } else {
            MsgErrorArgs(player);
            return true;
        }
    }

    public static void TP(Player player, String TargetName) {
        if (!player.isOp()) {
            MsgNoPermission(player);
            return;
        }
        List<Player> AllPlayers = new ArrayList<>();
        AllPlayers.addAll(Bukkit.getServer().getOnlinePlayers());
        for (Player target : AllPlayers) {
            if (TargetName == null ? false : TargetName.equals(target.getName()) || target.getName().toLowerCase().startsWith(TargetName)) {
                player.teleport(target);
                player.sendMessage((new StringBuilder()).append(ChatColor.GOLD).append("已传送到玩家 ").append(ChatColor.WHITE).append(TargetName).append(ChatColor.GOLD).append(" 身边").toString());
                return;
            }
        }
        MsgPlayerNotFound(player, TargetName);
        return;
    }
}
