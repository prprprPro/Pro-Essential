package cn.szzxol.pro.essential.commands;

import static cn.szzxol.pro.essential.messages.MsgTip.MsgNight;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.entity.Player;

/**
 *
 * @author I_promise
 */
public class CommandNight {
    
    public static boolean CommandNight(Player player, Command cmd, String label, String[] args) {
        World world = player.getWorld();
        world.setTime(18000L);
        MsgNight(player);
        return true;
    }
}
