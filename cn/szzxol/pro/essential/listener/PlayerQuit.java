package cn.szzxol.pro.essential.listener;

import static cn.szzxol.pro.essential.utils.Configuration.getConfiguration;
import static cn.szzxol.pro.essential.utils.Configuration.saveConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

/**
 *
 * @author I_promise
 */
public class PlayerQuit implements Listener {

    @EventHandler
    public void PlayerQuit(PlayerQuitEvent evt) {
        Player player = evt.getPlayer();
        clearFile(player);
    }

    public void clearFile(Player player) {
        String Name = player.getName();
        YamlConfiguration config = getConfiguration("/players/" + Name);
        config.set("Position.TPA", "");
        saveConfiguration(config, "/players/" + Name);
    }
}
