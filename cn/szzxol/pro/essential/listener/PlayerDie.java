package cn.szzxol.pro.essential.listener;

import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import static cn.szzxol.pro.essential.utils.Configuration.getConfiguration;
import static cn.szzxol.pro.essential.utils.Configuration.saveConfiguration;
import org.bukkit.Location;
import org.bukkit.event.entity.PlayerDeathEvent;

/**
 *
 * @author I_promise
 */
public class PlayerDie implements Listener {

    @EventHandler
    public void Playerjoin(PlayerDeathEvent evt) {
        Player player = evt.getEntity();
        String Name = player.getName();
        Location LocationFrom = player.getLocation();
        YamlConfiguration config = getConfiguration("/players/" + Name);
        config.set("LastPosition.world", LocationFrom.getWorld().getName());
        config.set("LastPosition.x", LocationFrom.getX());
        config.set("LastPosition.y", LocationFrom.getY());
        config.set("LastPosition.z", LocationFrom.getZ());
        config.set("LastPosition.yaw", LocationFrom.getYaw());
        config.set("LastPosition.pitch", LocationFrom.getPitch());
        saveConfiguration(config, "/players/" + Name);
    }

}
