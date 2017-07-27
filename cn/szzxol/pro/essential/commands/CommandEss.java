package cn.szzxol.pro.essential.commands;

import cn.szzxol.pro.essential.Essential;
import static cn.szzxol.pro.essential.Essential.DefaultConfig;
import static cn.szzxol.pro.essential.Essential.Perm;
import static cn.szzxol.pro.essential.Essential.SpawnLocation;
import static cn.szzxol.pro.essential.Essential.folder;
import static cn.szzxol.pro.essential.Essential.version;
import static cn.szzxol.pro.essential.messages.MsgTip.MsgReload;
import static cn.szzxol.pro.essential.utils.Configuration.getConfiguration;
import org.bukkit.command.Command;
import org.bukkit.entity.Player;

/**
 *
 * @author I_promise
 */
public class CommandEss {

    public static boolean CommandEss(Player player, Command cmd, String label, String[] args) {
        if (args[0].equalsIgnoreCase("reload")) {
            folder = Essential.instance.getDataFolder();
            DefaultConfig = Essential.instance.getConfig();
            version = DefaultConfig.getString("Version");
            SpawnLocation = getConfiguration("spawn");
            Perm = getConfiguration("Permission");
            MsgReload(player);
        }
        return true;
    }
}
