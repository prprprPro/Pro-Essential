package cn.szzxol.pro.essential.commands;

import static cn.szzxol.pro.essential.messages.MsgError.MsgErrorArgs;
import static cn.szzxol.pro.essential.messages.MsgError.MsgPlayerNotFound;
import static cn.szzxol.pro.essential.messages.MsgTip.MsgFly;
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
public class CommandFly {

    public static boolean CommandFly(Player player, Command cmd, String label, String[] args) {
        if (args.length < 1) {
            Fly(player);
            MsgFly(player, player);
            return true;
        } else if (args.length == 1) {
            List<Player> AllPlayers = new ArrayList<>();
            AllPlayers.addAll(Bukkit.getServer().getOnlinePlayers());
            for (Player target : AllPlayers) {
                if (args[0].equals(target.getName())) {
                    Fly(target);
                    MsgFly(player, target);
                    return true;
                }
            }
            MsgPlayerNotFound(player, args[0]);
            return true;
        } else {
            MsgErrorArgs(player);
            return true;
        }
    }

    public static void Fly(Player player) {
        if (!player.isFlying()) {
            player.setAllowFlight(true);
        } else {
            player.setAllowFlight(false);
        }
    }
}
