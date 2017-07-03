package cn.szzxol.pro.essential.utils;

import cn.szzxol.pro.essential.Essential;
import static cn.szzxol.pro.essential.Essential.Perm;
import static cn.szzxol.pro.essential.Essential.folder;
import static cn.szzxol.pro.essential.commands.CommandExecute.EO;
import static cn.szzxol.pro.essential.commands.CommandExecute.OP;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import static java.util.Arrays.asList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import static java.util.Objects.hash;
import static org.bukkit.Bukkit.getLogger;
import org.bukkit.configuration.file.YamlConfiguration;

/**
 *
 * @author I_promise
 */
public class Configuration {

    public static YamlConfiguration getConfiguration(String FileName) {
        File Config = new File(folder, FileName + ".yml");
        return YamlConfiguration.loadConfiguration(Config);
    }

    public static void saveConfiguration(YamlConfiguration YamlConfig, String FileName) {
        File Config = new File(folder, FileName + ".yml");
        try {
            YamlConfig.save(Config);
        } catch (IOException ex) {
        }
    }

    public static void saveDefaultYaml(String FileName) {
        File file = new File(folder, FileName + ".yml");
        if (file.exists()) {
            getLogger().info("[pro-Essential] 检测到文件：" + FileName + ".yml");
        } else {
            Essential.instance.saveResource(FileName + ".yml", false);
        }
    }

    public static void updatePermissionConfiguration() {
        List listOP = Perm.getList("Commands.Permission.OP") == null ? new LinkedList<>() : Perm.getList("Commands.Permission.OP");
        List listEO = Perm.getList("Commands.Permission.EveryOne") == null ? new LinkedList<>() : Perm.getList("Commands.Permission.EveryOne");
        for (Object obj : EO) {
            if (!listEO.contains(obj.toString()) && !listOP.contains(obj.toString())) {
                listEO.add(obj.toString());
            }
        }
        for (Object obj : OP) {
            if (!listEO.contains(obj.toString()) && !listOP.contains(obj.toString())) {
                listOP.add(obj.toString());
            }
        }
        Perm.set("Commands.Permission.EveryOne", listEO);
        Perm.set("Commands.Permission.OP", listOP);
        saveConfiguration(Perm, "Permission");
    }

}
