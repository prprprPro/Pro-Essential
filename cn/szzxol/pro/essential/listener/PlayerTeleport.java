package cn.szzxol.pro.essential.listener;

import static cn.szzxol.pro.essential.utils.Configuration.getConfiguration;
import static cn.szzxol.pro.essential.utils.Configuration.saveConfiguration;
import org.bukkit.Location;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerTeleportEvent;

/**
 *
 * @author I_promise
 */
public class PlayerTeleport implements Listener {

    @EventHandler
    public void PlayerTeleport(PlayerTeleportEvent event) {
        String Name = event.getPlayer().getName();
        Location LocationFrom = event.getFrom();
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
