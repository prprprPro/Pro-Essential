package cn.szzxol.pro.essential;

import static cn.szzxol.pro.essential.commands.CommandExecute.CommandExecute;
import cn.szzxol.pro.essential.listener.InventoryClick;
import cn.szzxol.pro.essential.listener.PlayerChat;
import cn.szzxol.pro.essential.listener.PlayerJoin;
import cn.szzxol.pro.essential.listener.PlayerQuit;
import cn.szzxol.pro.essential.listener.PlayerTeleport;
import static cn.szzxol.pro.essential.utils.Configuration.getConfiguration;
import static cn.szzxol.pro.essential.utils.Configuration.saveDefaultYaml;
import static cn.szzxol.pro.essential.utils.Configuration.updatePermissionConfiguration;
import java.io.File;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

/**
 *
 * @author I_promise
 */
public class Essential extends JavaPlugin {

    public static FileConfiguration DefaultConfig;
    public static YamlConfiguration Perm;
    public static YamlConfiguration SpawnLocation;
    public static String version;
    public static File folder;

    @Override
    public void onEnable() {
        getLogger().info("插件正在加载...");
        this.saveDefaultConfig();
        folder = this.getDataFolder();
        DefaultConfig = this.getConfig();
        version = DefaultConfig.getString("Version");
        initial();
        SpawnLocation = getConfiguration("spawn");
        Perm = getConfiguration("Permission");
        updatePermissionConfiguration();
        getLogger().info("插件加载完成...");
    }

    public void initial() {
        getServer().getPluginManager().registerEvents(new PlayerChat(), this);
        getServer().getPluginManager().registerEvents(new PlayerJoin(), this);
        getServer().getPluginManager().registerEvents(new PlayerQuit(), this);
        getServer().getPluginManager().registerEvents(new PlayerTeleport(), this);
        getServer().getPluginManager().registerEvents(new InventoryClick(), this);
        saveDefaultYaml("spawn");
        saveDefaultYaml("Permission");
    }

    @Override
    public void onDisable() {
        getLogger().info("插件卸载完成...");
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        CommandExecute(sender, cmd, label, args);
        return true;
    }

    public static Essential instance;

    public Essential() {
        instance = this;
    }

}
