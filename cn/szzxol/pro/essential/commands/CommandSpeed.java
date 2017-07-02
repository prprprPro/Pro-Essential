package cn.szzxol.pro.essential.commands;

import static cn.szzxol.pro.essential.messages.MsgError.MsgErrorArgs;
import static cn.szzxol.pro.essential.messages.MsgError.MsgPlayerNotFound;
import static cn.szzxol.pro.essential.messages.MsgTip.MsgSpeed;
import java.util.ArrayList;
import java.util.List;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.entity.Player;

/**
 *
 * @author I_promise
 */
public class CommandSpeed {

    public static boolean CommandSpeed(Player player, Command cmd, String label, String[] args) {
        if (args.length < 1) {
            MsgErrorArgs(player);
            return true;
        } else if (args.length == 1) {
            try {
                float number = Float.valueOf(args[0]);
            } catch (Exception e) {
                MsgErrorArgs(player);
                return true;
            }
            if (Float.valueOf(args[0]) < 0 || Float.valueOf(args[0]) > 10) {
                MsgErrorArgs(player);
                return true;
            }
            speed(player, Float.valueOf(args[0]));
            MsgSpeed(player, player, Float.valueOf(args[0]));
            return true;
        } else if (args.length == 2) {
            List<Player> AllPlayers = new ArrayList<>();
            AllPlayers.addAll(Bukkit.getServer().getOnlinePlayers());
            for (Player target : AllPlayers) {
                if (args[0].equals(target.getName())) {
                    try {
                        float number = Float.valueOf(args[1]);
                    } catch (Exception e) {
                        MsgErrorArgs(player);
                        return true;
                    }
                    if (Float.valueOf(args[1]) < 0 || Float.valueOf(args[1]) > 10) {
                        MsgErrorArgs(player);
                        return true;
                    }
                    speed(target, Float.valueOf(args[1]));
                    MsgSpeed(player, target, Float.valueOf(args[1]));
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

    public static void speed(Player player, float speed) {
        if (player.isFlying()) {
            player.setFlySpeed(speed / 10);
        } else {
            player.setWalkSpeed(speed / 10);
        }
    }
}
