package cn.szzxol.pro.essential.commands;

import static cn.szzxol.pro.essential.utils.Configuration.getConfiguration;
import static cn.szzxol.pro.essential.utils.Configuration.saveConfiguration;
import static cn.szzxol.pro.essential.messages.MsgError.MsgErrorArgs;
import static cn.szzxol.pro.essential.messages.MsgError.MsgPlayerNotFound;
import static cn.szzxol.pro.essential.messages.MsgError.MsgTpSelf;
import static cn.szzxol.pro.essential.messages.MsgTip.MsgTphereRequest;
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
            MsgTpSelf(player);
            return;
        }
        String Name = player.getName();
        List<Player> AllPlayers = new ArrayList<>();
        AllPlayers.addAll(Bukkit.getServer().getOnlinePlayers());
        for (Player target : AllPlayers) {
            if (TargetName == null ? false : (TargetName.equalsIgnoreCase(target.getName()) || target.getName().toLowerCase().startsWith(TargetName.toLowerCase()))) {
                YamlConfiguration config = getConfiguration("/players/" + TargetName);
                config.set("Request.TPATYPE", 2);
                config.set("Request.TPA", Name);
                saveConfiguration(config, "/players/" + TargetName);
                MsgTphereRequest(player, target);
                return;
            }
        }
        MsgPlayerNotFound(player, TargetName);
        return;
    }
}
