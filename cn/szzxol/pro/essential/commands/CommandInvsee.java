package cn.szzxol.pro.essential.commands;

import static cn.szzxol.pro.essential.messages.MsgError.MsgPlayerNotFound;
import java.util.ArrayList;
import java.util.List;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.entity.Player;

/**
 *
 * @author I_promise
 */
public class CommandInvsee {

    public static boolean CommandInvsee(Player player, Command cmd, String label, String[] args) {
        if (args.length > 0) {
            String TargetName = args[0];
            List<Player> AllPlayers = new ArrayList<>();
            AllPlayers.addAll(Bukkit.getServer().getOnlinePlayers());
            for (Player target : AllPlayers) {
                if (TargetName == null ? false : (TargetName.equalsIgnoreCase(target.getName()) || target.getName().toLowerCase().startsWith(TargetName.toLowerCase()))) {
                    player.openInventory(target.getInventory());
                    return true;
                }
            }
            MsgPlayerNotFound(player, TargetName);
        }
        return true;
    }

}
