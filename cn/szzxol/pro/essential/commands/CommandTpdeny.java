package cn.szzxol.pro.essential.commands;

import static cn.szzxol.pro.essential.utils.Configuration.getConfiguration;
import static cn.szzxol.pro.essential.utils.Configuration.saveConfiguration;
import static cn.szzxol.pro.essential.messages.MsgError.MsgNoTeleportRequest;
import static cn.szzxol.pro.essential.messages.MsgTip.MsgTpDeny;
import java.util.ArrayList;
import java.util.List;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

/**
 *
 * @author I_promise
 */
public class CommandTpdeny {

    public static boolean CommandTpadeny(Player player, Command cmd, String label, String[] args) {
        TPDeny(player);
        return true;
    }

    public static void TPDeny(Player player) {
        YamlConfiguration config = getConfiguration("/players/" + player.getName());
        String Name = config.getString("Request.TPA");
        if (!"".equals(Name)) {
            List<Player> AllPlayers = new ArrayList<>();
            AllPlayers.addAll(Bukkit.getServer().getOnlinePlayers());
            for (Player target : AllPlayers) {
                if (Name == null ? false : Name.equals(target.getName())) {
                    MsgTpDeny(player, target);
                    config.set("Request.TPA", "");
                    saveConfiguration(config, "/players/" + player.getName());
                    return;
                }
            }
            MsgNoTeleportRequest(player);
        } else {
            MsgNoTeleportRequest(player);
        }
    }
}
