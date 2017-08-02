package cn.szzxol.pro.essential.commands;

import static cn.szzxol.pro.essential.messages.MsgTip.MsgDay;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.entity.Player;

/**
 *
 * @author I_promise
 */
public class CommandDay {
    
    public static boolean CommandDay(Player player, Command cmd, String label, String[] args) {
        World world = player.getWorld();
        world.setTime(6000L);
        MsgDay(player);
        return true;
    }
}
