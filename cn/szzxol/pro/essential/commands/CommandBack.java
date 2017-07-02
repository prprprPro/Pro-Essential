package cn.szzxol.pro.essential.commands;

import static cn.szzxol.pro.essential.messages.MsgTip.MsgBack;
import static cn.szzxol.pro.essential.utils.Configuration.getConfiguration;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

/**
 *
 * @author I_promise
 */
public class CommandBack {

    public static boolean CommandBack(Player player, Command cmd, String label, String[] args) {
        PlayerBack(player);
        MsgBack(player);
        return true;
    }

    public static void PlayerBack(Player player) {
        YamlConfiguration config = getConfiguration("/players/" + player.getName());
        World world = player.getWorld();
        Location LocationTo = new Location(world, config.getDouble("LastPosition.x"), config.getDouble("LastPosition.y"), config.getDouble("LastPosition.z"), (float) config.getDouble("LastPosition.yaw"), (float) config.getDouble("LastPosition.pitch"));
        player.teleport(LocationTo);
    }
}
