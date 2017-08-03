package cn.szzxol.pro.essential.messages;

import static cn.szzxol.pro.essential.Essential.DefaultConfig;
import static cn.szzxol.pro.essential.commands.CommandHome.MaxAmountOfHome;
import static cn.szzxol.pro.essential.utils.Configuration.getConfiguration;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

/**
 *
 * @author I_promise
 */
public class MsgShow {

    public static void MsgShowHomeList(Player player) {
        player.sendMessage((new StringBuilder()).append(ChatColor.WHITE).append("").toString());
        player.sendMessage((new StringBuilder()).append(ChatColor.WHITE).append("########Home列表########").toString());
        YamlConfiguration config = getConfiguration("/players/" + player.getName());
        for (int index = 1; index <= MaxAmountOfHome; index++) {
            if (config.getBoolean("Home." + index + ".set") == true) {
                player.sendMessage((new StringBuilder()).append(ChatColor.GOLD).append("序号：").append(ChatColor.WHITE).append(ShowBlank(index, String.valueOf(MaxAmountOfHome).length() + 2)).append(ChatColor.GOLD).append(" 坐标：").append(ChatColor.WHITE).append("（").append((int) config.getDouble("Home." + index + ".x")).append("，").append((int) config.getDouble("Home." + index + ".y")).append("，").append((int) config.getDouble("Home." + index + ".y")).append("）").toString());
            } else {
                player.sendMessage((new StringBuilder()).append(ChatColor.GOLD).append("序号：").append(ChatColor.WHITE).append(ShowBlank(index, String.valueOf(MaxAmountOfHome).length() + 2)).append(ChatColor.GOLD).append(" 坐标：").append(ChatColor.WHITE).append("未设置").toString());
            }
        }
        player.sendMessage((new StringBuilder()).append(ChatColor.WHITE).append("########Home列表########").toString());
        player.sendMessage((new StringBuilder()).append(ChatColor.WHITE).append("").toString());
    }

    public static String ShowBlank(int num, int length) {
        String msg = num + "";
        if (length < msg.length()) {
            return "";
        } else {
            for (int i = msg.length(); i < length; i++) {
                msg += " ";
            }
            return msg;
        }
    }
}
