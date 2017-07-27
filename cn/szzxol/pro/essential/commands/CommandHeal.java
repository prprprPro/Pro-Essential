package cn.szzxol.pro.essential.commands;

import static cn.szzxol.pro.essential.messages.MsgError.MsgErrorArgs;
import static cn.szzxol.pro.essential.messages.MsgError.MsgPlayerNotFound;
import static cn.szzxol.pro.essential.messages.MsgTip.MsgHeal;
import java.util.ArrayList;
import java.util.List;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.entity.Player;

/**
 *
 * @author I_promise
 */
public class CommandHeal {

    public static boolean CommandHeal(Player player, Command cmd, String label, String[] args) {
        switch (args.length) {
            case 0:
                Heal(player, player.getName());
                return true;
            case 1:
                Heal(player, args[0]);
                return true;
            default:
                MsgErrorArgs(player);
                return true;
        }
    }

    public static void Heal(Player player, String TargetName) {
        List<Player> AllPlayers = new ArrayList<>();
        AllPlayers.addAll(Bukkit.getServer().getOnlinePlayers());
        for (Player target : AllPlayers) {
            if (TargetName == null ? false : TargetName.equals(target.getName()) || target.getName().toLowerCase().startsWith(TargetName)) {
                target.setHealth(target.getMaxHealth());
                MsgHeal(player, target);
                return;
            }
        }
        MsgPlayerNotFound(player, TargetName);
        return;
    }
}
