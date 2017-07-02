package cn.szzxol.pro.essential.commands;

import static cn.szzxol.pro.essential.Essential.DefaultConfig;
import static cn.szzxol.pro.essential.messages.MsgError.MsgErrorArgs;
import static cn.szzxol.pro.essential.messages.MsgError.MsgHomeNotSet;
import static cn.szzxol.pro.essential.messages.MsgTip.MsgBack;
import static cn.szzxol.pro.essential.messages.MsgTip.MsgHome;
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
public class CommandHome {

    public static boolean CommandHome(Player player, Command cmd, String label, String[] args) {
        if (args.length < 1) {
            PlayerHome(player, 1);
            return true;
        } else if (args.length == 1) {
            try {
                float number = Integer.valueOf(args[0]);
            } catch (Exception e) {
                MsgErrorArgs(player);
                return true;
            }
            if (Integer.valueOf(args[0]) < 0 || Integer.valueOf(args[0]) > DefaultConfig.getInt("Settings.MaxAmountOfHome")) {
                MsgErrorArgs(player);
                return true;
            }
            PlayerHome(player, Integer.valueOf(args[0]));
            return true;
        } else {
            MsgErrorArgs(player);
            return true;
        }
    }

    public static void PlayerHome(Player player, int index) {
        YamlConfiguration config = getConfiguration("/players/" + player.getName());
        if (config.getBoolean("Home." + index + ".set") == true) {
            World world = player.getWorld();
            Location LocationTo = new Location(world, config.getDouble("Home." + index + ".x"), config.getDouble("Home." + index + ".y"), config.getDouble("Home." + index + ".z"), (float) config.getDouble("Home." + index + ".yaw"), (float) config.getDouble("Home." + index + ".pitch"));
            player.teleport(LocationTo);
            MsgHome(player);
        } else {
            MsgHomeNotSet(player);
        }
    }
}
