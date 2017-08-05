package cn.szzxol.pro.essential.commands;

import static cn.szzxol.pro.essential.messages.MsgError.MsgErrorArgs;
import static cn.szzxol.pro.essential.messages.MsgError.MsgPlayerNotFound;
import static cn.szzxol.pro.essential.messages.MsgTip.MsgExp;
import static cn.szzxol.pro.essential.messages.MsgTip.MsgHeal;
import static cn.szzxol.pro.essential.messages.MsgTip.MsgTp;
import java.util.ArrayList;
import java.util.List;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.entity.Player;

/**
 *
 * @author I_promise
 */
public class CommandLevel {

    public static boolean CommandLevel(Player player, Command cmd, String label, String[] args) {
        switch (args.length) {
            case 0:
                MsgExp(player, player);
                return true;
            case 1:
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
            case 3:
                String TargetName = args[1];
                List<Player> AllPlayers = new ArrayList<>();
                AllPlayers.addAll(Bukkit.getServer().getOnlinePlayers());
                for (Player target : AllPlayers) {
                    if (TargetName == null ? false : (TargetName.equalsIgnoreCase(target.getName()) || target.getName().toLowerCase().startsWith(TargetName.toLowerCase()))) {
                        try {
                            int number = Integer.valueOf(args[2]);
                        } catch (Exception e) {
                            MsgErrorArgs(player);
                            return true;
                        }
                        switch (args[0]) {
                            case "add":
                                Leveladd(target, Integer.valueOf(args[2]));
                                MsgExp(player, target);
                                return true;
                            case "remove":
                                Leveladd(target, -Integer.valueOf(args[2]));
                                MsgExp(player, target);
                                return true;
                            case "set":
                                Levelset(target, Integer.valueOf(args[2]));
                                MsgExp(player, target);
                                return true;
                        }
                    }
                }
                MsgPlayerNotFound(player, TargetName);
                return true;
            default:
                MsgErrorArgs(player);
                return true;
        }
    }

    public static void Leveladd(Player player, int level) {
        player.setLevel(player.getLevel() + level);
        player.setExp(0f);
    }

    public static void Levelset(Player player, int level) {
        player.setLevel(level);
        player.setExp(0f);
    }
}
