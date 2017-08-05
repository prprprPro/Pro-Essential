package cn.szzxol.pro.essential.commands;

import static cn.szzxol.pro.essential.messages.MsgError.MsgErrorArgs;
import static cn.szzxol.pro.essential.messages.MsgError.MsgPlayerNotFound;
import static cn.szzxol.pro.essential.messages.MsgTip.MsgExp;
import static cn.szzxol.pro.essential.permission.Permission.isPermised;
import java.util.ArrayList;
import java.util.List;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.entity.Player;

/**
 *
 * @author I_promise
 */
public class CommandExp {

    public static boolean CommandExp(Player player, Command cmd, String label, String[] args) {
        switch (args.length) {
            case 1:
                if (isPermised(player, "level")) {
                    String Target = args[0];
                    List<Player> Players = new ArrayList<>();
                    Players.addAll(Bukkit.getServer().getOnlinePlayers());
                    for (Player target : Players) {
                        if (Target == null ? false : (Target.equalsIgnoreCase(target.getName()) || target.getName().toLowerCase().startsWith(Target.toLowerCase()))) {
                            MsgExp(player, target);
                            return true;
                        }
                    }
                    MsgPlayerNotFound(player, Target);
                    return true;
                }
            default:
                MsgExp(player, player);
                return true;
        }
    }
}
