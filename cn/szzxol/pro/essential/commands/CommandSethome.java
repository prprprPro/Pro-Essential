package cn.szzxol.pro.essential.commands;

import static cn.szzxol.pro.essential.Essential.DefaultConfig;
import static cn.szzxol.pro.essential.commands.CommandHome.MaxAmountOfHome;
import static cn.szzxol.pro.essential.messages.MsgError.MsgErrorArgs;
import static cn.szzxol.pro.essential.messages.MsgShow.MsgShowHomeList;
import static cn.szzxol.pro.essential.messages.MsgTip.MsgHomeSet;
import static cn.szzxol.pro.essential.messages.MsgTip.MsgisSettingHome;
import static cn.szzxol.pro.essential.utils.Configuration.getConfiguration;
import static cn.szzxol.pro.essential.utils.Configuration.saveConfiguration;
import org.bukkit.command.Command;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

/**
 *
 * @author I_promise
 */
public class CommandSethome {

    public static boolean CommandSetHome(Player player, Command cmd, String label, String[] args) {
        String Name = player.getName();
        YamlConfiguration config = getConfiguration("/players/" + Name);
        if (args.length < 1) {
            config.set("Home.isSettingHome", true);
            saveConfiguration(config, "/players/" + Name);
            MsgisSettingHome(player);
            MsgShowHomeList(player);
            return true;
        } else if (args.length == 1) {
            setHomeProcess(player, args[0]);
            return true;
        } else {
            MsgErrorArgs(player);
            return true;
        }
    }

    public static void setHomeProcess(Player player, String msg) {
        String Name = player.getName();
        YamlConfiguration config = getConfiguration("/players/" + Name);
        config.set("Home.isSettingHome", false);
        saveConfiguration(config, "/players/" + player.getName());
        try {
            int number = Integer.valueOf(msg);
        } catch (Exception e) {
            MsgErrorArgs(player);
            return;
        }
        if (Integer.valueOf(msg) < 1 || Integer.valueOf(msg) > MaxAmountOfHome) {
            MsgErrorArgs(player);
            return;
        }
        setHome(player, Integer.valueOf(msg));
    }

    public static void setHome(Player player, int index) {
        String Name = player.getName();
        YamlConfiguration config = getConfiguration("/players/" + Name);
        config.set("Home." + index + ".set", true);
        config.set("Home." + index + ".world", player.getLocation().getWorld().getName());
        config.set("Home." + index + ".x", player.getLocation().getX());
        config.set("Home." + index + ".y", player.getLocation().getY());
        config.set("Home." + index + ".z", player.getLocation().getZ());
        config.set("Home." + index + ".yaw", player.getLocation().getYaw());
        config.set("Home." + index + ".pitch", player.getLocation().getPitch());
        saveConfiguration(config, "/players/" + Name);
        MsgHomeSet(player);
    }
}
