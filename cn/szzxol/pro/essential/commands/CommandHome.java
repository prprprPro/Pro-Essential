package cn.szzxol.pro.essential.commands;

import static cn.szzxol.pro.essential.Essential.DefaultConfig;
import static cn.szzxol.pro.essential.messages.MsgError.MsgErrorArgs;
import static cn.szzxol.pro.essential.messages.MsgError.MsgHomeNotSet;
import static cn.szzxol.pro.essential.messages.MsgTip.MsgGoHome;
import static cn.szzxol.pro.essential.messages.MsgTip.MsgHome;
import static cn.szzxol.pro.essential.utils.Configuration.getConfiguration;
import static cn.szzxol.pro.essential.utils.InventoryUtils.CreateInventory;
import static java.util.Arrays.asList;
import java.util.LinkedList;
import java.util.List;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

/**
 *
 * @author I_promise
 */
public class CommandHome {

    public static int MaxAmountOfHome = DefaultConfig.getInt("Settings.Home.MaxAmountOfHome");

    public static boolean CommandHome(Player player, Command cmd, String label, String[] args) {
        if (args.length < 1) {
            switch (DefaultConfig.getInt("Settings.Home.Type")) {
                case 1:
                    MsgGoHome(player);
                    return true;
                case 2:
                    YamlConfiguration config = getConfiguration("/players/" + player.getName());
                    ItemStack[] iss = new ItemStack[MaxAmountOfHome];
                    for (int index = 1; index <= MaxAmountOfHome; index++) {
                        if (config.getBoolean("Home." + index + ".set") == true) {
                            ItemStack is = new ItemStack(Material.BED);
                            ItemMeta im = is.getItemMeta();
                            im.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&b&l家" + index));
                            List list = new LinkedList<>(asList(ChatColor.translateAlternateColorCodes('&', "&f&l世界：" + ((config.getString("Home." + index + ".world") == null) ? "world" : config.getString("Home." + index + ".world"))), ChatColor.translateAlternateColorCodes('&', "&f&l X：(" + (int) config.getDouble("Home." + index + ".x")), ChatColor.translateAlternateColorCodes('&', "&f&l Y：(" + (int) config.getDouble("Home." + index + ".y")), ChatColor.translateAlternateColorCodes('&', "&f&l Z：(" + (int) config.getDouble("Home." + index + ".z"))));
                            im.setLore(list);
                            is.setItemMeta(im);
                            iss[index - 1] = is;
                        }
                    }
                    player.openInventory(CreateInventory("回家", iss));
                    return true;
                default:
                    MsgGoHome(player);
                    return true;
            }
        } else if (args.length == 1) {
            try {
                float number = Integer.valueOf(args[0]);
            } catch (Exception e) {
                MsgErrorArgs(player);
                return true;
            }
            if (Integer.valueOf(args[0]) < 0 || Integer.valueOf(args[0]) > MaxAmountOfHome) {
                MsgErrorArgs(player);
                return true;
            }
            PlayerHome(player, Integer.valueOf(args[0]));
            return true;
        } else {
            MsgErrorArgs(player);
            return true;
        }
    }

    public static void PlayerHome(Player player, int index) {
        YamlConfiguration config = getConfiguration("/players/" + player.getName());
        if (config.getBoolean("Home." + index + ".set") == true) {
            String pw = config.getString("Home." + index + ".world") == null ? "world" : config.getString("Home." + index + ".world");
            World world = Bukkit.getWorld(pw) == null ? Bukkit.getWorld("world") : Bukkit.getWorld(pw);
            Location LocationTo = new Location(world, config.getDouble("Home." + index + ".x"), config.getDouble("Home." + index + ".y"), config.getDouble("Home." + index + ".z"), (float) config.getDouble("Home." + index + ".yaw"), (float) config.getDouble("Home." + index + ".pitch"));
            player.teleport(LocationTo);
            MsgHome(player);
        } else {
            MsgHomeNotSet(player);
        }
    }
}
