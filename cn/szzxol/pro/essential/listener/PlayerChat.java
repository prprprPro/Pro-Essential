package cn.szzxol.pro.essential.listener;

import static cn.szzxol.pro.essential.commands.CommandSethome.setHome;
import static cn.szzxol.pro.essential.Essential.DefaultConfig;
import static cn.szzxol.pro.essential.messages.MsgError.MsgErrorArgs;
import static cn.szzxol.pro.essential.utils.Configuration.getConfiguration;
import static cn.szzxol.pro.essential.utils.Configuration.saveConfiguration;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

/**
 *
 * @author I_promise
 */
public class PlayerChat implements Listener {

    @EventHandler
    public void PlayerChat(AsyncPlayerChatEvent event) {
        Player player = event.getPlayer();
        String Name = player.getName();
        YamlConfiguration config = getConfiguration("/players/" + Name);
        if (config.getBoolean("Home.isSettingHome") == true) {
            config.set("Home.isSettingHome", false);
            saveConfiguration(config, "/players/" + player.getName());
            String msg = event.getMessage();
            try {
                float number = Integer.valueOf(msg);
            } catch (Exception e) {
                MsgErrorArgs(player);
                return;
            }
            if (Integer.valueOf(msg) < 1 || Integer.valueOf(msg) > DefaultConfig.getInt("Settings.MaxAmountOfHome")) {
                MsgErrorArgs(player);
                return;
            }
            setHome(player, Integer.valueOf(msg));
            event.setCancelled(true);
        }
        event.setMessage(event.getMessage().replace(Name, (new StringBuilder()).append(ChatColor.GREEN).append(Name).toString()));
    }

}
