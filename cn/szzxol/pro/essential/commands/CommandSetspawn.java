package cn.szzxol.pro.essential.commands;

import static cn.szzxol.pro.essential.messages.MsgTip.MsgSpawnSet;
import static cn.szzxol.pro.essential.utils.Configuration.getConfiguration;
import static cn.szzxol.pro.essential.utils.Configuration.saveConfiguration;
import org.bukkit.command.Command;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

/**
 *
 * @author I_promise
 */
public class CommandSetspawn {

    public static boolean CommandSetspawn(Player player, Command cmd, String label, String[] args) {
        setSpawn(player);
        return true;
    }

    public static void setSpawn(Player player) {
        YamlConfiguration config = getConfiguration("spawn");
        config.set("Position.world", player.getLocation().getWorld().getName());
        config.set("Position.x", player.getLocation().getX());
        config.set("Position.y", player.getLocation().getY());
        config.set("Position.z", player.getLocation().getZ());
        config.set("Position.yaw", player.getLocation().getYaw());
        config.set("Position.pitch", player.getLocation().getPitch());
        saveConfiguration(config, "spawn");
        MsgSpawnSet(player);
    }
}
