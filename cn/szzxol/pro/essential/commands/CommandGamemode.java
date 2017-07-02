package cn.szzxol.pro.essential.commands;

import static cn.szzxol.pro.essential.messages.MsgError.MsgErrorArgs;
import static cn.szzxol.pro.essential.messages.MsgError.MsgPlayerNotFound;
import static cn.szzxol.pro.essential.messages.MsgTip.MsgGamemode;
import java.util.ArrayList;
import java.util.List;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.entity.Player;

/**
 *
 * @author I_promise
 */
public class CommandGamemode {

    public static boolean CommandGamemode(Player player, Command cmd, String label, String[] args) {
        if (args.length < 1) {
            MsgErrorArgs(player);
            return true;
        } else if (args.length == 1) {
            try {
                int number = Integer.valueOf(args[0]);
            } catch (Exception e) {
                MsgErrorArgs(player);
                return true;
            }
            if (Integer.valueOf(args[0]) < 0 || Integer.valueOf(args[0]) > 1) {
                MsgErrorArgs(player);
                return true;
            }
            setGamemode(player, Integer.valueOf(args[0]));
            MsgGamemode(player, player);
            return true;
        } else if (args.length == 2) {
            List<Player> AllPlayers = new ArrayList<>();
            AllPlayers.addAll(Bukkit.getServer().getOnlinePlayers());
            for (Player target : AllPlayers) {
                if (args[0].equals(target.getName())) {
                    try {
                        int number = Integer.valueOf(args[1]);
                    } catch (Exception e) {
                        MsgErrorArgs(player);
                        return true;
                    }
                    if (Integer.valueOf(args[1]) < 0 || Integer.valueOf(args[1]) > 1) {
                        MsgErrorArgs(player);
                        return true;
                    }
                    setGamemode(target, Integer.valueOf(args[1]));
                    MsgGamemode(player, target);
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

    public static void setGamemode(Player player, int index) {
        switch (index) {
            case 0:
                player.setGameMode(GameMode.SURVIVAL);
                return;
            case 1:
                player.setGameMode(GameMode.CREATIVE);
                return;
            case 2:
                player.setGameMode(GameMode.ADVENTURE);
                return;
            case 3:
                player.setGameMode(GameMode.SPECTATOR);
                return;
            default:
                player.setGameMode(GameMode.SURVIVAL);
        }
    }
}
