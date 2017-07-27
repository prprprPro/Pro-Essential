package cn.szzxol.pro.essential.commands;

import static cn.szzxol.pro.essential.messages.MsgError.MsgErrorArgs;
import static cn.szzxol.pro.essential.messages.MsgError.MsgPlayerNotFound;
import static cn.szzxol.pro.essential.messages.MsgTip.MsgTp;
import java.util.ArrayList;
import java.util.List;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.entity.Player;

/**
 *
 * @author I_promise
 */
public class CommandTp {

    public static boolean CommandTp(Player player, Command cmd, String label, String[] args) {
        switch (args.length) {
            case 1:
                TP(player, args[0]);
                return true;
            case 3:
                TPposition(player, args);
                return true;
            default:
                MsgErrorArgs(player);
                return true;
        }
    }

    public static void TP(Player player, String TargetName) {
        List<Player> AllPlayers = new ArrayList<>();
        AllPlayers.addAll(Bukkit.getServer().getOnlinePlayers());
        for (Player target : AllPlayers) {
            if (TargetName == null ? false : (TargetName.equalsIgnoreCase(target.getName()) || target.getName().toLowerCase().startsWith(TargetName.toLowerCase()))) {
                player.teleport(target);
                MsgTp(player, target);
                return;
            }
        }
        MsgPlayerNotFound(player, TargetName);
        return;
    }

    public static void TPposition(Player player, String[] args) {
        try {
            double n1 = Double.valueOf(args[0]);
            double n2 = Double.valueOf(args[1]);
            double n3 = Double.valueOf(args[2]);
        } catch (Exception e) {
            MsgErrorArgs(player);
            return;
        }
        double x = Double.valueOf(args[0]);
        double y = Double.valueOf(args[1]);
        double z = Double.valueOf(args[2]);
        Location l = new Location(player.getWorld(), x, y, z);
        player.teleport(l);
        return;
    }
}
