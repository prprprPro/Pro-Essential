package cn.szzxol.pro.essential.listener;

import java.io.File;
import java.io.IOException;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import cn.szzxol.pro.essential.Essential;
import static cn.szzxol.pro.essential.utils.Configuration.getConfiguration;
import static cn.szzxol.pro.essential.utils.Configuration.saveConfiguration;
import org.bukkit.Location;

/**
 *
 * @author I_promise
 */
public class PlayerJoin implements Listener {

    @EventHandler
    public void Playerjoin(PlayerJoinEvent evt) {
        Player player = evt.getPlayer();
        checkplayerfile(player);
    }

    public void checkplayerfile(Player player) {
        String Name = player.getName();
        File checkfile = new File(Essential.instance.getDataFolder() + "/players/", Name + ".yml");
        if (!checkfile.getParentFile().exists()) {
            checkfile.getParentFile().mkdirs();
        }
        if (!checkfile.exists()) {
            try {
                checkfile.createNewFile();
                YamlConfiguration config = getConfiguration("/players/" + Name);
                config.set("Name", Name);
                saveConfiguration(config, "/players/" + Name);
            } catch (IOException e) {
            }
        }
        Location Location = player.getLocation();
        YamlConfiguration config = getConfiguration("/players/" + Name);
        config.set("LastPosition.x", Location.getX());
        config.set("LastPosition.y", Location.getY());
        config.set("LastPosition.z", Location.getZ());
        config.set("LastPosition.yaw", Location.getYaw());
        config.set("LastPosition.pitch", Location.getPitch());
        saveConfiguration(config, "/players/" + Name);
    }

}
