package cn.szzxol.pro.essential.commands;

import static cn.szzxol.pro.essential.utils.Configuration.getConfiguration;
import static cn.szzxol.pro.essential.utils.Configuration.saveConfiguration;
import static cn.szzxol.pro.essential.messages.MsgError.MsgNoTeleportRequest;
import java.util.ArrayList;
import java.util.List;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

/**
 *
 * @author I_promise
 */
public class CommandTpaccept {

    public static boolean CommandTpaccept(Player player, Command cmd, String label, String[] args) {
        TPAccept(player);
        return true;
    }

    public static void TPAccept(Player player) {
        YamlConfiguration config = getConfiguration("/players/" + player.getName());
        String Name = config.getString("Request.TPA");
        if (!"".equals(Name)) {
            List<Player> AllPlayers = new ArrayList<>();
            AllPlayers.addAll(Bukkit.getServer().getOnlinePlayers());
            for (Player target : AllPlayers) {
                if (Name == null ? false : Name.equals(target.getName())) {
                    player.sendMessage((new StringBuilder()).append(ChatColor.GOLD).append("你已接受 ").append(Name).append(" 的传送请求").toString());
                    target.sendMessage((new StringBuilder()).append(ChatColor.GOLD).append(player.getName()).append(" 接受了你的传送请求").toString());
                    target.sendMessage((new StringBuilder()).append(ChatColor.GOLD).append("正在传送...").toString());
                    switch (config.getInt("Request.TPATYPE")) {
                        case 1:
                            target.teleport(player);
                        case 2:
                            player.teleport(target);
                    }
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
