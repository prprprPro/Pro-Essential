package cn.szzxol.pro.essential.listener;

import static cn.szzxol.pro.essential.Essential.DefaultConfig;
import static cn.szzxol.pro.essential.commands.CommandSethome.setHomeProcess;
import static cn.szzxol.pro.essential.utils.Configuration.getConfiguration;
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
            String msg = event.getMessage();
            setHomeProcess(player, msg);
            event.setCancelled(true);
            return;
        }
        String format = DefaultConfig.getString("Settings.Chat.ChatFormat").replace("%player%", "%1$s").replace("%msg%", "%2$s");
        event.setFormat(format);
    }

}
